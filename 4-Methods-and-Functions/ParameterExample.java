/**
 * Day 4 - Parameters and Arguments
 *
 * Concept:
 * Parameters are variables defined in method signature,
 * while arguments are actual values passed during method call.
 *
 * This example demonstrates:
 * - Passing parameters to methods
 * - Using arguments
 *
 * Real-life analogy:
 * Food order:
 * Method = kitchen
 * Parameters = order items
 * Arguments = actual order values
 */
public class ParameterExample {

    /**
     * Method that takes a name as parameter and prints greeting
     * @param name name of the person
     */
    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    /**
     * Method that calculates square of a number
     * @param number input number
     * @return square of the number
     */
    public static int square(int number) {
        return number * number;
    }

    /**
     * Main method demonstrating parameters and arguments
     */
    public static void main(String[] args) {

        // Passing argument "Tejas"
        greet("Tejas");

        int result = square(4);
        System.out.println("Square: " + result);
    }
}
