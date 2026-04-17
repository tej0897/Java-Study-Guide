/**
 * Day 34 - Java 8 Features: Built-in Functional Interfaces
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        System.out.println("=== Functional Interfaces (java.util.function) ===\n");

        Predicate<String> nonBlank = s -> s != null && !s.trim().isEmpty();
        System.out.println("nonBlank('  '): " + nonBlank.test("  "));
        System.out.println("nonBlank('Java'): " + nonBlank.test("Java"));

        Function<Integer, String> label = n -> "Number=" + n;
        System.out.println(label.apply(42));

        Supplier<Double> random01 = Math::random;
        System.out.println("Random: " + random01.get());

        Consumer<String> printer = System.out::println;
        printer.accept("Printed using Consumer");

        System.out.println("\nKey Points:");
        System.out.println("1. Predicate<T>: returns boolean");
        System.out.println("2. Function<T,R>: transforms input to output");
        System.out.println("3. Supplier<T>: supplies a value");
        System.out.println("4. Consumer<T>: consumes a value (side effects)");
    }
}

