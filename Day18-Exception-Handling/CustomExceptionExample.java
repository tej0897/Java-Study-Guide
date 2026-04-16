/**
 * Day 18 - Exception Handling: Custom Exceptions
 */
public class CustomExceptionExample {

    static class InvalidEmailException extends Exception {
        InvalidEmailException(String message) {
            super(message);
        }
    }

    static void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("Invalid email: missing @");
        }
        if (!email.contains(".")) {
            throw new InvalidEmailException("Invalid email: missing domain");
        }
        System.out.println("Email is valid: " + email);
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Exceptions ===\n");

        String[] emails = {"john@example.com", "invalid-email", "user@", "test@.com"};

        for (String email : emails) {
            try {
                validateEmail(email);
            } catch (InvalidEmailException e) {
                System.out.println("Caught: " + e.getMessage());
            }
        }
    }
}


