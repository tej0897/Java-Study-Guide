/**
 * Day 3 - Control Flow: switch statement
 *
 * Concept:
 * The switch statement is used to execute one block of code
 * out of many options based on a fixed value.
 *
 * This example demonstrates:
 * - switch-case usage
 * - importance of break statement
 * - default case
 *
 * Real-life analogy:
 * Selecting a day:
 * 1 → Monday
 * 2 → Tuesday
 */
public class SwitchExample {

    /**
     * Main method demonstrating switch-case
     */
    public static void main(String[] args) {

        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            default:
                System.out.println("Invalid day");
        }
    }
}
