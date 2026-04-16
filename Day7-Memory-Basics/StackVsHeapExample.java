/**
 * Day 7 - Memory Basics: Stack vs Heap
 *
 * Concept:
 * Java uses two types of memory:
 * 1. Stack - for primitives and method calls (fast, limited)
 * 2. Heap - for objects (slower, large, automatic cleanup)
 *
 * This example demonstrates:
 * - How primitives are stored on stack
 * - How objects are stored on heap with references on stack
 * - Difference between primitive and reference assignment
 *
 * Real-life analogy:
 * Stack = Quick, organized checkout counter
 * Heap = Slower, large storage warehouse
 */
public class StackVsHeapExample {

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        System.out.println("--- Primitives (Stack Storage) ---");

        // Primitives stored on stack
        int age = 25;
        int salary = 100000;

        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        // Modifying primitives
        int temp = age;
        age = salary;
        salary = temp;

        System.out.println("After swap:");
        System.out.println("Age: " + age);        // 100000
        System.out.println("Salary: " + salary);  // 25

        // Key: Primitives are INDEPENDENT

        System.out.println("\n--- Objects (Heap Storage) ---");

        // Objects stored on heap, references on stack
        Student s1 = new Student("Tejas", 20);
        Student s2 = s1;  // s2 gets same reference

        System.out.println("s1: " + s1.name + ", Age: " + s1.age);
        System.out.println("s2: " + s2.name + ", Age: " + s2.age);

        // Modifying through s1
        s1.name = "Raja";

        System.out.println("\nAfter s1.name = 'Raja':");
        System.out.println("s1: " + s1.name);  // "Raja"
        System.out.println("s2: " + s2.name);  // "Raja" (same object)

        // Key: Both references point to SAME object

        System.out.println("\n--- Creating New Object ---");

        // s2 now points to different object
        s2 = new Student("Priya", 19);

        System.out.println("s1: " + s1.name + ", Age: " + s1.age);  // "Raja"
        System.out.println("s2: " + s2.name + ", Age: " + s2.age);  // "Priya"

        // Now s1 and s2 point to DIFFERENT objects

        System.out.println("\n--- Mixed Primitive and Reference ---");

        demonstrateMemory();

    }

    /**
     * Method to demonstrate stack and heap memory usage
     */
    public static void demonstrateMemory() {

        // Variables on stack
        int price = 50000;           // Primitive on stack
        String carModel = "Tesla";   // Reference on stack, String on heap
        Car car = new Car("Red");    // Reference on stack, Car object on heap

        System.out.println("Inside method:");
        System.out.println("Price: " + price);
        System.out.println("Model: " + carModel);
        System.out.println("Car color: " + car.color);

        // After method ends:
        // - All stack variables freed
        // - Heap objects freed when no references exist
    }

    /**
     * Inner class to represent Student
     */
    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    /**
     * Inner class to represent Car
     */
    static class Car {
        String color;

        Car(String color) {
            this.color = color;
        }
    }

}


