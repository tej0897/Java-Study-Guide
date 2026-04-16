/**
 * Day 1 - Polymorphism
 *
 * Concept:
 * Polymorphism means "many forms".
 * A single method can behave differently based on input parameters.
 *
 * This example demonstrates:
 * - Method overloading (compile-time polymorphism)
 *
 * Real-life analogy:
 * Same action "add" can work for 2 numbers or 3 numbers
 */
class Calculator {

    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of two numbers
     */
    int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds three numbers
     * @param a first number
     * @param b second number
     * @param c third number
     * @return sum of three numbers
     */
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class PolymorphismExample {

    /**
     * Main method demonstrating polymorphism
     */
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Sum (2 values): " + calc.add(2, 3));
        System.out.println("Sum (3 values): " + calc.add(2, 3, 4));
    }
}
