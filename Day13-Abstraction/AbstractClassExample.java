/**
 * Day 13 - Abstraction: Abstract Class Example
 *
 * Concept:
 * Abstract class cannot be instantiated and contains abstract methods
 * that must be implemented by child classes.
 *
 * This example demonstrates:
 * - Defining abstract class
 * - Abstract methods
 * - Concrete methods in abstract class
 * - Child implementation of abstract methods
 *
 * Real-life analogy:
 * Vehicle blueprint cannot be created directly,
 * but Car and Bike implement the blueprint
 */
public class AbstractClassExample {

    /**
     * Abstract class: Vehicle
     * Cannot be instantiated, must be extended
     */
    abstract static class Vehicle {
        String brand;

        /**
         * Constructor
         */
        Vehicle(String brand) {
            this.brand = brand;
        }

        /**
         * Abstract methods - must be implemented by child
         */
        abstract void start();
        abstract void stop();

        /**
         * Concrete method - has implementation
         */
        void displayBrand() {
            System.out.println("Brand: " + brand);
        }
    }

    /**
     * Concrete class: Car (implements abstract class)
     */
    static class Car extends Vehicle {

        Car(String brand) {
            super(brand);
        }

        /**
         * Implementing abstract method
         */
        @Override
        void start() {
            System.out.println(brand + " car starts with key");
        }

        @Override
        void stop() {
            System.out.println(brand + " car stops");
        }

        void openTrunk() {
            System.out.println(brand + " trunk opened");
        }
    }

    /**
     * Concrete class: Bike
     */
    static class Bike extends Vehicle {

        Bike(String brand) {
            super(brand);
        }

        @Override
        void start() {
            System.out.println(brand + " bike starts with kick");
        }

        @Override
        void stop() {
            System.out.println(brand + " bike stops");
        }

        void wheelie() {
            System.out.println(brand + " bike performing wheelie");
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Abstract Class Example ---\n");

        // WRONG: Cannot instantiate abstract class
        // Vehicle vehicle = new Vehicle("Generic");  // Compile error!

        // RIGHT: Create concrete subclass objects
        System.out.println("--- Creating Car ---");
        Vehicle car = new Car("Toyota");
        car.displayBrand();    // Inherited concrete method
        car.start();           // Implemented abstract method
        car.stop();            // Implemented abstract method
        // car.openTrunk();    // Not accessible through Vehicle reference

        System.out.println("\n--- Creating Bike ---");
        Vehicle bike = new Bike("Honda");
        bike.displayBrand();   // Inherited concrete method
        bike.start();          // Implemented abstract method
        bike.stop();           // Implemented abstract method

        System.out.println("\n--- Key Points ---");
        System.out.println("1. Vehicle is abstract - cannot create directly");
        System.out.println("2. Car and Bike implement abstract methods");
        System.out.println("3. Concrete methods inherited by all");
        System.out.println("4. Each child provides own implementation");

    }

}


