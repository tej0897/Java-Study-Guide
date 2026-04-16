/**
 * Day 7 - Memory Basics: Pass by Value
 *
 * Concept:
 * Java ALWAYS passes by value.
 * Meaning: A COPY of the data is passed to the method.
 * Changes inside the method don't affect the original.
 *
 * This example demonstrates:
 * - Pass by value with primitives (copy of value)
 * - Pass by value with references (copy of reference)
 * - Why objects can be modified even though passed by value
 *
 * Real-life analogy:
 * Passing by value = Making a photocopy
 * You give someone a photocopy of your document.
 * They can modify the photocopy, but original is unchanged.
 * If they create a new document, it doesn't change what you have.
 */
public class PassByValueExample {

    /**
     * Method to modify primitive (pass by value)
     * Changes don't affect original
     */
    public static void modifyPrimitive(int value) {
        value = 999;  // Modifies local copy only
        System.out.println("Inside method, value: " + value);
    }

    /**
     * Method to modify object (pass by value of reference)
     * Changes to object affect original (same object)
     * But reassignment doesn't affect original reference
     */
    public static void modifyObject(Student student) {

        // This modifies the ORIGINAL object
        student.name = "Modified";

        // This does NOT affect original reference
        student = new Student("NewStudent", 99);
    }

    /**
     * Main method - entry point of the program
     */
    public static void main(String[] args) {

        System.out.println("--- Pass by Value with Primitives ---");

        int age = 25;
        System.out.println("Before method call, age: " + age);

        // Passing primitive
        modifyPrimitive(age);

        // age is UNCHANGED
        System.out.println("After method call, age: " + age);

        System.out.println("\n--- Pass by Value with References ---");

        // Create a student object
        Student student = new Student("Tejas", 20);
        System.out.println("Before method call:");
        System.out.println("  Student: " + student.name + ", Age: " + student.age);

        // Passing object (reference is passed by value)
        modifyObject(student);

        System.out.println("After method call:");
        System.out.println("  Student: " + student.name + ", Age: " + student.age);
        // Name is CHANGED (object was modified)
        // But it's still the ORIGINAL Student object (not the new one created inside method)

        System.out.println("\n--- Understanding What Happened ---");

        System.out.println("""
                When we call modifyObject(student):
                
                1. student.name = "Modified"
                   → Modifies the ORIGINAL object (affects original)
                
                2. student = new Student("NewStudent", 99)
                   → Creates NEW object and assigns to LOCAL reference
                   → Original 'student' in main() still points to original object
                   → Does NOT affect original reference
                """);

        System.out.println("\n--- Another Example: swap() ---");

        int x = 10, y = 20;
        System.out.println("Before swap: x=" + x + ", y=" + y);

        swap(x, y);  // Doesn't work! Parameters are copies

        System.out.println("After swap: x=" + x + ", y=" + y);
        System.out.println("(Unchanged because primitives passed by value)");

        System.out.println("\n--- Array Example (Reference Type) ---");

        int[] arr = {1, 2, 3};
        System.out.println("Before modifyArray: [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "]");

        modifyArray(arr);

        System.out.println("After modifyArray: [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "]");
        System.out.println("(Changed because reference passed, but same array modified)");

    }

    /**
     * Attempt to swap two primitives (doesn't work)
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap: a=" + a + ", b=" + b);
        // Only local copies swapped
    }

    /**
     * Method to modify array (reference type)
     */
    public static void modifyArray(int[] array) {
        array[0] = 100;
        array[1] = 200;
        array[2] = 300;
    }

    /**
     * Student class
     */
    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}


