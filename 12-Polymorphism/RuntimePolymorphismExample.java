/**
 * Day 12 - Polymorphism: Runtime Polymorphism (Overriding + Dynamic Dispatch)
 *
 * <p><b>Concept</b>
 * Runtime polymorphism occurs when:
 * <ul>
 *   <li>a parent reference points to a child object</li>
 *   <li>a method is overridden in the child</li>
 *   <li>the JVM decides at runtime which implementation to execute</li>
 * </ul>
 *
 * <p><b>Real-life analogy</b>
 * A remote control has the same buttons (contract), but different devices respond differently.
 */
public class RuntimePolymorphismExample {

    /** Parent type. */
    static class Animal {
        private final String name;

        Animal(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name must be non-blank");
            }
            this.name = name;
        }

        String getName() {
            return name;
        }

        void sound() {
            System.out.println("Animal makes a sound");
        }

        void move() {
            System.out.println("Animal moves");
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{" + "name='" + name + "'}";
        }
    }

    static class Dog extends Animal {
        Dog(String name) { super(name); }

        @Override
        void sound() {
            System.out.println(getName() + " barks: Woof Woof");
        }

        @Override
        void move() {
            System.out.println(getName() + " runs on four legs");
        }
    }

    static class Bird extends Animal {
        Bird(String name) { super(name); }

        @Override
        void sound() {
            System.out.println(getName() + " chirps: Tweet Tweet");
        }

        @Override
        void move() {
            System.out.println(getName() + " flies in the sky");
        }
    }

    static class Fish extends Animal {
        Fish(String name) { super(name); }

        @Override
        void sound() {
            System.out.println(getName() + " makes bubbling sound");
        }

        @Override
        void move() {
            System.out.println(getName() + " swims in water");
        }
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Runtime Polymorphism ---\n");

        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");
        Animal fish = new Fish("Nemo");

        Animal[] animals = {dog, bird, fish};

        System.out.println("All stored as Animal, but behavior differs at runtime:\n");
        for (Animal a : animals) {
            System.out.println("Processing: " + a);
            a.sound();
            a.move();
            System.out.println();
        }

        System.out.println("Key insight: method call dispatch depends on actual object type.");
    }
}
