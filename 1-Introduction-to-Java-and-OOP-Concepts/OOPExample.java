/**
 * Day 1 - OOP Basics: Class and Object
 *
 * Concept:
 * In Object-Oriented Programming, a class is a blueprint and an object is an instance of that class.
 *
 * This example demonstrates:
 * - How to define a class
 * - How to create an object
 * - How to access properties and methods
 *
 * Real-life analogy:
 * Class = Car blueprint
 * Object = Actual car (BMW, Audi)
 */
class Car {

    /**
     * Property representing color of the car
     */
    String color;

    /**
     * Property representing speed of the car
     */
    int speed;

    /**
     * Method to simulate driving behavior
     */
    void drive() {
        System.out.println("Car is driving at speed: " + speed);
    }
}

public class OOPExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        // Creating object of Car class
        Car car1 = new Car();

        // Assigning values
        car1.color = "Red";
        car1.speed = 60;

        // Accessing properties and methods
        System.out.println("Car Color: " + car1.color);
        car1.drive();
    }
}
