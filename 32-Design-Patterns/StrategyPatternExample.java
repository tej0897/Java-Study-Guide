/**
 * Day 32 - Design Patterns: Strategy
 *
 * <p>Strategy lets you select an algorithm at runtime by swapping implementations.
 */

import java.util.Arrays;

public class StrategyPatternExample {

    interface SortStrategy {
        void sort(int[] array);
        String name();
    }

    static class BubbleSortStrategy implements SortStrategy {
        @Override
        public void sort(int[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                }
            }
        }

        @Override
        public String name() {
            return "BubbleSort";
        }
    }

    static class JavaBuiltInSortStrategy implements SortStrategy {
        @Override
        public void sort(int[] array) {
            Arrays.sort(array);
        }

        @Override
        public String name() {
            return "Arrays.sort";
        }
    }

    static class Sorter {
        private SortStrategy strategy;

        Sorter(SortStrategy strategy) {
            this.strategy = strategy;
        }

        void setStrategy(SortStrategy strategy) {
            this.strategy = strategy;
        }

        void sortAndPrint(int[] input) {
            int[] copy = Arrays.copyOf(input, input.length);
            System.out.println("Using strategy: " + strategy.name());
            System.out.println("Before: " + Arrays.toString(copy));
            strategy.sort(copy);
            System.out.println("After:  " + Arrays.toString(copy));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern ===\n");

        int[] data = {5, 2, 9, 1, 5, 6};

        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sortAndPrint(data);

        System.out.println();
        sorter.setStrategy(new JavaBuiltInSortStrategy());
        sorter.sortAndPrint(data);

        System.out.println("\nKey Points:");
        System.out.println("1. Strategy = interchangeable algorithm implementations");
        System.out.println("2. Context (Sorter) delegates to the chosen strategy");
        System.out.println("3. Swap strategies at runtime without changing Sorter code");
    }
}

