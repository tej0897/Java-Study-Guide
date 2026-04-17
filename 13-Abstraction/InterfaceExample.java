/**
 * Day 13 - Abstraction: Interface as a Contract
 *
 * <p><b>Concept</b>
 * An interface defines a contract: what operations a type must support.
 * Implementing classes provide the concrete behavior.
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>Defining an interface ({@code Shape})</li>
 *   <li>Multiple implementations (Circle/Rectangle/Triangle)</li>
 *   <li>Using an interface reference for polymorphism</li>
 * </ul>
 */
public class InterfaceExample {

    /**
     * Contract for shapes.
     * In real systems you might separate printing (display) from the domain.
     */
    interface Shape {
        double area();

        double perimeter();

        void display();
    }

    static class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            if (radius <= 0) {
                throw new IllegalArgumentException("radius must be > 0");
            }
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
            System.out.println("Circle(radius=" + radius + ")");
        }
    }

    static class Rectangle implements Shape {
        private final double length;
        private final double width;

        Rectangle(double length, double width) {
            if (length <= 0 || width <= 0) {
                throw new IllegalArgumentException("length and width must be > 0");
            }
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
            System.out.println("Rectangle(" + length + " x " + width + ")");
        }
    }

    static class Triangle implements Shape {
        private final double a;
        private final double b;
        private final double c;

        Triangle(double a, double b, double c) {
            if (a <= 0 || b <= 0 || c <= 0) {
                throw new IllegalArgumentException("triangle sides must be > 0");
            }
            // Triangle inequality: each side < sum of the other two
            if (a + b <= c || a + c <= b || b + c <= a) {
                throw new IllegalArgumentException("invalid triangle sides (triangle inequality violated)");
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            // Heron's formula
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }

        @Override
        public void display() {
            System.out.println("Triangle(" + a + ", " + b + ", " + c + ")");
        }
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Interface Example ---\n");

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4, 5);

        Shape[] shapes = {circle, rectangle, triangle};

        System.out.println("--- Polymorphic processing through interface ---\n");
        for (Shape s : shapes) {
            s.display();
            System.out.printf("Area: %.2f%n", s.area());
            System.out.printf("Perimeter: %.2f%n%n", s.perimeter());
        }

        System.out.println("Key idea: callers depend on the Shape contract, not concrete classes.");
    }
}
