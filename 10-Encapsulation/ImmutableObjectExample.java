/**
 * Day 10 - Encapsulation: Immutable Objects
 *
 * Concept:
 * Immutable objects are objects whose state cannot be changed after creation.
 * Once created, their properties cannot be modified.
 * Properties are marked as 'final' and there are no setters.
 *
 * This example demonstrates:
 * - Creating immutable objects with final properties
 * - No setters (only getters)
 * - Benefits of immutability
 * - Thread safety of immutable objects
 *
 * Real-life analogy:
 * Like a photograph: Once taken, the photo cannot be changed.
 * You can view it (getter) but not modify it (no setter).
 */
public class ImmutableObjectExample {

    /**
     * Immutable Point class
     * Once created, coordinates cannot be changed
     */
    static class ImmutablePoint {
        // final: Value set once, cannot be modified
        private final int x;
        private final int y;

        /**
         * Constructor - only way to set values
         */
        ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Getter for x (read-only)
         */
        int getX() {
            return x;
        }

        /**
         * Getter for y (read-only)
         */
        int getY() {
            return y;
        }

        /**
         * NO SETTERS! State cannot be changed
         */

        void display() {
            System.out.println("Point(" + x + ", " + y + ")");
        }

        /**
         * Create new point instead of modifying
         */
        ImmutablePoint move(int dx, int dy) {
            return new ImmutablePoint(x + dx, y + dy);
        }

        @Override
        public String toString() {
            return "ImmutablePoint(" + x + ", " + y + ")";
        }
    }

    /**
     * Immutable Student class
     */
    static class ImmutableStudent {
        private final String name;
        private final int age;
        private final double gpa;

        /**
         * Constructor
         */
        ImmutableStudent(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        /**
         * Getters only
         */
        String getName() { return name; }
        int getAge() { return age; }
        double getGPA() { return gpa; }

        /**
         * NO SETTERS!
         */

        /**
         * To change state, create new object
         */
        ImmutableStudent withName(String newName) {
            return new ImmutableStudent(newName, age, gpa);
        }

        ImmutableStudent withAge(int newAge) {
            return new ImmutableStudent(name, newAge, gpa);
        }

        ImmutableStudent withGPA(double newGPA) {
            return new ImmutableStudent(name, age, newGPA);
        }

        @Override
        public String toString() {
            return name + " (Age: " + age + ", GPA: " + gpa + ")";
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Creating Immutable Point ---\n");

        // Creating immutable point
        ImmutablePoint p1 = new ImmutablePoint(5, 10);
        System.out.println("Original point: ");
        p1.display();

        System.out.println("\n--- Attempting to modify (will fail in compiler) ---");
        // p1.x = 20;  // COMPILE ERROR! final field cannot be modified
        // p1.setX(20);  // ERROR! No setter exists

        System.out.println("Cannot modify p1 directly!");

        System.out.println("\n--- Creating new point instead ---");
        ImmutablePoint p2 = p1.move(3, 4);
        System.out.println("Original point (unchanged): ");
        p1.display();
        System.out.println("New point (after move): ");
        p2.display();

        System.out.println("\n--- Immutable Student Example ---\n");

        ImmutableStudent s1 = new ImmutableStudent("Tejas", 20, 3.8);
        System.out.println("Original student: " + s1);

        // Create new student with different name
        ImmutableStudent s2 = s1.withName("Raj");
        System.out.println("Original (unchanged): " + s1);
        System.out.println("New student: " + s2);

        System.out.println("\n--- Benefits of Immutability ---");
        System.out.println("1. Thread-safe: No synchronization needed");
        System.out.println("2. Predictable: State never changes unexpectedly");
        System.out.println("3. Safe map keys: Can use as HashMap keys");
        System.out.println("4. Cached safely: Can be cached without issues");

        System.out.println("\n--- Immutability Pattern ---");
        System.out.println("Instead of: student.setName('New')");
        System.out.println("Use: student = student.withName('New')");

    }

}


