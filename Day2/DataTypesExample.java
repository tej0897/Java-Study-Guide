/**
 * Day 2 - Data Types in Java
 *
 * Concept:
 * Data types define what kind of data a variable can store.
 *
 * Types:
 * 1. Primitive Data Types (store actual values)
 * 2. Non-Primitive Data Types (store references)
 *
 * This example demonstrates:
 * - All primitive data types
 * - A non-primitive type (String)
 */
public class DataTypesExample {

    /**
     * Main method demonstrating data types
     */
    public static void main(String[] args) {

        // Primitive Data Types

        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 10000L;

        float f = 10.5f;
        double d = 20.99;

        char c = 'A';
        boolean flag = true;

        // Non-Primitive Data Type
        String name = "Tejas";

        // Printing values
        System.out.println("byte value: " + b);
        System.out.println("short value: " + s);
        System.out.println("int value: " + i);
        System.out.println("long value: " + l);

        System.out.println("float value: " + f);
        System.out.println("double value: " + d);

        System.out.println("char value: " + c);
        System.out.println("boolean value: " + flag);

        System.out.println("String value: " + name);
    }
}
