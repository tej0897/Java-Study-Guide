/**
 * Day 15 - Static Keyword: Static Fields and Static Methods
 *
 * <p><b>Concept</b>
 * {@code static} members belong to the class (shared once), not to objects.
 *
 * <p><b>What this file demonstrates</b>
 * <ul>
 *   <li>A static field used as a shared counter</li>
 *   <li>A static field used as shared configuration</li>
 *   <li>A static utility method</li>
 *   <li>Why calling static via instance is allowed but discouraged</li>
 * </ul>
 */
public class StaticKeywordExample {

    static class Student {
        /** Shared across all Student objects. */
        static int totalStudents = 0;

        /** Shared configuration (example only). */
        static String universityName = "MIT";

        private final String name;
        private final int age;
        private final double gpa;

        Student(String name, int age, double gpa) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name must be non-blank");
            }
            if (age <= 0) {
                throw new IllegalArgumentException("age must be positive");
            }
            if (gpa < 0.0 || gpa > 4.0) {
                throw new IllegalArgumentException("gpa must be in [0.0, 4.0]");
            }
            this.name = name;
            this.age = age;
            this.gpa = gpa;

            totalStudents++; // shared counter
        }

        void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
            System.out.println("University: " + universityName);
        }

        static void displayStatistics() {
            System.out.println("Total students: " + totalStudents);
            System.out.println("University: " + universityName);
        }

        static double averageGPA(double... gpas) {
            if (gpas == null || gpas.length == 0) {
                throw new IllegalArgumentException("at least one GPA is required");
            }
            double sum = 0;
            for (double gpa : gpas) {
                sum += gpa;
            }
            return sum / gpas.length;
        }
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Static Keyword Example ===\n");

        Student s1 = new Student("John", 20, 3.8);
        Student s2 = new Student("Jane", 19, 3.9);
        Student s3 = new Student("Bob", 21, 3.7);

        System.out.println("--- Instance info (per object) ---");
        s1.displayInfo();
        System.out.println();
        s2.displayInfo();

        System.out.println("\n--- Static fields (shared) ---");
        System.out.println("Student.totalStudents: " + Student.totalStudents);
        System.out.println("Student.universityName: " + Student.universityName);

        System.out.println("\n--- Calling static methods (recommended via class) ---");
        Student.displayStatistics();

        System.out.println("\n--- Calling static methods via instance (discouraged) ---");
        // This compiles, but it looks like it depends on object state (it does not).
        s3.displayStatistics();

        System.out.println("\n--- Static utility method ---");
        System.out.println("Average GPA: " + Student.averageGPA(3.8, 3.9, 3.7));
    }
}
