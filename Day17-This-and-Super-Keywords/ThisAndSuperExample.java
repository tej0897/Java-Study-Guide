/**
 * Day 17 - This and Super Keywords: Examples
 *
 * Concept:
 * 'this' refers to current object, 'super' refers to parent class.
 *
 * This example demonstrates:
 * - Using this for property distinction
 * - Using super to call parent methods
 * - Constructor chaining
 */
public class ThisAndSuperExample {

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void sound() {
            System.out.println(name + " makes sound");
        }
    }

    static class Dog extends Animal {
        String breed;

        Dog(String name, String breed) {
            super(name);  // Call parent constructor
            this.breed = breed;
        }

        @Override
        void sound() {
            super.sound();  // Call parent method
            System.out.println(name + " barks");
        }

        void displayInfo() {
            System.out.println("Name: " + this.name);
            System.out.println("Breed: " + this.breed);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== This and Super Keywords ===\n");

        Dog dog = new Dog("Buddy", "Golden Retriever");

        System.out.println("--- Using this (current object) ---");
        dog.displayInfo();

        System.out.println("\n--- Using super (parent method) ---");
        dog.sound();

        System.out.println("\nKey Points:");
        System.out.println("1. this: refers to current object");
        System.out.println("2. super: refers to parent class");
        System.out.println("3. super(): calls parent constructor");
        System.out.println("4. super.method(): calls parent method");
    }
}


