/**
 * Day 24 - Multithreading: Creating Threads
 */
public class ThreadCreationExample {

    // Method 1: Extend Thread
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread running: " + i);
            }
        }
    }

    // Method 2: Implement Runnable
    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Runnable running: " + i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Multithreading ===\n");

        System.out.println("--- Method 1: Extend Thread ---");
        MyThread thread1 = new MyThread();
        thread1.start();

        System.out.println("\n--- Method 2: Implement Runnable ---");
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        System.out.println("\nMain thread continues");
    }
}


