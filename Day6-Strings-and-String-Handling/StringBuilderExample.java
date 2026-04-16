/**
 * Day 6 - Strings in Java: StringBuilder vs StringBuffer
 *
 * Concept:
 * StringBuilder and StringBuffer are mutable alternatives to String.
 * They allow modification without creating new objects.
 * StringBuffer is thread-safe, StringBuilder is not.
 *
 * This example demonstrates:
 * - Using StringBuilder for efficient string building
 * - Comparing performance of String concatenation vs StringBuilder
 * - When to use StringBuilder
 *
 * Real-life analogy:
 * String = Write-once document
 * StringBuilder = Editable document (can modify)
 */
public class StringBuilderExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        System.out.println("--- Using String Concatenation (INEFFICIENT) ---");

        // Inefficient: Creates multiple String objects
        long startTime = System.nanoTime();

        String result = "";
        for (int i = 0; i < 10000; i++) {
            result = result + i;  // Creates new String each time
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken (String concatenation): " + (endTime - startTime) + " ns");

        System.out.println("\n--- Using StringBuilder (EFFICIENT) ---");

        // Efficient: Modifies single buffer
        startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);  // Modifies buffer
        }
        String resultSB = sb.toString();

        endTime = System.nanoTime();
        System.out.println("Time taken (StringBuilder): " + (endTime - startTime) + " ns");

        System.out.println("\n--- StringBuilder Methods ---");

        // Creating StringBuilder
        StringBuilder builder = new StringBuilder("Hello");
        System.out.println("Original: " + builder);

        // Append
        builder.append(" World");
        System.out.println("After append: " + builder);

        // Insert
        builder.insert(5, "Beautiful ");
        System.out.println("After insert: " + builder);

        // Replace
        builder.replace(0, 5, "Hi");
        System.out.println("After replace: " + builder);

        // Delete
        builder.delete(2, 4);
        System.out.println("After delete: " + builder);

        // Reverse
        StringBuilder reverseBuilder = new StringBuilder("Java");
        reverseBuilder.reverse();
        System.out.println("Reversed 'Java': " + reverseBuilder);

        System.out.println("\n--- Building Complex String ---");

        StringBuilder csv = new StringBuilder();
        csv.append("Name").append(",");
        csv.append("Age").append(",");
        csv.append("Email");
        System.out.println("CSV Header: " + csv);

    }
}


