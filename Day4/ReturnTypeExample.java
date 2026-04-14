/**
 * Day 4 - Methods with Return Type
 *
 * Concept:
 * A method can process input and return a value.
 *
 * This example demonstrates:
 * - Method returning a value
 * - Using return keyword
 *
 * Real-life analogy:
 * Calculator → Input numbers → Output result
 */
public class ReturnTypeExample {

    /**
     * Method to calculate sum of two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Main method demonstrating return type usage
     */
    public static void main(String[] args) {

        int result = add(5, 10);

        System.out.println("Sum: " + result);
    }
}
