/**
 * Day 21 - Generics: Generic Methods
 */
import java.util.*;

public class GenericMethodsExample {

    static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    static <T extends Comparable<T>> T findMax(List<T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("=== Generic Methods ===\n");

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World"};

        System.out.println("Int Array:");
        printArray(intArray);

        System.out.println("\nString Array:");
        printArray(strArray);

        System.out.println("\n--- Find Max ---");
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15);
        System.out.println("Max: " + findMax(numbers));
    }
}


