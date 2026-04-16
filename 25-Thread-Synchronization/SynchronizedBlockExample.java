/**
 * Day 25 - Thread Synchronization: Synchronized Blocks
 */
public class SynchronizedBlockExample {

    static class SharedResource {
        private int counter = 0;

        void incrementWithBlock() {
            synchronized(this) {
                int temp = counter;
                temp++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter = temp;
            }
        }

        int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Synchronized Blocks ===\n");

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.incrementWithBlock();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.incrementWithBlock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter: " + resource.getCounter());
        System.out.println("(Expected: 10)");
    }
}


