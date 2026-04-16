/**
 * Day 38 - Spring Data JPA: Repository and Service
 */
import java.util.*;

class Order {
    int id;
    String customerName;
    double totalAmount;

    Order(int id, String customerName, double totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }
}

class OrderRepository {
    List<Order> orders = new ArrayList<>();

    void save(Order order) { orders.add(order); }
    Optional<Order> findById(int id) {
        return orders.stream().filter(o -> o.id == id).findFirst();
    }
    List<Order> findAll() { return new ArrayList<>(orders); }
}

class OrderService {
    OrderRepository repo = new OrderRepository();

    void createOrder(Order order) { repo.save(order); }
    Optional<Order> getOrder(int id) { return repo.findById(id); }
    List<Order> getAllOrders() { return repo.findAll(); }
}

public class JPARepositoryExample {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        service.createOrder(new Order(1, "John", 150.00));
        service.createOrder(new Order(2, "Jane", 250.00));

        System.out.println("All Orders:");
        service.getAllOrders().forEach(o ->
            System.out.println("  Order " + o.id + ": " + o.customerName + " - $" + o.totalAmount)
        );
    }
}


