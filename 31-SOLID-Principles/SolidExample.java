/**
 * Day 31 - SOLID Principles: Single Responsibility
 */
public class SolidExample {

    static class User {
        String name;
        String email;
        User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    static class UserValidator {
        boolean isValidEmail(String email) {
            return email.contains("@");
        }
    }

    static class UserRepository {
        void save(User user) {
            System.out.println("Saved: " + user.name);
        }
    }

    public static void main(String[] args) {
        User user = new User("John", "john@example.com");
        UserValidator validator = new UserValidator();
        UserRepository repo = new UserRepository();

        if (validator.isValidEmail(user.email)) {
            repo.save(user);
        }
    }
}


