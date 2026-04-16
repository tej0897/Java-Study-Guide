/**
 * Day 6 - Strings in Java: Common String Methods
 *
 * Concept:
 * Java provides many built-in methods to manipulate and analyze strings.
 * Common methods include: length, charAt, substring, indexOf, replace, split, etc.
 *
 * This example demonstrates:
 * - String inspection methods (length, isEmpty, contains)
 * - String extraction methods (charAt, substring, indexOf)
 * - String transformation methods (toUpperCase, toLowerCase, trim)
 * - String utility methods (split, replace)
 *
 * Real-life analogy:
 * String methods are like tools in a toolbox:
 * - length() = ruler (measures)
 * - substring() = scissors (cuts)
 * - replace() = correction fluid (replaces)
 */
public class StringMethodsExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        String text = "Java Programming is Awesome";

        System.out.println("--- String Inspection Methods ---");

        // length() - returns length of string
        System.out.println("Length: " + text.length());

        // isEmpty() - checks if string is empty
        System.out.println("Is empty: " + text.isEmpty());

        // contains() - checks if contains substring
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Contains 'Python': " + text.contains("Python"));

        System.out.println("\n--- String Extraction Methods ---");

        // charAt() - returns character at index
        System.out.println("Character at index 0: " + text.charAt(0));
        System.out.println("Character at index 5: " + text.charAt(5));

        // substring() - extracts substring from index
        System.out.println("Substring from index 0: " + text.substring(0));
        System.out.println("Substring from 0 to 4: " + text.substring(0, 4));

        // indexOf() - finds first occurrence
        System.out.println("Index of 'Java': " + text.indexOf("Java"));
        System.out.println("Index of 'is': " + text.indexOf("is"));

        // lastIndexOf() - finds last occurrence
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));

        System.out.println("\n--- String Transformation Methods ---");

        // toUpperCase() - converts to uppercase
        System.out.println("Uppercase: " + text.toUpperCase());

        // toLowerCase() - converts to lowercase
        System.out.println("Lowercase: " + text.toLowerCase());

        // trim() - removes leading and trailing spaces
        String spacedText = "  Hello World  ";
        System.out.println("Original with spaces: '" + spacedText + "'");
        System.out.println("After trim: '" + spacedText.trim() + "'");

        System.out.println("\n--- String Utility Methods ---");

        // split() - splits string by delimiter
        String languages = "Java,Python,C++,JavaScript";
        String[] langs = languages.split(",");
        System.out.println("Languages:");
        for (String lang : langs) {
            System.out.println("  - " + lang);
        }

        // replace() - replaces all occurrences
        String replaced = text.replace("Java", "Python");
        System.out.println("Replace 'Java' with 'Python': " + replaced);

        // concat() - concatenates strings
        String combined = "Hello".concat(" ").concat("World");
        System.out.println("Concatenated: " + combined);

        // startsWith() and endsWith()
        System.out.println("Starts with 'Java': " + text.startsWith("Java"));
        System.out.println("Ends with 'Awesome': " + text.endsWith("Awesome"));

        System.out.println("\n--- Comparison Methods ---");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "hello";

        // equals() - exact comparison
        System.out.println("'Hello'.equals('Hello'): " + s1.equals(s2));

        // equalsIgnoreCase() - case-insensitive comparison
        System.out.println("'Hello'.equalsIgnoreCase('hello'): " + s1.equalsIgnoreCase(s3));

        System.out.println("\n--- Practical Example: Email Validation ---");

        String email = "user@example.com";

        // Check if valid email
        if (email.contains("@") && email.contains(".")) {
            System.out.println("Email format looks valid");

            // Extract username
            String username = email.substring(0, email.indexOf("@"));
            System.out.println("Username: " + username);

            // Extract domain
            String domain = email.substring(email.indexOf("@") + 1);
            System.out.println("Domain: " + domain);
        }

    }
}


