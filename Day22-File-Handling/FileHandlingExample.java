/**
 * Day 22 - File Handling: Reading and Writing Files
 */
import java.io.*;
import java.util.*;

public class FileHandlingExample {

    public static void main(String[] args) {
        System.out.println("=== File Handling ===\n");

        writeToFile();
        readFromFile();
    }

    static void writeToFile() {
        System.out.println("--- Writing to File ---");
        try (FileWriter writer = new FileWriter("sample.txt")) {
            writer.write("Hello, World!\n");
            writer.write("This is a test file.\n");
            writer.write("File I/O in Java\n");
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void readFromFile() {
        System.out.println("\n--- Reading from File ---");
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


