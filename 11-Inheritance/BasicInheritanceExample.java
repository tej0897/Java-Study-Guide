/**
 * Day 11 - Inheritance: Basic Inheritance (Single Inheritance) + Overriding
 *
 * <p><b>Concept</b>
 * Inheritance models an <b>IS-A</b> relationship:
 * <pre>
 * Car is a Vehicle
 * Bike is a Vehicle
 * </pre>
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>A base class ({@code Vehicle}) holding common state/behavior</li>
 *   <li>Child classes ({@code Car}, {@code Bike}) that reuse + specialize</li>
 *   <li>Method overriding ({@code start()}) to provide type-specific behavior</li>
 *   <li>Calling the parent constructor using {@code super(...)} </li>
 * </ul>
 */
public class BasicInheritanceExample {

    /** Base class: holds common vehicle state and behavior. */
    static class Vehicle {
        private final String brand;
        private final String color;
        private final int year;

        Vehicle(String brand, String color, int year) {
            if (brand == null || brand.isBlank()) {
                throw new IllegalArgumentException("brand must be non-blank");
            }
            if (color == null || color.isBlank()) {
                throw new IllegalArgumentException("color must be non-blank");
            }
            if (year < 1886) { // first automobile era (approx)
                throw new IllegalArgumentException("year looks invalid: " + year);
            }
            this.brand = brand;
            this.color = color;
            this.year = year;
        }

        /** Common behavior: subclasses may override. */
        void start() {
            System.out.println(brand + " " + color + " vehicle is starting");
        }

        /** Common behavior shared as-is. */
        void stop() {
            System.out.println(brand + " vehicle stopped");
        }

        void displayInfo() {
            System.out.println("Brand: " + brand + ", Color: " + color + ", Year: " + year);
        }

        String getBrand() {
            return brand;
        }
    }

    /** Child class: Car extends Vehicle and adds car-specific behavior. */
    static class Car extends Vehicle {
        private final int doors;

        Car(String brand, String color, int year, int doors) {
            super(brand, color, year);
            if (doors <= 0) {
                throw new IllegalArgumentException("doors must be positive");
            }
            this.doors = doors;
        }

        void openTrunk() {
            System.out.println(getBrand() + " trunk opened");
        }

        /** Overrides Vehicle.start() with car-specific logic. */
        @Override
        void start() {
            System.out.println(getBrand() + " car is starting with key");
        }

        void displayCarInfo() {
            displayInfo();
            System.out.println("Doors: " + doors);
        }
    }

    /** Child class: Bike extends Vehicle and adds bike-specific behavior/fields. */
    static class Bike extends Vehicle {
        private final boolean hasStorage;

        Bike(String brand, String color, int year, boolean hasStorage) {
            super(brand, color, year);
            this.hasStorage = hasStorage;
        }

        @Override
        void start() {
            System.out.println(getBrand() + " bike is starting with kick");
        }

        void displayBikeInfo() {
            displayInfo();
            System.out.println("Has Storage: " + hasStorage);
        }
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Single Inheritance Example ---\n");

        Car car = new Car("Toyota", "Red", 2023, 4);
        System.out.println("Car Information:");
        car.displayCarInfo();

        System.out.println("\n--- Using Overridden + Inherited Methods ---");
        car.start();      // overridden
        car.stop();       // inherited
        car.openTrunk();  // car-specific

        System.out.println("\n--- Another Child Class: Bike ---\n");
        Bike bike = new Bike("Honda", "Black", 2022, true);
        System.out.println("Bike Information:");
        bike.displayBikeInfo();

        System.out.println("\n--- Key Observations ---");
        System.out.println("1) Both Car and Bike reuse Vehicle fields/methods");
        System.out.println("2) Both override start() differently");
        System.out.println("3) stop() is shared and reused as-is");
    }
}
