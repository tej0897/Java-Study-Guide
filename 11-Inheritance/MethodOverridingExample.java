/**
 * Day 11 - Inheritance: Method Overriding and Super Keyword
 *
 * Concept:
 * Method overriding allows a child class to provide different implementation
 * of a method inherited from parent. The 'super' keyword allows calling
 * the parent's version of the method.
 *
 * This example demonstrates:
 * - Method overriding with @Override annotation
 * - Using super to call parent method
 * - Extending parent behavior vs replacing it
 * - Polymorphic behavior
 *
 * Real-life analogy:
 * Parent: General greeting
 * Child: Specific greeting (can extend parent or replace)
 */
public class MethodOverridingExample {

    /**
     * Parent class: Shape
     */
    static class Shape {
        String name;

        Shape(String name) {
            this.name = name;
        }

        void display() {
            System.out.println("This is a shape: " + name);
        }

        double area() {
            return 0.0;
        }
    }

    /**
     * Child class: Circle
     */
    static class Circle extends Shape {
        double radius;

        Circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        /**
         * Extending parent method (calling super first)
         */
        @Override
        void display() {
            super.display();  // Call parent display
            System.out.println("Radius: " + radius);
        }

        /**
         * Replacing parent method (not calling super)
         */
        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    /**
     * Another child class: Rectangle
     */
    static class Rectangle extends Shape {
        double length;
        double width;

        Rectangle(String name, double length, double width) {
            super(name);
            this.length = length;
            this.width = width;
        }

        @Override
        void display() {
            super.display();  // Extend parent behavior
            System.out.println("Length: " + length + ", Width: " + width);
        }

        @Override
        double area() {
            return length * width;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Method Overriding Example ---\n");

        // Creating objects
        Circle circle = new Circle("Circle", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", 4.0, 6.0);

        System.out.println("--- Circle Information ---");
        circle.display();
        System.out.println("Area: " + circle.area());

        System.out.println("\n--- Rectangle Information ---");
        rectangle.display();
        System.out.println("Area: " + rectangle.area());

        System.out.println("\n--- Polymorphic Behavior ---");

        Shape[] shapes = {circle, rectangle};

        for (Shape shape : shapes) {
            System.out.println("\nProcessing " + shape.name + ":");
            shape.display();
            System.out.println("Area: " + shape.area());
        }

        System.out.println("\n--- Key Points ---");
        System.out.println("1. Both Circle and Rectangle extend parent's display()");
        System.out.println("2. Both replace parent's area() calculation");
        System.out.println("3. Using super.display() extends parent behavior");
        System.out.println("4. Polymorphic call (shape.area()) uses actual class's method");
        System.out.println("5. @Override annotation helps catch mistakes");

    }

}


