/**
 * Day 29 - Memory Model and Garbage Collection
 */
public class GarbageCollectionExample {

    static class LargeObject {
        byte[] data = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        System.out.println("=== Garbage Collection ===\n");

        System.out.println("Before GC:");
        System.out.println("Memory: " + Runtime.getRuntime().totalMemory());

        // Create objects
        LargeObject[] objects = new LargeObject[10];
        for (int i = 0; i < 10; i++) {
            objects[i] = new LargeObject();
        }

        System.out.println("After creating objects:");
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());

        // Clear references
        for (int i = 0; i < 10; i++) {
            objects[i] = null;
        }

        System.out.println("After clearing references (before GC):");
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());

        // Suggest GC
        System.gc();

        System.out.println("After GC:");
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
    }
}


