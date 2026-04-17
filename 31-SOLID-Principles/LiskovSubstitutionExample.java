/**
 * Day 31 - SOLID Principles: Liskov Substitution Principle (LSP)
 *
 * <p>Subtypes must be substitutable for their base types.
 *
 * <p>This example shows a safe design: behavior is separated into smaller interfaces
 * so we don't force every subtype to support operations it can't perform.
 */
public class LiskovSubstitutionExample {

    interface Bird {
        String name();
    }

    interface FlyingBird extends Bird {
        void fly();
    }

    static class Sparrow implements FlyingBird {
        public String name() { return "Sparrow"; }
        public void fly() { System.out.println(name() + " flies"); }
    }

    static class Penguin implements Bird {
        public String name() { return "Penguin"; }
        void swim() { System.out.println(name() + " swims"); }
    }

    static void makeItFly(FlyingBird bird) {
        // This method accepts ONLY birds that can fly.
        System.out.println("Trying to fly: " + bird.name());
        bird.fly();
    }

    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle (LSP) ===\n");

        FlyingBird sparrow = new Sparrow();
        makeItFly(sparrow);

        Bird penguin = new Penguin();
        System.out.println("A bird that does not fly: " + penguin.name());

        System.out.println("\nKey Points:");
        System.out.println("1. Avoid base types that imply behavior not all subtypes support");
        System.out.println("2. Prefer smaller interfaces (e.g., FlyingBird) to keep substitutability");
    }
}

