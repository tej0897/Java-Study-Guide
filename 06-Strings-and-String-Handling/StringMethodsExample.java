/**
 * Day 6 - Strings: Common String Methods
 *
 * <p><b>Concept</b>
 * {@link String} is immutable and offers many methods to inspect, search, slice,
 * compare and transform textual data.
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>Inspection: {@code length()}, {@code isEmpty()}, {@code isBlank()}</li>
 *   <li>Searching: {@code contains()}, {@code indexOf()}, {@code lastIndexOf()}</li>
 *   <li>Slicing: {@code charAt()}, {@code substring()}</li>
 *   <li>Transformations: {@code toUpperCase()}, {@code trim()}, {@code replace()}</li>
 *   <li>Splitting: {@code split()}</li>
 *   <li>Comparison: {@code equals()}, {@code equalsIgnoreCase()}</li>
 * </ul>
 *
 * <p><b>Real-life analogy</b>
 * String methods are like tools:
 * <pre>
 * length()    -> measuring tape
 * substring() -> scissors
 * replace()   -> correction tape
 * split()     -> cutting a sentence into words
 * </pre>
 *
 * <p><b>Beginner note</b>
 * Many String methods throw exceptions for invalid indexes.
 * Be careful with {@code charAt(i)} and {@code substring(begin, end)}.
 */
public class StringMethodsExample {

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        String text = "Java Programming is Awesome";

        printInspection(text);
        printExtraction(text);
        printTransformations(text);
        printUtilities(text);
        printComparisons();
        printPracticalEmailParsing("user@example.com");
        printPracticalEmailParsing("invalid-email");
    }

    private static void printInspection(String text) {
        System.out.println("--- String Inspection Methods ---");
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Length: " + text.length());
        System.out.println("Is empty: " + text.isEmpty());
        System.out.println("Is blank (Java 11+): " + text.isBlank());
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Contains 'Python': " + text.contains("Python"));
        System.out.println();
    }

    private static void printExtraction(String text) {
        System.out.println("--- String Extraction Methods ---");
        System.out.println("Character at index 0: " + text.charAt(0));
        System.out.println("Character at index 5: " + text.charAt(5));

        System.out.println("Substring from index 0: " + text.substring(0));
        System.out.println("Substring from 0 to 4 (end exclusive): " + text.substring(0, 4));

        System.out.println("Index of 'Java': " + text.indexOf("Java"));
        System.out.println("Index of 'is': " + text.indexOf("is"));
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));
        System.out.println();
    }

    private static void printTransformations(String text) {
        System.out.println("--- String Transformation Methods ---");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());

        String spacedText = "  Hello World  ";
        System.out.println("Original with spaces: '" + spacedText + "'");
        System.out.println("After trim:          '" + spacedText.trim() + "'");
        System.out.println();
    }

    private static void printUtilities(String text) {
        System.out.println("--- String Utility Methods ---");

        String languages = "Java,Python,C++,JavaScript";
        String[] langs = languages.split(",");
        System.out.println("Split CSV: " + languages);
        for (String lang : langs) {
            System.out.println("  - " + lang);
        }

        String replaced = text.replace("Java", "Python");
        System.out.println("Replace 'Java' -> 'Python': " + replaced);

        String combined = "Hello".concat(" ").concat("World");
        System.out.println("Concatenated: " + combined);

        System.out.println("Starts with 'Java': " + text.startsWith("Java"));
        System.out.println("Ends with 'Awesome': " + text.endsWith("Awesome"));
        System.out.println();
    }

    private static void printComparisons() {
        System.out.println("--- Comparison Methods ---");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "hello";

        System.out.println("'Hello'.equals('Hello'): " + s1.equals(s2));
        System.out.println("'Hello'.equalsIgnoreCase('hello'): " + s1.equalsIgnoreCase(s3));

        // == compares references, not content
        String heapString = new String("Hello");
        System.out.println("s1 == heapString: " + (s1 == heapString));
        System.out.println("s1.equals(heapString): " + s1.equals(heapString));
        System.out.println();
    }

    /**
     * Demonstrates basic parsing with minimal validation.
     * In production, prefer a proper email validation library/pattern.
     */
    private static void printPracticalEmailParsing(String email) {
        System.out.println("--- Practical Example: Email Parsing ---");
        System.out.println("email = " + email);

        if (email == null || email.isBlank()) {
            System.out.println("Email is empty/blank");
            System.out.println();
            return;
        }

        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');

        // Very basic checks: exactly one '@', and '.' after '@'
        if (at <= 0 || dot <= at + 1 || dot == email.length() - 1) {
            System.out.println("Email format looks invalid");
            System.out.println();
            return;
        }

        String username = email.substring(0, at);
        String domain = email.substring(at + 1);

        System.out.println("Email format looks valid");
        System.out.println("Username: " + username);
        System.out.println("Domain:   " + domain);
        System.out.println();
    }
}
