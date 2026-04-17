/**
 * Day 40 - Clean Architecture Basics (Simulation)
 *
 * <p>Shows a simple Controller -> Service -> Repository structure using plain Java.
 * The service depends on a repository interface, which makes testing and swapping
 * implementations easier.
 */

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CleanArchitectureExample {

    // --- Domain
    static class Product {
        final int id;
        final String name;
        final double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
        }
    }

    // --- DTO
    static class ProductResponse {
        final int id;
        final String name;
        final double price;

        ProductResponse(Product p) {
            this.id = p.id;
            this.name = p.name;
            this.price = p.price;
        }

        String toJsonLikeString() {
            return "{\n" +
                    "  \"id\": " + id + ",\n" +
                    "  \"name\": \"" + name + "\",\n" +
                    "  \"price\": " + price + "\n" +
                    "}";
        }
    }

    // --- Exceptions
    static class NotFoundException extends RuntimeException {
        NotFoundException(String message) { super(message); }
    }

    // --- Repository boundary
    interface ProductRepository {
        Product findById(int id);
    }

    // --- Repository implementation (data details)
    static class InMemoryProductRepository implements ProductRepository {
        private final Map<Integer, Product> data = new HashMap<>();

        InMemoryProductRepository() {
            data.put(1, new Product(1, "Laptop", 999.99));
            data.put(2, new Product(2, "Phone", 499.99));
        }

        public Product findById(int id) {
            Product p = data.get(id);
            if (p == null) {
                throw new NotFoundException("Product id=" + id + " not found");
            }
            return p;
        }
    }

    // --- Service (business logic)
    static class ProductService {
        private final ProductRepository repo;

        ProductService(ProductRepository repo) {
            this.repo = repo;
        }

        Product getProductOrThrow(int id) {
            return repo.findById(id);
        }
    }

    // --- Controller (boundary) + simple global error mapping
    static class ProductController {
        private final ProductService service;

        ProductController(ProductService service) {
            this.service = service;
        }

        void getProduct(int id) {
            System.out.println("GET /products/" + id);
            try {
                Product p = service.getProductOrThrow(id);
                System.out.println("200 OK\n" + new ProductResponse(p).toJsonLikeString());
            } catch (NotFoundException e) {
                System.out.println("404 Not Found\n" + errorJson(e.getMessage(), 404));
            } catch (Exception e) {
                System.out.println("500 Internal Server Error\n" + errorJson("Internal error", 500));
            }
        }

        private String errorJson(String message, int status) {
            return "{\n" +
                    "  \"error\": \"" + message + "\",\n" +
                    "  \"status\": " + status + ",\n" +
                    "  \"timestamp\": \"" + Instant.now().toString() + "\"\n" +
                    "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Clean Architecture Basics (Simulation) ===\n");

        ProductRepository repo = new InMemoryProductRepository();
        ProductService service = new ProductService(repo);
        ProductController controller = new ProductController(service);

        controller.getProduct(1);
        System.out.println();
        controller.getProduct(99);

        System.out.println("\nKey Points:");
        System.out.println("1. Controller is thin (input/output + error mapping)");
        System.out.println("2. Service holds business rules and depends on abstractions");
        System.out.println("3. Repository hides data access details");
    }
}

