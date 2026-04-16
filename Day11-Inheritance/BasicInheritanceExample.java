/**
 * Day 11 - Inheritance: Basic Inheritance Example
 *
 * Concept:
 * Inheritance allows a child class to inherit properties and methods
 * from a parent class. This enables code reuse and building class hierarchies.
 *
 * This example demonstrates:
 * - Parent class defining common behavior
 * - Child class inheriting and extending behavior
 * - Using inherited methods
 * - Method overriding
 *
 * Real-life analogy:
 * Parent = General vehicle properties
 * Child = Specific vehicle type (Car, Bike, Truck)
 */
public class BasicInheritanceExample {

    /**
     * Parent class: Vehicle
     */
    static class Vehicle {
        String brand;
        String color;
        int year;

        /**
         * Constructor
         */
        Vehicle(String brand, String color, int year) {
            this.brand = brand;
            this.color = color;
            this.year = year;
        }

        /**
         * Method in parent class
         */
        void start() {
            System.out.println(brand + " " + color + " vehicle is starting");
        }

        void stop() {
            System.out.println(brand + " vehicle stopped");
        }

        void displayInfo() {
            System.out.println("Brand: " + brand + ", Color: " + color + ", Year: " + year);
        }
    }

    /**
     * Child class: Car
     * Inherits from Vehicle
     */
    static class Car extends Vehicle {
        int doors;

        /**
         * Constructor calling parent constructor using super()
         */
        Car(String brand, String color, int year, int doors) {
            super(brand, color, year);  // Call parent constructor
            this.doors = doors;
        }

        /**
         * Additional method specific to Car
         */
        void openTrunk() {
            System.out.println(brand + " trunk opened");
        }

        /**
         * Override parent method (different implementation)
         */
        @Override
        void start() {
            System.out.println(brand + " car is starting with key");
        }

        void displayCarInfo() {
            displayInfo();  // Call inherited method
            System.out.println("Doors: " + doors);
        }
    }

    /**
     * Another child class: Bike
     */
    static class Bike extends Vehicle {
        boolean hasStorage;

        Bike(String brand, String color, int year, boolean hasStorage) {
            super(brand, color, year);
            this.hasStorage = hasStorage;
        }

        /**
         * Override parent method
         */
        @Override
        void start() {
            System.out.println(brand + " bike is starting with kick");
        }

        void displayBikeInfo() {
            displayInfo();
            System.out.println("Has Storage: " + hasStorage);
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Single Inheritance Example ---\n");

        // Creating Car object
        Car car = new Car("Toyota", "Red", 2023, 4);
        System.out.println("Car Information:");
        car.displayCarInfo();

        System.out.println("\n--- Using Inherited and Overridden Methods ---");
        car.start();    // Overridden method
        car.stop();     // Inherited method
        car.openTrunk(); // New method specific to Car

        System.out.println("\n--- Another Child Class: Bike ---\n");

        Bike bike = new Bike("Honda", "Black", 2022, true);
        System.out.println("Bike Information:");
        bike.displayBikeInfo();

        System.out.println("\n--- Using Bike Methods ---");
        bike.start();   // Overridden method (different from car)
        bike.stop();    // Inherited method (same for both)

        System.out.println("\n--- Key Observations ---");
        System.out.println("1. Car and Bike inherit common methods from Vehicle");
        System.out.println("2. Each class overrides start() differently");
        System.out.println("3. Both use inherited stop() and displayInfo() methods");
        System.out.println("4. Car has doors, Bike has hasStorage (unique to each)");

    }

}


