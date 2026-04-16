/**
 * Day 31 - SOLID Principles: Dependency Inversion
 */
public class DependencyInversionExample {

    interface Logger {
        void log(String message);
    }

    static class ConsoleLogger implements Logger {
        public void log(String message) {
            System.out.println("Console: " + message);
        }
    }

    static class FileLogger implements Logger {
        public void log(String message) {
            System.out.println("File: " + message);
        }
    }

    static class Application {
        private Logger logger;

        Application(Logger logger) {
            this.logger = logger;
        }

        void run() {
            logger.log("Application running");
        }
    }

    public static void main(String[] args) {
        Application app1 = new Application(new ConsoleLogger());
        app1.run();

        Application app2 = new Application(new FileLogger());
        app2.run();
    }
}


