/**
 * Day 35 - Spring Boot: Architecture Example
 */

// Simulating Spring Boot layers
class Product {
    public int id;
    public String name;
    public double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// Repository layer
class ProductRepository {
    public Product findById(int id) {
        return new Product(id, "Sample Product", 99.99);
    }
}

// Service layer
class ProductService {
    private ProductRepository repository = new ProductRepository();

    public Product getProduct(int id) {
        return repository.findById(id);
    }
}

// Controller layer
class ProductController {
    private ProductService service = new ProductService();

    public void handleRequest(int id) {
        Product product = service.getProduct(id);
        System.out.println("Product: " + product.name + " - $" + product.price);
    }
}

public class SpringBootArchitectureExample {
    public static void main(String[] args) {
        System.out.println("=== Spring Boot Architecture ===\n");

        ProductController controller = new ProductController();
        controller.handleRequest(1);
    }
}


