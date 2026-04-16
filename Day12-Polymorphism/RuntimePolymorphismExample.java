/**
 * Day 12 - Polymorphism: Runtime Polymorphism
 *
 * Concept:
 * Runtime polymorphism occurs when a parent reference points to child objects
 * and the method called is determined at runtime based on actual object type.
 *
 * This example demonstrates:
 * - Parent reference holding child objects
 * - Runtime method resolution
 * - Polymorphic collections
 * - Same interface, different behaviors
 *
 * Real-life analogy:
 * Remote control (interface) works with different devices (implementations)
 */
public class RuntimePolymorphismExample {

    /**
     * Parent class: Animal
     */
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void sound() {
            System.out.println("Animal makes sound");
        }

        void move() {
            System.out.println("Animal moves");
        }
    }

    /**
     * Child class: Dog
     */
    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void sound() {
            System.out.println(name + " barks: Woof Woof");
        }

        @Override
        void move() {
            System.out.println(name + " runs on four legs");
        }
    }

    /**
     * Child class: Bird
     */
    static class Bird extends Animal {
        Bird(String name) {
            super(name);
        }

        @Override
        void sound() {
            System.out.println(name + " chirps: Tweet Tweet");
        }

        @Override
        void move() {
            System.out.println(name + " flies in the sky");
        }
    }

    /**
     * Child class: Fish
     */
    static class Fish extends Animal {
        Fish(String name) {
            super(name);
        }

        @Override
        void sound() {
            System.out.println(name + " makes bubbling sound");
        }

        @Override
        void move() {
            System.out.println(name + " swims in water");
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Runtime Polymorphism ---\n");

        // Parent reference, child objects
        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");
        Animal fish = new Fish("Nemo");

        System.out.println("--- Polymorphic Method Calls ---");
        System.out.println("Method resolved at RUNTIME based on actual object type:\n");

        dog.sound();   // Calls Dog.sound()
        dog.move();    // Calls Dog.move()

        System.out.println();

        bird.sound();  // Calls Bird.sound()
        bird.move();   // Calls Bird.move()

        System.out.println();

        fish.sound();  // Calls Fish.sound()
        fish.move();   // Calls Fish.move()

        System.out.println("\n--- Polymorphic Array ---");
        System.out.println("All stored as Animal but behave differently:\n");

        Animal[] animals = {dog, bird, fish};

        for (Animal animal : animals) {
            System.out.println("Processing " + animal.name + ":");
            animal.sound();
            animal.move();
            System.out.println();
        }

        System.out.println("--- Key Insight ---");
        System.out.println("Same method name (sound, move)");
        System.out.println("Different behavior based on actual object type");
        System.out.println("This is the power of polymorphism!");

    }

}


