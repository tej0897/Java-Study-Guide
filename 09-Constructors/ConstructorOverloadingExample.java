/**
 * Day 9 - Constructors: Constructor Overloading
 *
 * Concept:
 * Constructor overloading allows multiple constructors in the same class
 * with different parameters. Java chooses the appropriate one based on arguments.
 *
 * This example demonstrates:
 * - Multiple constructors with different parameters
 * - How Java selects correct constructor
 * - Different initialization ways
 *
 * Real-life analogy:
 * Like a restaurant with multiple menus:
 * - Vegetarian menu
 * - Non-vegetarian menu
 * - Special diet menu
 * Customer chooses based on needs (similar to constructor selection)
 */
public class ConstructorOverloadingExample {

    /**
     * Rectangle class with multiple constructors
     */
    static class Rectangle {
        double length;
        double width;
        String color;

        // Constructor 1: No parameters
        Rectangle() {
            length = 1.0;
            width = 1.0;
            color = "Black";
            System.out.println("Default rectangle created");
        }

        // Constructor 2: Only dimensions
        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
            color = "Black";
            System.out.println("Rectangle with dimensions created");
        }

        // Constructor 3: All parameters
        Rectangle(double length, double width, String color) {
            this.length = length;
            this.width = width;
            this.color = color;
            System.out.println("Colored rectangle created");
        }

        // Method to calculate area
        double calculateArea() {
            return length * width;
        }

        // Method to display info
        void display() {
            System.out.println("Dimensions: " + length + " x " + width + ", Color: " + color);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Constructor Overloading in Action ---\n");

        // Using Constructor 1: No parameters
        System.out.println("Creating with Constructor 1 (no parameters):");
        Rectangle rect1 = new Rectangle();
        rect1.display();

        System.out.println("\n" + "Creating with Constructor 2 (dimensions):");
        // Using Constructor 2: Two parameters
        Rectangle rect2 = new Rectangle(5, 10);
        rect2.display();

        System.out.println("\n" + "Creating with Constructor 3 (all parameters):");
        // Using Constructor 3: Three parameters
        Rectangle rect3 = new Rectangle(7, 14, "Blue");
        rect3.display();

        System.out.println("\n--- Calculating Areas ---");
        System.out.println("Area of rect1: " + rect1.calculateArea());
        System.out.println("Area of rect2: " + rect2.calculateArea());
        System.out.println("Area of rect3: " + rect3.calculateArea());

    }

}


