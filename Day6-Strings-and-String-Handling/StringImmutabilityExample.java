/**
 * Day 6 - Strings in Java: Immutability
 *
 * Concept:
 * Strings in Java are immutable, meaning once created, they cannot be changed.
 * Any operation on a string creates a new string object.
 *
 * This example demonstrates:
 * - Creating strings
 * - String immutability
 * - How string modification actually works
 *
 * Real-life analogy:
 * String is like a book written in stone.
 * You cannot change the book itself.
 * You can only create a new book.
 */
public class StringImmutabilityExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        // Creating string
        String str = "Hello";
        System.out.println("Original string: " + str);

        // Attempting to modify (actually creates new string)
        str = str + " World";
        System.out.println("After concatenation: " + str);

        // Key point: Original "Hello" still exists in memory
        // str now points to new string "Hello World"

        System.out.println("\n--- Understanding Immutability ---");

        String original = "Java";
        String modified = original.concat(" Programming");

        System.out.println("Original: " + original);  // "Java" (unchanged)
        System.out.println("Modified: " + modified);  // "Java Programming"

        System.out.println("\n--- String Comparison ---");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println("s1 == s2: " + (s1 == s2));      // true (same pool)
        System.out.println("s1 == s3: " + (s1 == s3));      // false (different objects)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (same content)

    }
}


