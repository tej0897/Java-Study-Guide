/**
 * Day 36 - REST API: Service and Repository Pattern
 */
import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class ProductRepository {
    List<Product> products = new ArrayList<>();

    void save(Product p) { products.add(p); }
    Product findById(int id) {
        return products.stream().filter(p -> p.id == id).findFirst().orElse(null);
    }
    List<Product> findAll() { return new ArrayList<>(products); }
}

class ProductService {
    ProductRepository repo = new ProductRepository();

    public void addProduct(Product p) { repo.save(p); }
    public Product getProduct(int id) { return repo.findById(id); }
    public List<Product> getAllProducts() { return repo.findAll(); }
}

public class ServiceRepositoryExample {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        service.addProduct(new Product(1, "Laptop", 999.99));
        service.addProduct(new Product(2, "Phone", 499.99));

        System.out.println("All products:");
        service.getAllProducts().forEach(p ->
            System.out.println("  " + p.name + " - $" + p.price)
        );
    }
}


