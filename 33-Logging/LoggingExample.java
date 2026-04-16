/**
 * Day 33 - Logging: Java Util Logging
 */
import java.util.logging.*;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        System.out.println("=== Java Logging ===\n");

        logger.info("Application started");
        logger.warning("This is a warning");
        logger.severe("This is an error");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Exception occurred", e);
        }
    }
}


