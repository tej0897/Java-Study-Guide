/**
 * Day 15 - Static Keyword: Static Block and Factory Pattern
 *
 * Concept:
 * Static block initializes static variables when class loads.
 * Factory pattern uses static methods to create objects.
 *
 * This example demonstrates:
 * - Static block initialization
 * - Static factory methods
 * - Initialization order
 * - Practical patterns with static
 *
 * Real-life analogy:
 * Static block = Setup before opening for business
 * Factory pattern = Assembly line for creating products
 */
public class StaticBlockAndFactoryExample {

    /**
     * Configuration class using static block
     */
    static class AppConfig {
        static String appName;
        static String appVersion;
        static int maxConnections;

        /**
         * Static block - executed when class loads
         */
        static {
            System.out.println("[Initialization] Loading app configuration...");
            appName = "MyApplication";
            appVersion = "2.0";
            maxConnections = 100;
            System.out.println("[Initialization] Configuration loaded");
        }

        static void displayConfig() {
            System.out.println("App: " + appName + " v" + appVersion);
            System.out.println("Max Connections: " + maxConnections);
        }
    }

    /**
     * DatabaseConnection using factory pattern
     */
    static class DatabaseConnection {
        String type;

        private DatabaseConnection(String type) {
            this.type = type;
        }

        static DatabaseConnection create(String dbType) {
            switch (dbType.toLowerCase()) {
                case "mysql":
                    System.out.println("Creating MySQL connection");
                    return new DatabaseConnection("MySQL");
                case "postgresql":
                    System.out.println("Creating PostgreSQL connection");
                    return new DatabaseConnection("PostgreSQL");
                case "oracle":
                    System.out.println("Creating Oracle connection");
                    return new DatabaseConnection("Oracle");
                default:
                    System.out.println("Unknown database type");
                    return null;
            }
        }

        void connect() {
            System.out.println("Connected to " + type);
        }
    }

    /**
     * Logger using factory pattern and counter
     */
    static class Logger {
        private static int logCount = 0;

        static {
            System.out.println("[Initialization] Logger initialized");
        }

        static void log(String message) {
            logCount++;
            System.out.println("[" + logCount + "] " + message);
        }

        static int getLogCount() {
            return logCount;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("=== Static Block and Factory Pattern ===\n");

        System.out.println("--- Loading AppConfig (triggers static block) ---");
        AppConfig.displayConfig();

        System.out.println("\n--- Using Factory Pattern ---");
        DatabaseConnection conn1 = DatabaseConnection.create("mysql");
        if (conn1 != null) {
            conn1.connect();
        }

        DatabaseConnection conn2 = DatabaseConnection.create("postgresql");
        if (conn2 != null) {
            conn2.connect();
        }

        System.out.println("\n--- Using Logger (static block + methods) ---");
        Logger.log("Application started");
        Logger.log("Processing request");
        Logger.log("Request completed");
        System.out.println("Total logs: " + Logger.getLogCount());

        System.out.println("\n--- Key Patterns ---");
        System.out.println("1. Static block: One-time initialization");
        System.out.println("2. Factory method: create() returns configured object");
        System.out.println("3. Private constructor: Prevents direct instantiation");
        System.out.println("4. Static counter: Tracks usage across all instances");

    }

}


