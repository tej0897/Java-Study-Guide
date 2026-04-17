/**
 * Day 34 - Java 8 Features: Method References
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExample {
    public static void main(String[] args) {
        System.out.println("=== Method References ===\n");

        List<String> names = Arrays.asList("alice", "Bob", "charlie");

        System.out.println("--- forEach(System.out::println) ---");
        names.forEach(System.out::println);

        System.out.println("\n--- map(String::toUpperCase) ---");
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper);

        System.out.println("\n--- sorted(String::compareToIgnoreCase) ---");
        List<String> sorted = names.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(sorted);

        System.out.println("\nKey Points:");
        System.out.println("1. Method refs are shorthand for lambdas that call an existing method");
        System.out.println("2. Common forms: Class::staticMethod, obj::instanceMethod, Class::instanceMethod");
    }
}

