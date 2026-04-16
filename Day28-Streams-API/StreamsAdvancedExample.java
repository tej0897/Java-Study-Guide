/**
 * Day 28 - Streams API: Advanced Operations
 */
import java.util.*;
import java.util.stream.*;

public class StreamsAdvancedExample {
    public static void main(String[] args) {
        System.out.println("=== Advanced Stream Operations ===\n");

        List<String> words = Arrays.asList("Java", "Python", "JavaScript", "C++", "Go");

        System.out.println("--- Sorted ---");
        words.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n--- Sorted by Length ---");
        words.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        System.out.println("\n--- Count ---");
        long count = words.stream()
                .filter(w -> w.length() > 4)
                .count();
        System.out.println("Words with length > 4: " + count);

        System.out.println("\n--- Convert to Map ---");
        Map<String, Integer> wordLengths = words.stream()
                .collect(Collectors.toMap(w -> w, String::length));
        wordLengths.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}


