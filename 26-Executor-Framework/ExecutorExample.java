/**
 * Day 26 - Executor Framework
 */
import java.util.concurrent.*;

public class ExecutorFrameworkExample {
    public static void main(String[] args) {
        System.out.println("=== Executor Framework ===\n");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            final int taskNum = i;
            executor.execute(() -> {
                System.out.println("Task " + taskNum + " running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNum + " completed");
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }
}


