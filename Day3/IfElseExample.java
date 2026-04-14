/**
 * Day 3 - Control Flow: if, if-else, if-else-if
 *
 * Concept:
 * Conditional statements allow the program to make decisions
 * based on certain conditions.
 *
 * This example demonstrates:
 * - Simple if statement
 * - if-else statement
 * - if-else-if ladder
 *
 * Real-life analogy:
 * Decision making like:
 * IF it rains → take umbrella
 * ELSE → go normally
 */
public class IfElseExample {

    /**
     * Main method demonstrating conditional statements
     */
    public static void main(String[] args) {

        int age = 20;

        // Simple if
        if (age >= 18) {
            System.out.println("Eligible to vote");
        }

        // if-else
        int marks = 40;

        if (marks >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // if-else-if ladder
        int score = 85;

        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 75) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }
    }
}
