/**
 * Day 26 - Executor Framework: Thread Pools
 */
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Pool Types ===\n");

        System.out.println("--- FixedThreadPool (2 threads) ---");
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            final int num = i;
            fixed.execute(() -> System.out.println("Task " + num));
        }
        fixed.shutdown();
        fixed.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\n--- CachedThreadPool ---");
        ExecutorService cached = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int num = i;
            cached.execute(() -> System.out.println("Cached Task " + num));
        }
        cached.shutdown();
        cached.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\nExecutor management complete");
    }
}


