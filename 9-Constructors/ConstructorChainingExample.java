/**
 * Day 9 - Constructors: Constructor Chaining
 *
 * Concept:
 * Constructor chaining is when one constructor calls another constructor
 * in the same class using the 'this' keyword.
 * This reduces code duplication and centralizes initialization logic.
 *
 * This example demonstrates:
 * - One constructor calling another
 * - Using 'this()' keyword for chaining
 * - Order of constructor execution
 * - Common initialization in single constructor
 *
 * Real-life analogy:
 * Like passing a baton in a relay race:
 * Constructor1 → passes to Constructor2 → passes to Constructor3
 * Each pass adds more processing
 */
public class ConstructorChainingExample {

    /**
     * Book class with constructor chaining
     */
    static class Book {
        String title;
        String author;
        int pages;
        double price;

        // Constructor 1: No parameters - chains to Constructor 2
        Book() {
            this("Untitled", "Unknown");
            System.out.println("Constructor 1: No parameters called");
        }

        // Constructor 2: Title and Author - chains to Constructor 3
        Book(String title, String author) {
            this(title, author, 0);
            System.out.println("Constructor 2: Title and Author called");
        }

        // Constructor 3: Title, Author, Pages - chains to Constructor 4
        Book(String title, String author, int pages) {
            this(title, author, pages, 0.0);
            System.out.println("Constructor 3: Title, Author, Pages called");
        }

        // Constructor 4: All parameters - Main constructor with actual initialization
        Book(String title, String author, int pages, double price) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.price = price;
            System.out.println("Constructor 4: All parameters called (Main initialization)");
        }

        void display() {
            System.out.println("Book: " + title + " by " + author + ", Pages: " + pages + ", Price: $" + price);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Constructor Chaining Example ---\n");

        // Using Constructor 1
        System.out.println("Creating Book with Constructor 1 (no parameters):");
        Book book1 = new Book();
        System.out.println("Execution order: 4 → 3 → 2 → 1 (bottom-up)\n");
        book1.display();

        System.out.println("\n--- Creating Book with Constructor 2 (title and author) ---");
        Book book2 = new Book("Java Programming", "John Doe");
        System.out.println("Execution order: 4 → 3 → 2\n");
        book2.display();

        System.out.println("\n--- Creating Book with Constructor 3 (title, author, pages) ---");
        Book book3 = new Book("Java Programming", "John Doe", 500);
        System.out.println("Execution order: 4 → 3\n");
        book3.display();

        System.out.println("\n--- Creating Book with Constructor 4 (all parameters) ---");
        Book book4 = new Book("Java Programming", "John Doe", 500, 29.99);
        System.out.println("Execution order: 4 only\n");
        book4.display();

        System.out.println("\n--- Key Insight ---");
        System.out.println("All initialization logic is in Constructor 4 (DRY principle)");
        System.out.println("Other constructors provide default values and chain to Constructor 4");

    }

}


