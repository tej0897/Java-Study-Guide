/**
 * Day 27 - Lambda Expressions with Functional Interfaces
 */
import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        System.out.println("=== Functional Interfaces ===\n");

        // Predicate: test condition
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("Is 5 positive: " + isPositive.test(5));

        // Function: transform
        Function<Integer, String> toString = n -> "Number: " + n;
        System.out.println(toString.apply(42));

        // Consumer: perform action
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello from lambda");

        // Supplier: provide value
        Supplier<Integer> random = () -> (int) (Math.random() * 100);
        System.out.println("Random: " + random.get());
    }
}


