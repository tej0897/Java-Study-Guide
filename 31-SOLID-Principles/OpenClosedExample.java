/**
 * Day 31 - SOLID Principles: Open/Closed Principle (OCP)
 *
 * <p>Software entities should be open for extension but closed for modification.
 * We extend behavior by adding new implementations, without changing the caller.
 */
public class OpenClosedExample {

    interface DiscountPolicy {
        double apply(double originalPrice);
        String name();
    }

    static class NoDiscount implements DiscountPolicy {
        public double apply(double originalPrice) { return originalPrice; }
        public String name() { return "NoDiscount"; }
    }

    static class SeasonalDiscount implements DiscountPolicy {
        private final double percentOff;

        SeasonalDiscount(double percentOff) {
            if (percentOff < 0 || percentOff > 100) {
                throw new IllegalArgumentException("percentOff must be in [0, 100]");
            }
            this.percentOff = percentOff;
        }

        public double apply(double originalPrice) {
            return originalPrice * (1.0 - percentOff / 100.0);
        }

        public String name() { return "SeasonalDiscount(" + percentOff + "%)"; }
    }

    static class PriceCalculator {
        double finalPrice(double price, DiscountPolicy policy) {
            return policy.apply(price);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Open/Closed Principle (OCP) ===\n");

        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        DiscountPolicy none = new NoDiscount();
        DiscountPolicy seasonal = new SeasonalDiscount(15);

        System.out.println(none.name() + " => " + calculator.finalPrice(price, none));
        System.out.println(seasonal.name() + " => " + calculator.finalPrice(price, seasonal));

        System.out.println("\nKey Points:");
        System.out.println("1. Add new policies by adding classes (extension)");
        System.out.println("2. PriceCalculator stays unchanged (closed for modification)");
    }
}

