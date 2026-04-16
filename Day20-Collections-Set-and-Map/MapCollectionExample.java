/**
 * Day 20 - Collections: Map
 */
import java.util.*;

public class MapCollectionExample {

    public static void main(String[] args) {
        System.out.println("=== Map Collections ===\n");

        System.out.println("--- HashMap ---");
        demonstrateHashMap();

        System.out.println("\n--- TreeMap (Sorted) ---");
        demonstrateTreeMap();
    }

    static void demonstrateHashMap() {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("John", 25);
        ages.put("Jane", 23);
        ages.put("Bob", 28);

        System.out.println("Map: " + ages);
        System.out.println("John's age: " + ages.get("John"));
        System.out.println("Keys: " + ages.keySet());
        System.out.println("Values: " + ages.values());

        ages.remove("Jane");
        System.out.println("After removal: " + ages);
    }

    static void demonstrateTreeMap() {
        Map<String, String> capitals = new TreeMap<>();

        capitals.put("USA", "Washington");
        capitals.put("India", "NewDelhi");
        capitals.put("Japan", "Tokyo");

        System.out.println("TreeMap (sorted by key):");
        for (String country : capitals.keySet()) {
            System.out.println("  " + country + " -> " + capitals.get(country));
        }
    }
}



