/**
 * Day 29 - Memory Management Best Practices
 */
public class MemoryManagementExample {
    public static void main(String[] args) {
        System.out.println("=== Memory Management ===\n");

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Memory Information:");
        System.out.println("Total Memory: " + (runtime.totalMemory() / 1024 / 1024) + " MB");
        System.out.println("Free Memory: " + (runtime.freeMemory() / 1024 / 1024) + " MB");
        System.out.println("Max Memory: " + (runtime.maxMemory() / 1024 / 1024) + " MB");

        System.out.println("\nAvailable Processors: " + runtime.availableProcessors());
    }
}


