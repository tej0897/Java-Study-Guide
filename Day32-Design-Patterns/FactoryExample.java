/**
 * Day 32 - Design Patterns: Factory
 */
public class FactoryPatternExample {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() { System.out.println("Drawing Circle"); }
    }

    static class Square implements Shape {
        public void draw() { System.out.println("Drawing Square"); }
    }

    static class ShapeFactory {
        static Shape createShape(String type) {
            if ("circle".equalsIgnoreCase(type)) {
                return new Circle();
            } else if ("square".equalsIgnoreCase(type)) {
                return new Square();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        Shape square = ShapeFactory.createShape("square");

        circle.draw();
        square.draw();
    }
}


