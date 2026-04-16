/**
 * Day 30 - JVM Details
 */
public class JVMDetailsExample {
    public static void main(String[] args) {
        System.out.println("=== JVM Information ===\n");

        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("JVM Name: " + System.getProperty("java.vm.name"));
        System.out.println("JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
    }
}


