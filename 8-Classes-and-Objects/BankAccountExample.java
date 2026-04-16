/**
 * Day 8 - Classes and Objects: Bank Account with Composition
 *
 * Concept:
 * This example demonstrates composition (has-a relationship)
 * and how objects can contain other objects.
 *
 * This example demonstrates:
 * - Class composition (object contains other objects)
 * - Complex object relationships
 * - Encapsulation in action
 * - Real-world modeling
 *
 * Real-life analogy:
 * Bank Account contains:
 * - Account details (what)
 * - Transaction history (list of transactions)
 */
public class BankAccountExample {

    /**
     * Transaction class - represents a single transaction
     */
    static class Transaction {
        String type;        // "Deposit" or "Withdrawal"
        double amount;
        long timestamp;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.timestamp = System.currentTimeMillis();
        }

        void display() {
            System.out.println("  " + type + ": $" + amount);
        }
    }

    /**
     * BankAccount class - demonstrates composition
     */
    static class BankAccount {

        // Properties
        private String accountNumber;
        private String accountHolder;
        private double balance;
        private Transaction[] transactions;  // Composition: contains Transaction objects
        private int transactionCount;

        /**
         * Constructor
         */
        BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            this.transactions = new Transaction[100];  // Array of Transaction objects
            this.transactionCount = 0;

            // Record initial deposit
            if (initialBalance > 0) {
                addTransaction(new Transaction("Initial Deposit", initialBalance));
            }
        }

        /**
         * Deposit method
         */
        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                addTransaction(new Transaction("Deposit", amount));
                System.out.println("Deposit successful: $" + amount);
            } else {
                System.out.println("Invalid amount");
            }
        }

        /**
         * Withdraw method
         */
        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                addTransaction(new Transaction("Withdrawal", amount));
                System.out.println("Withdrawal successful: $" + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount");
            }
        }

        /**
         * Add transaction to history
         */
        private void addTransaction(Transaction transaction) {
            if (transactionCount < transactions.length) {
                transactions[transactionCount] = transaction;
                transactionCount++;
            }
        }

        /**
         * Display account info
         */
        void displayAccountInfo() {
            System.out.println("--- Account Information ---");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: $" + balance);
        }

        /**
         * Display transaction history
         */
        void displayTransactionHistory() {
            System.out.println("--- Transaction History ---");
            for (int i = 0; i < transactionCount; i++) {
                transactions[i].display();
            }
        }

        /**
         * Getter for balance
         */
        double getBalance() {
            return balance;
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("--- Creating Bank Account ---");

        // Creating bank account
        BankAccount account = new BankAccount("ACC123456", "Tejas Kumar", 5000);

        System.out.println("\n--- Performing Transactions ---");

        // Performing transactions
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(2000);
        account.withdraw(300);

        System.out.println("\n--- Account Status ---");

        // Displaying account info
        account.displayAccountInfo();

        System.out.println("\n--- Transaction History (Composition in Action) ---");

        // Displaying transaction history
        // This shows composition: Account contains multiple Transaction objects
        account.displayTransactionHistory();

        System.out.println("\nFinal Balance: $" + account.getBalance());

    }

}


