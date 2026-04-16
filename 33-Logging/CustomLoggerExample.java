/**
 * Day 33 - Logging: Custom Logger
 */
import java.util.logging.*;
import java.io.IOException;

public class CustomLoggerExample {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("CustomLogger");

        // File handler
        FileHandler fh = new FileHandler("app.log");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        logger.info("Logging to file");
        logger.warning("Warning message");

        System.out.println("Logs written to app.log");
    }
}


