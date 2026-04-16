/**
 * Day 28 - Streams API
 */
import java.util.*;
import java.util.stream.*;

public class StreamsAPIExample {
    public static void main(String[] args) {
        System.out.println("=== Streams API ===\n");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("--- Filter ---");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\n--- Map ---");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        System.out.println("\n--- Reduce ---");
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        System.out.println("\n--- Collect ---");
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled);
    }
}


