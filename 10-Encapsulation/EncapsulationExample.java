/**
 * Day 10 - Encapsulation: Access Modifiers + Validation
 *
 * <p><b>Concept</b>
 * Encapsulation is about protecting an object's internal state (fields)
 * and exposing only a controlled API (methods).
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>Private fields</li>
 *   <li>Getters and setters with validation</li>
 *   <li>Domain-style methods (e.g., {@code isOnHonorRoll()})</li>
 *   <li>Keeping an object in a valid state via invariants</li>
 * </ul>
 *
 * <p><b>Real-life analogy</b>
 * A bank account does not allow direct access to balance.
 * You must use deposit/withdraw, which enforce rules.
 */
public class EncapsulationExample {

    /**
     * A simple Student class demonstrating proper encapsulation.
     *
     * <p>Invariants:
     * <ul>
     *   <li>name is non-blank</li>
     *   <li>age is within a reasonable range</li>
     *   <li>gpa is between 0.0 and 4.0</li>
     * </ul>
     */
    static class Student {
        private String name;
        private int age;
        private double gpa;

        /**
         * Constructs a Student in a valid state.
         *
         * @param name student's name (non-blank)
         * @param age  student's age (5..40)
         * @param gpa  student's GPA (0.0..4.0)
         */
        Student(String name, int age, double gpa) {
            // Constructor should fail fast if object cannot be created validly.
            // We'll reuse setters so validation stays in one place.
            setName(name);
            setAge(age);
            setGPA(gpa);

            if (this.name == null) {
                throw new IllegalArgumentException("name must be non-blank");
            }
        }

        /** @return student's name */
        public String getName() {
            return name;
        }

        /**
         * Updates the name.
         *
         * <p>Teaching note: Here we "reject" invalid values. In production you might
         * prefer throwing an exception instead of printing.
         */
        public void setName(String name) {
            if (name != null && !name.isBlank()) {
                this.name = name;
            } else {
                System.out.println("ERROR: Name cannot be blank");
            }
        }

        /** @return student's age */
        public int getAge() {
            return age;
        }

        /** Updates age if within range. */
        public void setAge(int age) {
            if (age >= 5 && age <= 40) {
                this.age = age;
            } else {
                System.out.println("ERROR: Age must be between 5 and 40");
            }
        }

        /** @return student's GPA */
        public double getGPA() {
            return gpa;
        }

        /** Updates GPA if within [0.0, 4.0]. */
        public void setGPA(double gpa) {
            if (gpa >= 0.0 && gpa <= 4.0) {
                this.gpa = gpa;
            } else {
                System.out.println("ERROR: GPA must be between 0.0 and 4.0");
            }
        }

        /** @return true if the student qualifies for honor roll */
        public boolean isOnHonorRoll() {
            return gpa >= 3.5;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
        }
    }

    /**
     * Program entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Creating Student with Encapsulation ---\n");

        Student student = new Student("Tejas", 20, 3.8);
        System.out.println("Initial: " + student);

        System.out.println("\n--- Testing Getters ---");
        System.out.println("Name: " + student.getName());
        System.out.println("Age:  " + student.getAge());
        System.out.println("GPA:  " + student.getGPA());

        System.out.println("\n--- Testing Setters with Valid Values ---");
        student.setName("Raj");
        student.setAge(21);
        student.setGPA(3.9);
        System.out.println("After valid updates: " + student);

        System.out.println("\n--- Testing Setters with INVALID Values ---");
        student.setName("   ");      // invalid
        student.setAge(-5);          // invalid
        student.setGPA(5.0);         // invalid

        System.out.println("\nAfter invalid attempts (object still valid):");
        System.out.println(student);

        System.out.println("\n--- Testing Domain Method ---");
        System.out.println("On honor roll: " + student.isOnHonorRoll());

        System.out.println("\n--- Encapsulation Benefits ---");
        System.out.println("1) Data protection: invalid values rejected");
        System.out.println("2) Validation centralized in one place");
        System.out.println("3) Object remains in a valid state (invariants)");
        System.out.println("4) Implementation can change without breaking callers");
    }
}
