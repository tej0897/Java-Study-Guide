/**
 * Day 34 - Java 8 Features: Default Methods
 */
public class DefaultMethodExample {

    interface Animal {
        void eat();

        default void sleep() {
            System.out.println("Sleeping...");
        }
    }

    static class Dog implements Animal {
        public void eat() {
            System.out.println("Dog eating");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}


