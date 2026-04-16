/**
 * Day 2 - Operators in Java
 *
 * Concept:
 * Operators are used to perform operations on variables and values.
 *
 * Types covered:
 * - Arithmetic Operators
 * - Relational Operators
 * - Logical Operators
 *
 * Real-life analogy:
 * Operators are like actions:
 * +  → addition
 * >  → comparison
 * && → decision making
 */
public class OperatorsExample {

    /**
     * Main method demonstrating operators
     */
    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // Arithmetic Operators
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Relational Operators
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        // Logical Operators
        boolean condition1 = (a > 5);
        boolean condition2 = (b < 10);

        System.out.println("condition1 && condition2: " + (condition1 && condition2));
        System.out.println("condition1 || condition2: " + (condition1 || condition2));
        System.out.println("!condition1: " + (!condition1));

        // Real-world example
        int marks = 85;
        int age = 20;

        if (marks > 50 && age > 18) {
            System.out.println("Eligible");
        } else {
            System.out.println("Not Eligible");
        }
    }
}
