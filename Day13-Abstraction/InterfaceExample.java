/**
 * Day 13 - Abstraction: Interface Example
 *
 * Concept:
 * Interface is a contract that specifies what methods a class must implement.
 * Multiple classes can implement the same interface.
 *
 * This example demonstrates:
 * - Defining interface
 * - Implementing interface
 * - Multiple implementations
 * - Interface reference and polymorphism
 *
 * Real-life analogy:
 * Interface = Contract/Promise
 * Implementation = Fulfilling the contract
 */
public class InterfaceExample {

    /**
     * Interface: Shape
     * Contract: what methods a shape must have
     */
    interface Shape {
        double area();
        double perimeter();
        void display();
    }

    /**
     * Implementing class: Circle
     */
    static class Circle implements Shape {
        double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public void display() {
            System.out.println("Circle with radius: " + radius);
        }
    }

    /**
     * Implementing class: Rectangle
     */
    static class Rectangle implements Shape {
        double length;
        double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double area() {
            return length * width;
        }

        @Override
        public double perimeter() {
            return 2 * (length + width);
        }

        @Override
        public void display() {
            System.out.println("Rectangle " + length + " x " + width);
        }
    }

    /**
     * Implementing class: Triangle
     */
    static class Triangle implements Shape {
        double a, b, c;

        Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }

        @Override
        public void display() {
            System.out.println("Triangle with sides: " + a + ", " + b + ", " + c);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Interface Example ---\n");

        // Cannot instantiate interface
        // Shape shape = new Shape();  // Compile error!

        // Create instances of implementing classes
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println("--- Polymorphic Array of Shapes ---\n");

        Shape[] shapes = {circle, rectangle, triangle};

        for (Shape shape : shapes) {
            shape.display();
            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
            System.out.println();
        }

        System.out.println("--- Key Points ---");
        System.out.println("1. Shape is interface (contract)");
        System.out.println("2. Circle, Rectangle, Triangle implement Shape");
        System.out.println("3. Each provides own implementation");
        System.out.println("4. Can use polymorphic array");
        System.out.println("5. Same interface, different behaviors");

    }

}


