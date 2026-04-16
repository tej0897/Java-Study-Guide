/**
 * Day 16 - Final Keyword: Variables and Constants
 *
 * Concept:
 * final keyword prevents modification of variables, overriding of methods,
 * and extension of classes.
 *
 * This example demonstrates:
 * - final variables as constants
 * - Initialization rules
 * - Immutable patterns
 */
class FinalKeywordExample {

    static class Configuration {
        // Final variables - constants
        static final String APP_NAME = "MyApplication";
        static final double VERSION = 2.0;
        static final int MAX_CONNECTIONS = 100;

        // Regular variable (can change)
        static String currentUser = "admin";
    }

    static class User {
        // Instance final variable
        private final String username;
        private final int userId;

        User(String username, int userId) {
            this.username = username;  // Initialize once
            this.userId = userId;
        }

        String getUsername() { return username; }
        // username = "new";  // ERROR: cannot reassign
    }

    public static void main(String[] args) {
        System.out.println("=== Final Keyword Example ===\n");

        System.out.println("--- Final Variables (Constants) ---");
        System.out.println("App: " + Configuration.APP_NAME);
        System.out.println("Version: " + Configuration.VERSION);
        System.out.println("Max Connections: " + Configuration.MAX_CONNECTIONS);

        // Configuration.APP_NAME = "NewApp";  // ERROR: final
        System.out.println("(Cannot modify final variables)\n");

        System.out.println("--- Regular Variables (Can Change) ---");
        System.out.println("Current User: " + Configuration.currentUser);
        Configuration.currentUser = "user123";  // OK: not final
        System.out.println("Current User: " + Configuration.currentUser);

        System.out.println("\n--- Final Instance Variables ---");
        User user = new User("john_doe", 1001);
        System.out.println("Username: " + user.getUsername());
        // user.username = "jane_doe";  // ERROR: final
        System.out.println("(Instance final variables cannot be modified)\n");

        System.out.println("Benefits of final:");
        System.out.println("1. Constants - values that don't change");
        System.out.println("2. Security - prevent modification");
        System.out.println("3. Performance - compiler optimizations");
        System.out.println("4. Intent - documents design intention");
    }
}


