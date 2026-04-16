/**
 * Day 20 - Collections: Set
 */
import java.util.*;

public class SetCollectionExample {

    public static void main(String[] args) {
        System.out.println("=== Set Collections ===\n");

        System.out.println("--- HashSet ---");
        demonstrateHashSet();

        System.out.println("\n--- TreeSet (Sorted) ---");
        demonstrateTreeSet();
    }

    static void demonstrateHashSet() {
        Set<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");  // Duplicate - ignored

        System.out.println("Set: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Banana: " + fruits.contains("Banana"));

        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
    }

    static void demonstrateTreeSet() {
        Set<Integer> numbers = new TreeSet<>();

        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        numbers.add(15);

        System.out.println("TreeSet (sorted): " + numbers);

        for (Integer num : numbers) {
            System.out.println("  " + num);
        }
    }
}



