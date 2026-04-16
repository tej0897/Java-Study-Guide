/**
 * Day 16 - Final Keyword: Methods and Classes
 *
 * Concept:
 * final methods prevent overriding, final classes prevent inheritance.
 * This example demonstrates: final methods and final classes
 */
public class FinalMethodsAndClassesExample {

    // Regular class (can be extended)
    static class Vehicle {
        void start() {
            System.out.println("Vehicle starting");
        }

        // final method - cannot override
        final void honk() {
            System.out.println("Honk!");
        }
    }

    // Child extends Vehicle
    static class Car extends Vehicle {
        @Override
        void start() {
            System.out.println("Car starting with key");
        }

        // void honk() { }  // ERROR: final method
    }

    // final class - cannot be extended
    final static class ImmutableConfig {
        private final String setting;

        ImmutableConfig(String setting) {
            this.setting = setting;
        }

        String getSetting() { return setting; }
    }

    // class Child extends ImmutableConfig { }  // ERROR: final class

    public static void main(String[] args) {
        System.out.println("=== Final Methods and Classes ===\n");

        System.out.println("--- Method Overriding ---");
        Vehicle vehicle = new Car();
        vehicle.start();   // Overridden in Child
        vehicle.honk();    // final - cannot override

        System.out.println("\n--- Final Class ---");
        ImmutableConfig config = new ImmutableConfig("production");
        System.out.println("Config: " + config.getSetting());

        System.out.println("\nKey Points:");
        System.out.println("1. final methods: Cannot be overridden");
        System.out.println("2. final classes: Cannot be extended");
        System.out.println("3. String class is final (prevents modification)");
        System.out.println("4. Use final for security and immutability");
    }
}


