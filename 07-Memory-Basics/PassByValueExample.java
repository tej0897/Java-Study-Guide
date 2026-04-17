/**
 * Day 7 - Memory Basics: Pass-by-Value
 *
 * <p><b>Key concept</b>
 * Java is <b>always</b> pass-by-value.
 * When you call a method, Java copies the argument value into the method parameter.
 *
 * <p>What differs is <i>what the value represents</i>:
 * <ul>
 *   <li>Primitive argument -> the value is the primitive itself (e.g., 25)</li>
 *   <li>Reference argument -> the value is a reference pointing to an object</li>
 * </ul>
 *
 * <p><b>Real-life analogy</b>
 * Passing by value = giving a photocopy of a label.
 * If it's a label pointing to a package, both labels can point to the same package.
 */
public class PassByValueExample {

    /**
     * Demonstrates pass-by-value with primitives.
     *
     * @param value a copy of the caller's primitive value
     */
    public static void modifyPrimitive(int value) {
        value = 999; // modifies only the local copy
        System.out.println("Inside modifyPrimitive, value: " + value);
    }

    /**
     * Demonstrates pass-by-value with references.
     *
     * <p>The reference value is copied. Therefore:
     * <ul>
     *   <li>Mutating the object affects the original object</li>
     *   <li>Reassigning the parameter does NOT affect the caller's reference</li>
     * </ul>
     *
     * @param student a copy of the reference pointing to a Student
     */
    public static void modifyObject(Student student) {
        if (student == null) {
            System.out.println("student is null; nothing to modify");
            return;
        }

        // Mutates the ORIGINAL heap object (caller observes this)
        student.name = "Modified";

        // Reassigns only the LOCAL parameter (caller does NOT observe this)
        student = new Student("NewStudent", 99);
        // At this point, 'student' inside this method points to a new object,
        // but the caller's variable still points to the original object.
    }

    /**
     * Attempts to swap two primitives (will not work for the caller).
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap: a=" + a + ", b=" + b);
    }

    /**
     * Mutates an array (arrays are objects; reference is copied).
     */
    public static void modifyArray(int[] array) {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("array must have at least 3 elements");
        }
        array[0] = 100;
        array[1] = 200;
        array[2] = 300;
    }

    /**
     * Entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Pass-by-Value with Primitives ---");

        int age = 25;
        System.out.println("Before method call, age: " + age);
        modifyPrimitive(age);
        System.out.println("After method call, age: " + age);

        System.out.println("\n--- Pass-by-Value with References ---");

        Student student = new Student("Tejas", 20);
        System.out.println("Before method call: " + student);
        modifyObject(student);
        System.out.println("After method call:  " + student);

        System.out.println("\n--- Explanation ---");
        System.out.println("""
                1) The student variable holds a reference value (like a handle)
                2) Java copies that reference value into modifyObject(student)
                3) Both references point to the same object, so mutation is visible
                4) Reassignment inside the method changes only the local parameter
                """);

        System.out.println("\n--- swap() Example ---");
        int x = 10, y = 20;
        System.out.println("Before swap: x=" + x + ", y=" + y);
        swap(x, y);
        System.out.println("After swap:  x=" + x + ", y=" + y);

        System.out.println("\n--- Array Example (reference copied, same array mutated) ---");
        int[] arr = {1, 2, 3};
        System.out.println("Before modifyArray: [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "]");
        modifyArray(arr);
        System.out.println("After modifyArray:  [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "]");
    }

    /** Simple data class used for demonstrations. */
    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }
}
