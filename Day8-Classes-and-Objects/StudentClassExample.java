/**
 * Day 8 - Classes and Objects: Student Class
 *
 * Concept:
 * This example demonstrates class structure with properties, constructor, and methods.
 * Shows how to design a real-world class with proper encapsulation.
 *
 * This example demonstrates:
 * - Class definition with properties
 * - Constructor for initialization
 * - Methods for behavior
 * - Getters and setters
 * - Object interaction
 *
 * Real-life analogy:
 * Class = Student blueprint
 * Object = Actual student (John, Priya, etc.)
 */
public class StudentClassExample {

    /**
     * Student class with complete structure
     */
    static class Student {

        // Properties (State)
        private String name;
        private int age;
        private String email;
        private double gpa;

        /**
         * Constructor - initializes Student object
         */
        Student(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.gpa = 0.0;  // Initially no GPA
        }

        /**
         * Getter for name
         */
        String getName() {
            return name;
        }

        /**
         * Getter for age
         */
        int getAge() {
            return age;
        }

        /**
         * Setter for age with validation
         */
        void setAge(int newAge) {
            if (newAge > 0 && newAge < 150) {
                age = newAge;
            } else {
                System.out.println("Invalid age");
            }
        }

        /**
         * Setter for email
         */
        void setEmail(String email) {
            if (email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("Invalid email");
            }
        }

        /**
         * Method to set GPA with validation
         */
        void setGPA(double gpa) {
            if (gpa >= 0 && gpa <= 4.0) {
                this.gpa = gpa;
            } else {
                System.out.println("GPA must be between 0 and 4.0");
            }
        }

        /**
         * Method to study
         */
        void study(int hours) {
            System.out.println(name + " studies for " + hours + " hours");
        }

        /**
         * Method to submit assignment
         */
        void submitAssignment(String assignment) {
            System.out.println(name + " submitted " + assignment);
        }

        /**
         * Method to display student info
         */
        void displayInfo() {
            System.out.println("--- Student Info ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("GPA: " + gpa);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Creating Student Objects ---");

        // Creating student objects
        Student student1 = new Student("Tejas", 20, "tejas@example.com");
        Student student2 = new Student("Priya", 19, "priya@example.com");

        System.out.println("\n--- Using Student Methods ---");

        // Using methods
        student1.study(5);
        student1.submitAssignment("Math Project");

        System.out.println("\n--- Setting GPA ---");

        // Setting GPA
        student1.setGPA(3.8);
        student2.setGPA(3.9);

        System.out.println("\n--- Displaying Info ---");

        // Displaying info
        student1.displayInfo();
        System.out.println();
        student2.displayInfo();

        System.out.println("\n--- Demonstrating Validation ---");

        // Invalid age (will be rejected)
        student1.setAge(-5);

        // Valid age (will be accepted)
        student1.setAge(21);

        // Invalid email (will be rejected)
        student1.setEmail("invalid-email");

        // Valid email (will be accepted)
        student1.setEmail("newemail@example.com");

        System.out.println("\n--- Final Info ---");
        student1.displayInfo();

    }

}


