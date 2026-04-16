/**
 * Day 19 - Collections: ArrayList and LinkedList
 */
import java.util.*;

public class ListCollectionExample {

    public static void main(String[] args) {
        System.out.println("=== List Collections ===\n");

        System.out.println("--- ArrayList ---");
        demonstrateArrayList();

        System.out.println("\n--- LinkedList ---");
        demonstrateLinkedList();

        System.out.println("\n--- Iteration Methods ---");
        demonstrateIteration();
    }

    static void demonstrateArrayList() {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("List: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("First: " + fruits.get(0));

        fruits.remove(1);
        System.out.println("After removal: " + fruits);
    }

    static void demonstrateLinkedList() {
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("LinkedList: " + numbers);
        System.out.println("Contains 20: " + numbers.contains(20));

        numbers.addFirst(5);
        System.out.println("After addFirst(5): " + numbers);
    }

    static void demonstrateIteration() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("For loop:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println("  " + colors.get(i));
        }

        System.out.println("Enhanced for:");
        for (String color : colors) {
            System.out.println("  " + color);
        }
    }
}



