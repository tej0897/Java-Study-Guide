/**
 * Day 39 - API Exception Handling (Simulation)
 *
 * <p>This is a plain-Java simulation of common REST API exception handling ideas:
 * <ul>
 *   <li>Custom exceptions</li>
 *   <li>Mapping exceptions to HTTP status codes</li>
 *   <li>Consistent error response payload</li>
 * </ul>
 *
 * <p>In Spring Boot you'd typically use @ControllerAdvice + @ExceptionHandler.
 */

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ApiExceptionHandlingExample {

    // --- Domain / Exceptions
    static class UserNotFoundException extends RuntimeException {
        UserNotFoundException(String message) { super(message); }
    }

    static class ValidationException extends RuntimeException {
        ValidationException(String message) { super(message); }
    }

    // --- Error DTO (typical JSON response)
    static class ApiError {
        final String error;
        final int status;
        final String timestamp;

        ApiError(String error, int status) {
            this.error = error;
            this.status = status;
            this.timestamp = Instant.now().toString();
        }

        String toJsonLikeString() {
            return "{\n" +
                    "  \"error\": \"" + error + "\",\n" +
                    "  \"status\": " + status + ",\n" +
                    "  \"timestamp\": \"" + timestamp + "\"\n" +
                    "}";
        }
    }

    // --- Repository simulation
    static class UserRepository {
        private final Map<Integer, String> users = new HashMap<>();

        UserRepository() {
            users.put(1, "John");
            users.put(2, "Jane");
        }

        String findNameById(int id) {
            String name = users.get(id);
            if (name == null) {
                throw new UserNotFoundException("User with id=" + id + " not found");
            }
            return name;
        }

        void createUser(String name) {
            if (name == null || name.isBlank()) {
                throw new ValidationException("name must be non-blank");
            }
            // pretend we saved it
        }
    }

    // --- Global handler simulation
    static ApiError handle(Throwable t) {
        if (t instanceof ValidationException) {
            return new ApiError(t.getMessage(), 400);
        }
        if (t instanceof UserNotFoundException) {
            return new ApiError(t.getMessage(), 404);
        }
        return new ApiError("Internal Server Error", 500);
    }

    public static void main(String[] args) {
        System.out.println("=== API Exception Handling (Simulation) ===\n");

        UserRepository repo = new UserRepository();

        System.out.println("--- GET /users/1 ---");
        try {
            System.out.println("200 OK: " + repo.findNameById(1));
        } catch (Exception e) {
            System.out.println(handle(e).toJsonLikeString());
        }

        System.out.println("\n--- GET /users/99 ---");
        try {
            System.out.println("200 OK: " + repo.findNameById(99));
        } catch (Exception e) {
            System.out.println(handle(e).toJsonLikeString());
        }

        System.out.println("\n--- POST /users (invalid) ---");
        try {
            repo.createUser("   ");
            System.out.println("201 Created");
        } catch (Exception e) {
            System.out.println(handle(e).toJsonLikeString());
        }

        System.out.println("\nKey Points:");
        System.out.println("1. Map validation errors -> 400");
        System.out.println("2. Map missing resources -> 404");
        System.out.println("3. Use a consistent error payload (error/status/timestamp)");
        System.out.println("4. In Spring: @ControllerAdvice + @ExceptionHandler");
    }
}

