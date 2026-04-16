/**
 * Day 23 - Serialization: Collections Serialization
 */
import java.io.*;
import java.util.*;

public class CollectionSerializationExample {
    public static void main(String[] args) {
        System.out.println("=== Collection Serialization ===\n");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.dat"))) {
            out.writeObject(list);
            System.out.println("✓ List serialized");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("list.dat"))) {
            @SuppressWarnings("unchecked")
            List<String> loadedList = (List<String>) in.readObject();
            System.out.println("✓ List deserialized: " + loadedList);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


