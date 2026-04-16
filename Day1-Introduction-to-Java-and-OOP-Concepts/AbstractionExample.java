/**
 * Day 1 - Abstraction
 *
 * Concept:
 * Abstraction means hiding implementation details and showing only essential features.
 *
 * This example demonstrates:
 * - Abstract class
 * - Abstract method
 * - Implementation in child class
 *
 * Real-life analogy:
 * Driving a car → you use steering and pedals,
 * but you don't see engine internals
 */
abstract class Vehicle {

    /**
     * Abstract method - no implementation
     * Must be implemented by child class
     */
    abstract void start();
}

class Car extends Vehicle {

    /**
     * Implementation of abstract method
     */
    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}

public class AbstractionExample {

    /**
     * Main method demonstrating abstraction
     */
    public static void main(String[] args) {

        Vehicle vehicle = new Car();
        vehicle.start();
    }
}
