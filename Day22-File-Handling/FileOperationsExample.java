/**
 * Day 22 - File Handling: File Operations
 */
import java.io.*;

public class FileOperationsExample {

    public static void main(String[] args) {
        System.out.println("=== File Operations ===\n");

        demonstrateFileOperations();
    }

    static void demonstrateFileOperations() {
        String fileName = "test.txt";

        // Create and write
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Sample content");
            System.out.println("✓ File created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        // Check file properties
        File file = new File(fileName);
        System.out.println("✓ File exists: " + file.exists());
        System.out.println("✓ Is file: " + file.isFile());
        System.out.println("✓ File size: " + file.length() + " bytes");
        System.out.println("✓ Absolute path: " + file.getAbsolutePath());

        // Delete
        if (file.delete()) {
            System.out.println("✓ File deleted");
        }
    }
}


