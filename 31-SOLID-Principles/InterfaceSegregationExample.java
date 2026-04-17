/**
 * Day 31 - SOLID Principles: Interface Segregation Principle (ISP)
 *
 * <p>Clients should not be forced to depend on methods they do not use.
 */
public class InterfaceSegregationExample {

    interface Printable {
        void print(String document);
    }

    interface Scannable {
        void scan(String document);
    }

    interface Faxable {
        void fax(String document);
    }

    static class BasicPrinter implements Printable {
        @Override
        public void print(String document) {
            System.out.println("Printing: " + document);
        }
    }

    static class OfficeMultiFunctionMachine implements Printable, Scannable, Faxable {
        public void print(String document) { System.out.println("MFP printing: " + document); }
        public void scan(String document) { System.out.println("MFP scanning: " + document); }
        public void fax(String document) { System.out.println("MFP faxing: " + document); }
    }

    public static void main(String[] args) {
        System.out.println("=== Interface Segregation Principle (ISP) ===\n");

        Printable printer = new BasicPrinter();
        printer.print("report.pdf");

        OfficeMultiFunctionMachine mfp = new OfficeMultiFunctionMachine();
        mfp.print("invoice.pdf");
        mfp.scan("contract.pdf");
        mfp.fax("purchase-order.pdf");

        System.out.println("\nKey Points:");
        System.out.println("1. Split large interfaces into small, focused ones");
        System.out.println("2. BasicPrinter only implements what it supports");
        System.out.println("3. MultiFunction can implement multiple small interfaces");
    }
}

