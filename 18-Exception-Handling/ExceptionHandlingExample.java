/**
 * Day 18 - Exception Handling: Try-Catch
 */
public class ExceptionHandlingExample {

    static void demonstrateTryCatch() {
        System.out.println("--- Try-Catch Examples ---");

        // Example 1: Arithmetic Exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught: Cannot divide by zero");
        }

        // Example 2: Array Index Out of Bounds
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: Invalid array index");
        }

        // Example 3: Null Pointer
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught: Null reference");
        }
    }

    static void demonstrateFinally() {
        System.out.println("\n--- Finally Block ---");

        try {
            System.out.println("In try block");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("In finally block (always executes)");
        }
    }

    static void demonstrateThrow() {
        System.out.println("\n--- Throw Keyword ---");

        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        System.out.println("Age is valid");
    }

    public static void main(String[] args) {
        System.out.println("=== Exception Handling ===\n");

        demonstrateTryCatch();
        demonstrateFinally();
        demonstrateThrow();
    }
}


