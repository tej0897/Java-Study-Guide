/**
 * Day 2 - Variables in Java
 *
 * Concept:
 * A variable is a container used to store data in memory.
 * Each variable has:
 * - A data type (what kind of data it can store)
 * - A name (identifier)
 * - A value (actual data)
 *
 * This example demonstrates:
 * - Declaration and initialization of variables
 * - Different types of variables
 *
 * Real-life analogy:
 * Variable = Box
 * Value = Item inside the box
 */
public class VariablesExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        // Declaring variables
        int age;
        String name;

        // Initializing variables
        age = 25;
        name = "Tejas";

        // Printing values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        // Updating variable value
        age = 30;
        System.out.println("Updated Age: " + age);
    }
}
