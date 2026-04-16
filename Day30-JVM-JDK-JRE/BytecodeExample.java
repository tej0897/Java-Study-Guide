/**
 * Day 30 - Bytecode Example
 */
public class BytecodeExample {
    public static void main(String[] args) {
        System.out.println("=== Bytecode Example ===\n");

        int x = 10;
        int y = 20;
        int sum = x + y;

        System.out.println("Compiled to bytecode");
        System.out.println("Sum: " + sum);

        System.out.println("\nTo view bytecode:");
        System.out.println("javap -c BytecodeExample.class");
    }
}


