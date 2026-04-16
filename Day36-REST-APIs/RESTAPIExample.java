/**
 * Day 36 - REST API: Simulated Controller
 */
import java.util.*;

class User {
    public int id;
    public String name;
    public String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

class UserAPIController {
    private List<User> users = new ArrayList<>();

    public UserAPIController() {
        users.add(new User(1, "John", "john@example.com"));
        users.add(new User(2, "Jane", "jane@example.com"));
    }

    // GET /users
    public List<User> getAllUsers() {
        return users;
    }

    // GET /users/{id}
    public User getUserById(int id) {
        return users.stream()
                .filter(u -> u.id == id)
                .findFirst()
                .orElse(null);
    }

    // POST /users
    public User createUser(String name, String email) {
        int newId = users.size() + 1;
        User user = new User(newId, name, email);
        users.add(user);
        return user;
    }
}

public class RESTAPIExample {
    public static void main(String[] args) {
        System.out.println("=== REST API Simulation ===\n");

        UserAPIController controller = new UserAPIController();

        System.out.println("GET /users:");
        controller.getAllUsers().forEach(u ->
            System.out.println("  " + u.id + ": " + u.name)
        );

        System.out.println("\nGET /users/1:");
        User user = controller.getUserById(1);
        System.out.println("  " + user.name);

        System.out.println("\nPOST /users:");
        User newUser = controller.createUser("Bob", "bob@example.com");
        System.out.println("  Created: " + newUser.name);
    }
}


