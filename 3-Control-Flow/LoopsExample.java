/**
 * Day 3 - Control Flow: Loops (for, while, do-while)
 *
 * Concept:
 * Loops are used to execute a block of code repeatedly
 * based on a condition.
 *
 * Types covered:
 * - for loop
 * - while loop
 * - do-while loop
 *
 * Real-life analogy:
 * Repeating actions like:
 * - Walking steps
 * - Daily routines
 */
public class LoopsExample {

    /**
     * Main method demonstrating different loops
     */
    public static void main(String[] args) {

        // for loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // while loop
        System.out.println("\nWhile Loop:");
        int j = 1;
        while (j <= 5) {
            System.out.println(j);
            j++;
        }

        // do-while loop
        System.out.println("\nDo-While Loop:");
        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k <= 5);
    }
}
