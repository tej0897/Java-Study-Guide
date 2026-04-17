/**
 * Day 27 - Lambda Expressions
 */
import java.util.*;

public class LambdaExample {

    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println("=== Lambda Expressions ===\n");

        // Lambda expressions
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("Add: " + add.calculate(10, 5));
        System.out.println("Subtract: " + subtract.calculate(10, 5));
        System.out.println("Multiply: " + multiply.calculate(10, 5));

        System.out.println("\n--- With Collections ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println(n));

        System.out.println("\n--- Filtering ---");
        numbers.stream()
                .filter(n -> n > 2)
                .forEach(n -> System.out.println(n));
    }
}


