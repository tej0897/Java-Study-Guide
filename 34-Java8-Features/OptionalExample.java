/**
 * Day 34 - Java 8 Features: Optional
 */
import java.util.*;

public class OptionalExample {
    public static void main(String[] args) {
        System.out.println("=== Optional ===\n");

        Optional<String> name = Optional.of("John");
        System.out.println("Value: " + name.get());
        System.out.println("Is present: " + name.isPresent());

        Optional<String> empty = Optional.empty();
        System.out.println("Empty present: " + empty.isPresent());
        System.out.println("Or else: " + empty.orElse("Default"));

        // With lambda
        name.ifPresent(n -> System.out.println("Name found: " + n));
    }
}


