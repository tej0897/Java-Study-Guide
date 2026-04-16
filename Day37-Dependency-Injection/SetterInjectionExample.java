/**
 * Day 37 - Dependency Injection: Setter Injection
 */
public class SetterInjectionExample {

    interface Logger {
        void log(String message);
    }

    static class ConsoleLogger implements Logger {
        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    static class Application {
        private Logger logger;

        // Setter Injection
        void setLogger(Logger logger) {
            this.logger = logger;
        }

        void run() {
            logger.log("Application running");
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setLogger(new ConsoleLogger());
        app.run();
    }
}


