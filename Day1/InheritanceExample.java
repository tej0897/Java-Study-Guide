/**
 * Day 1 - Inheritance
 *
 * Concept:
 * Inheritance allows one class (child) to acquire properties and methods of another class (parent).
 *
 * This example demonstrates:
 * - Parent class (Animal)
 * - Child class (Dog)
 * - Reusability of code
 *
 * Real-life analogy:
 * Dog is an Animal → inherits eating behavior
 */
class Animal {

    /**
     * Method common to all animals
     */
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    /**
     * Method specific to Dog
     */
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class InheritanceExample {

    /**
     * Main method demonstrating inheritance
     */
    public static void main(String[] args) {

        Dog dog = new Dog();

        // Inherited method
        dog.eat();

        // Child-specific method
        dog.bark();
    }
}
