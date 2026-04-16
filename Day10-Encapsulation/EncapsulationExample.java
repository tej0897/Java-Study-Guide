/**
 * Day 10 - Encapsulation: Access Modifiers
 *
 * Concept:
 * Access modifiers (private, public, protected) control visibility
 * of properties and methods. They enable encapsulation by hiding
 * internal details and exposing only necessary interface.
 *
 * This example demonstrates:
 * - Private properties with getter/setter
 * - Public methods for interface
 * - Validation in setters
 * - Benefits of encapsulation
 *
 * Real-life analogy:
 * Private = Locked drawers (private data)
 * Getters/Setters = Designated interfaces (controlled access)
 * Public methods = Welcome interface (public behavior)
 */
public class EncapsulationExample {

    /**
     * Student class with proper encapsulation
     */
    static class Student {
        // Private properties - hidden from outside
        private String name;
        private int age;
        private double gpa;

        /**
         * Constructor - initialize object
         */
        Student(String name, int age, double gpa) {
            setName(name);
            setAge(age);
            setGPA(gpa);
        }

        /**
         * Getter for name (read-only access)
         */
        String getName() {
            return name;
        }

        /**
         * Setter for name with validation
         */
        void setName(String name) {
            if (name != null && !name.isEmpty()) {
                this.name = name;
            } else {
                System.out.println("ERROR: Name cannot be empty");
            }
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
        void setAge(int age) {
            if (age >= 5 && age <= 40) {  // Reasonable student age
                this.age = age;
            } else {
                System.out.println("ERROR: Age must be between 5 and 40");
            }
        }

        /**
         * Getter for GPA
         */
        double getGPA() {
            return gpa;
        }

        /**
         * Setter for GPA with validation
         */
        void setGPA(double gpa) {
            if (gpa >= 0.0 && gpa <= 4.0) {  // Valid GPA range
                this.gpa = gpa;
            } else {
                System.out.println("ERROR: GPA must be between 0.0 and 4.0");
            }
        }

        /**
         * Public method to display info
         */
        void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
        }

        /**
         * Public method to check honor roll
         */
        boolean isOnHonorRoll() {
            return gpa >= 3.5;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Creating Student with Encapsulation ---\n");

        // Creating student
        Student student = new Student("Tejas", 20, 3.8);
        student.displayInfo();

        System.out.println("\n--- Testing Getters ---");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());

        System.out.println("\n--- Testing Setters with Valid Values ---");
        student.setName("Raj");
        student.setAge(21);
        student.setGPA(3.9);
        student.displayInfo();

        System.out.println("\n--- Testing Setters with INVALID Values ---");
        student.setName("");          // Invalid: empty name
        student.setAge(-5);           // Invalid: negative age
        student.setGPA(5.0);          // Invalid: GPA > 4.0

        System.out.println("\nAfter invalid attempts:");
        student.displayInfo();        // Still has valid values!

        System.out.println("\n--- Testing Public Methods ---");
        System.out.println("On honor roll: " + student.isOnHonorRoll());

        System.out.println("\n--- Key Benefits of Encapsulation ---");
        System.out.println("1. Data Protection: Invalid values are rejected");
        System.out.println("2. Validation: All changes go through setter logic");
        System.out.println("3. Consistency: Object always in valid state");
        System.out.println("4. Flexibility: Can change internal implementation later");

    }

}


