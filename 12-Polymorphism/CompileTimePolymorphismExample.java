/**
 * Day 12 - Polymorphism: Compile-Time Polymorphism (Overloading)
 *
 * Concept:
 * Compile-time polymorphism occurs through method overloading.
 * Multiple methods with same name but different parameters.
 * Method selected at COMPILE time based on arguments.
 *
 * This example demonstrates:
 * - Method overloading with different parameters
 * - Method selection based on parameter types
 * - Different return types (optional)
 * - Practical overloading usage
 *
 * Real-life analogy:
 * Printer can print different types: images, documents, PDFs
 * Same action (print) with different inputs
 */
public class CompileTimePolymorphismExample {

    /**
     * Calculator class demonstrating method overloading
     */
    static class Calculator {

        /**
         * add(int, int)
         */
        int add(int a, int b) {
            System.out.println("Adding two integers");
            return a + b;
        }

        /**
         * add(double, double)
         */
        double add(double a, double b) {
            System.out.println("Adding two doubles");
            return a + b;
        }

        /**
         * add(int, int, int)
         */
        int add(int a, int b, int c) {
            System.out.println("Adding three integers");
            return a + b + c;
        }

        /**
         * add(String, String)
         */
        String add(String a, String b) {
            System.out.println("Concatenating two strings");
            return a + b;
        }

        /**
         * multiply(int, int)
         */
        int multiply(int a, int b) {
            System.out.println("Multiplying two integers");
            return a * b;
        }

        /**
         * multiply(double, double)
         */
        double multiply(double a, double b) {
            System.out.println("Multiplying two doubles");
            return a * b;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Compile-Time Polymorphism (Method Overloading) ---\n");

        Calculator calc = new Calculator();

        System.out.println("--- add() Method Overloading ---");

        // add(int, int)
        System.out.println("Result: " + calc.add(5, 10));

        // add(double, double)
        System.out.println("Result: " + calc.add(5.5, 10.5));

        // add(int, int, int)
        System.out.println("Result: " + calc.add(5, 10, 15));

        // add(String, String)
        System.out.println("Result: " + calc.add("Hello", " World"));

        System.out.println("\n--- multiply() Method Overloading ---");

        // multiply(int, int)
        System.out.println("Result: " + calc.multiply(5, 10));

        // multiply(double, double)
        System.out.println("Result: " + calc.multiply(5.5, 10.5));

        System.out.println("\n--- How Compiler Decides ---");
        System.out.println("calc.add(5, 10) → add(int, int) - parameter types match");
        System.out.println("calc.add(5.5, 10.5) → add(double, double) - parameter types match");
        System.out.println("calc.add('Hello', 'World') → add(String, String) - parameter types match");

        System.out.println("\n--- Compilation vs Runtime ---");
        System.out.println("Overloading resolved at COMPILE TIME");
        System.out.println("Not a runtime decision like overriding");

    }

}


