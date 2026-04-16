/**
 * Day 24 - Multithreading: Thread Methods and Lifecycle
 */
public class ThreadLifecycleExample {

    static class Counter extends Thread {
        private String name;

        Counter(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + ": " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Lifecycle ===\n");

        Counter thread1 = new Counter("Thread-1");
        Counter thread2 = new Counter("Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All threads completed");
    }
}


