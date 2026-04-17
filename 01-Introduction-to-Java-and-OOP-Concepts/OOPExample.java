/**
 * Day 1 - OOP Basics: Class and Object
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>How to define a class (blueprint)</li>
 *   <li>How to create an object using {@code new}</li>
 *   <li>How to set fields and call methods on that object</li>
 * </ul>
 *
 * <p><b>Real-life analogy</b>
 * <pre>
 * Class  = a car model blueprint
 * Object = one specific car built from that blueprint (e.g., "BMW #1")
 * </pre>
 *
 * <p><b>Note</b>: This example intentionally keeps fields package-private
 * to keep the Day 1 learning curve gentle. In Day 10 (Encapsulation), these
 * fields will become {@code private} with getters/setters.
 */
class SimpleCar {

    /** Human-readable color of the car (e.g., "Red"). */
    String color;

    /** Current speed in km/h. */
    int speed;

    /**
     * Simulates driving.
     *
     * <p>In real-world code you'd likely validate state and interact with more objects.
     * Here we simply print a message to the console.
     */
    void drive() {
        if (speed < 0) {
            // Small validation to teach defensive thinking early
            System.out.println("Invalid speed: " + speed + " km/h");
            return;
        }
        System.out.println("Car is driving at speed: " + speed + " km/h");
    }
}

/**
 * Runner class for the Day 1 example.
 */
public class OOPExample {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used in this example)
     */
    public static void main(String[] args) {

        // 1) Create an object of the Car class
        SimpleCar car1 = new SimpleCar();

        // 2) Assign values (state)
        car1.color = "Red";
        car1.speed = 60;

        // 3) Read fields and call methods (behavior)
        System.out.println("Car Color: " + car1.color);
        car1.drive();

        // Another object is a different instance with its own state
        SimpleCar car2 = new SimpleCar();
        car2.color = "Blue";
        car2.speed = 80;
        System.out.println("Car Color: " + car2.color);
        car2.drive();
    }
}
