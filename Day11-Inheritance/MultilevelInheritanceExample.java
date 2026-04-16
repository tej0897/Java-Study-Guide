/**
 * Day 11 - Inheritance: Multilevel Inheritance
 *
 * Concept:
 * Multilevel inheritance is when a child class becomes a parent for another class,
 * creating a chain of inheritance: Grandparent → Parent → Child
 *
 * This example demonstrates:
 * - Three-level hierarchy
 * - Constructor chain through super()
 * - Method overriding at each level
 * - Accessing methods from different levels
 *
 * Real-life analogy:
 * Traits passed from grandfather → father → son
 */
public class MultilevelInheritanceExample {

    /**
     * Level 1: Grandparent Class
     */
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
            System.out.println("Animal constructor called");
        }

        void eat() {
            System.out.println(name + " is eating");
        }

        void sleep() {
            System.out.println(name + " is sleeping");
        }
    }

    /**
     * Level 2: Parent Class (extends Animal)
     */
    static class Dog extends Animal {
        String breed;

        Dog(String name, String breed) {
            super(name);  // Call grandparent constructor
            this.breed = breed;
            System.out.println("Dog constructor called");
        }

        @Override
        void eat() {
            System.out.println(name + " dog is eating bones");
        }

        void bark() {
            System.out.println(name + " barks: Woof Woof");
        }
    }

    /**
     * Level 3: Child Class (extends Dog)
     */
    static class GoldenRetriever extends Dog {
        String color;

        GoldenRetriever(String name, String breed, String color) {
            super(name, breed);  // Call parent (Dog) constructor
            this.color = color;
            System.out.println("GoldenRetriever constructor called");
        }

        @Override
        void eat() {
            System.out.println(name + " golden retriever eats premium dog food");
        }

        void retrieve() {
            System.out.println(name + " retrieves the ball");
        }

        void displayInfo() {
            System.out.println("Name: " + name + ", Breed: " + breed + ", Color: " + color);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Creating GoldenRetriever Object ---\n");

        GoldenRetriever dog = new GoldenRetriever("Max", "Golden Retriever", "Golden");

        System.out.println("\n--- Constructor Chain Visualization ---");
        System.out.println("GoldenRetriever() → Dog() → Animal()");

        System.out.println("\n--- Displaying Information ---");
        dog.displayInfo();

        System.out.println("\n--- Calling Methods from Different Levels ---");

        // From Animal class
        dog.sleep();  // Inherited, not overridden

        // From Dog class
        dog.bark();   // Inherited, not overridden

        // Overridden method
        dog.eat();    // Called from GoldenRetriever

        // New method in GoldenRetriever
        dog.retrieve();

        System.out.println("\n--- Multilevel Inheritance Hierarchy ---");
        System.out.println("Animal (Level 1: Grandparent)");
        System.out.println("  └─ Dog (Level 2: Parent)");
        System.out.println("      └─ GoldenRetriever (Level 3: Child)");

        System.out.println("\n--- Method Resolution ---");
        System.out.println("eat(): Found in GoldenRetriever (uses this)");
        System.out.println("bark(): Found in Dog (inherited)");
        System.out.println("sleep(): Found in Animal (inherited)");
        System.out.println("retrieve(): Found in GoldenRetriever (new)");

    }

}


