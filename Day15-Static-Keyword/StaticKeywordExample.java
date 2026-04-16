/**
 * Day 15 - Static Keyword: Static Variables and Methods
 *
 * Concept:
 * Static variables and methods belong to the class, not individual objects.
 * They are shared by all instances of the class.
 *
 * This example demonstrates:
 * - Static variables (shared across objects)
 * - Static methods (called on class)
 * - Instance vs static differentiation
 * - When static is useful
 *
 * Real-life analogy:
 * Instance: Each person has own salary
 * Static: All employees follow company policy
 */
public class StaticKeywordExample {

    /**
     * Student class demonstrating static usage
     */
    static class Student {
        // Static variable: shared by all students
        static int totalStudents = 0;
        static String universityName = "MIT";

        // Instance variables: unique to each student
        String name;
        int age;
        double gpa;

        /**
         * Constructor
         */
        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
            totalStudents++;  // Increment shared variable
        }

        /**
         * Instance method: uses instance variables
         */
        void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
            System.out.println("University: " + universityName);  // Can access static
        }

        /**
         * Static method: cannot access instance variables
         */
        static void displayStatistics() {
            System.out.println("Total students: " + totalStudents);  // OK: static
            System.out.println("University: " + universityName);     // OK: static
            // System.out.println(name);  // ERROR: instance variable
        }

        /**
         * Static method: utility method
         */
        static double averageGPA(double gpa1, double gpa2) {
            return (gpa1 + gpa2) / 2;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("=== Static Keyword Example ===\n");

        System.out.println("--- Creating Students ---");
        Student s1 = new Student("John", 20, 3.8);
        Student s2 = new Student("Jane", 19, 3.9);
        Student s3 = new Student("Bob", 21, 3.7);

        System.out.println("\n--- Displaying Information ---");
        s1.displayInfo();
        System.out.println();
        s2.displayInfo();

        System.out.println("\n--- Static Variables (Shared) ---");
        System.out.println("s1.totalStudents: " + s1.totalStudents);
        System.out.println("s2.totalStudents: " + s2.totalStudents);
        System.out.println("s3.totalStudents: " + s3.totalStudents);
        System.out.println("All show same value (shared): " + Student.totalStudents);

        System.out.println("\n--- Calling Static Method ---");
        Student.displayStatistics();  // Called on class, not object

        System.out.println("\n--- Static Utility Method ---");
        double avgGPA = Student.averageGPA(3.8, 3.9);
        System.out.println("Average GPA: " + avgGPA);

        System.out.println("\n--- Key Insights ---");
        System.out.println("1. totalStudents is shared (all see same value)");
        System.out.println("2. Each student has own name, age, gpa");
        System.out.println("3. Static method called on class: Student.displayStatistics()");
        System.out.println("4. Can still call on object: s1.displayStatistics() (but not recommended)");
        System.out.println("5. Static methods useful for utilities (no object state needed)");

    }

}


