/**
 * Day 25 - Thread Synchronization: Volatile Visibility
 *
 * <p>{@code volatile} is about <b>visibility</b> (one thread's writes become visible
 * to another thread), not atomicity.
 *
 * <p>This demo starts a worker thread that spins until it sees {@code stopRequested}
 * become {@code true}. With volatile, the worker is guaranteed to observe the update.
 */
public class VolatileVisibilityExample {

    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Volatile Visibility Example ===\n");

        Thread worker = new Thread(() -> {
            long iterations = 0;
            while (!stopRequested) {
                iterations++;
                // Light work to prevent aggressive optimizations from turning this into a no-op.
                if ((iterations & ((1 << 20) - 1)) == 0) {
                    Thread.yield();
                }
            }
            System.out.println("Worker stopped after iterations: " + iterations);
        }, "worker");

        worker.start();

        Thread.sleep(200); // give worker time to run

        System.out.println("Requesting stop...");
        stopRequested = true;

        worker.join(2_000);
        System.out.println("Worker state after join: " + worker.getState());

        System.out.println("\nKey Points:");
        System.out.println("1. volatile guarantees visibility of writes across threads");
        System.out.println("2. volatile does NOT make compound actions atomic (e.g., count++)");
        System.out.println("3. Use synchronized/locks/atomic classes for atomicity");
    }
}

