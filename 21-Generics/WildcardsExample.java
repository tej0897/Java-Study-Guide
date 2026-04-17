/**
 * Day 21 - Generics: Wildcards (PECS)
 *
 * <p>Demonstrates:
 * <ul>
 *   <li>{@code List<?>} (unknown type) is effectively read-only for adding</li>
 *   <li>{@code List<? extends Number>} is a producer (read numbers)</li>
 *   <li>{@code List<? super Integer>} is a consumer (add integers)</li>
 *   <li>PECS: Producer Extends, Consumer Super</li>
 * </ul>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsExample {

    static void printAnyList(List<?> list) {
        System.out.println("List<?> contents: " + list);
        Object first = list.isEmpty() ? null : list.get(0);
        System.out.println("First element as Object: " + first);

        // list.add(...) is not allowed because the compiler does not know the element type.
        // list.add("x"); // does not compile
    }

    static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        // numbers.add(1); // does not compile (can't safely add to ? extends)
        return sum;
    }

    static void addSomeIntegers(List<? super Integer> sink) {
        // We can add Integer values safely.
        sink.add(10);
        sink.add(20);
        sink.add(30);

        // Reading back only guarantees Object.
        Object first = sink.get(0);
        System.out.println("After adding integers, first element as Object: " + first);
    }

    public static void main(String[] args) {
        System.out.println("=== Wildcards (PECS) ===\n");

        List<String> names = Arrays.asList("Alice", "Bob");
        printAnyList(names);
        System.out.println();

        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5);

        System.out.println("Sum of ints: " + sumNumbers(ints));
        System.out.println("Sum of doubles: " + sumNumbers(doubles));
        System.out.println();

        List<Number> numberSink = new ArrayList<>();
        addSomeIntegers(numberSink);
        System.out.println("Number sink contents: " + numberSink);

        System.out.println("\nKey Points:");
        System.out.println("1. List<?>: unknown type (can read as Object)");
        System.out.println("2. ? extends T: producer (read T), cannot add safely");
        System.out.println("3. ? super T: consumer (add T), reads as Object");
        System.out.println("4. PECS: Producer Extends, Consumer Super");
    }
}

