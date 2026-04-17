/**
 * Day 8 - Classes and Objects: Composition ("has-a") with a Bank Account
 *
 * <p><b>Concept</b>
 * Composition means one object contains/uses other objects to do its work.
 * Here, a {@code BankAccount} contains multiple {@code Transaction} objects.
 *
 * <p><b>Real-life analogy</b>
 * A bank account "has" a transaction history.
 * The account is not a type of transaction (that's not inheritance) — it simply owns them.
 */
public class BankAccountExample {

    /**
     * Represents a single immutable transaction record.
     * In real systems you'd store more details (id, status, currency, etc.).
     */
    static final class Transaction {
        private final String type;        // e.g., Deposit, Withdrawal
        private final double amount;
        private final long timestampMillis;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.timestampMillis = System.currentTimeMillis();
        }

        void display() {
            System.out.printf("  %-12s $%.2f (t=%d)%n", type, amount, timestampMillis);
        }
    }

    /**
     * A minimal bank account model showing encapsulation + composition.
     *
     * <p>Key invariants:
     * <ul>
     *   <li>balance is never negative</li>
     *   <li>accountNumber and accountHolder are non-blank</li>
     * </ul>
     */
    static final class BankAccount {

        private final String accountNumber;
        private final String accountHolder;
        private double balance;

        // Composition: an account owns many transactions.
        private final Transaction[] transactions;
        private int transactionCount;

        BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            if (accountNumber == null || accountNumber.isBlank()) {
                throw new IllegalArgumentException("accountNumber must be non-blank");
            }
            if (accountHolder == null || accountHolder.isBlank()) {
                throw new IllegalArgumentException("accountHolder must be non-blank");
            }
            if (initialBalance < 0) {
                throw new IllegalArgumentException("initialBalance must be >= 0");
            }

            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            this.transactions = new Transaction[100];
            this.transactionCount = 0;

            if (initialBalance > 0) {
                addTransaction(new Transaction("Initial", initialBalance));
            }
        }

        void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit rejected: amount must be > 0");
                return;
            }
            balance += amount;
            addTransaction(new Transaction("Deposit", amount));
            System.out.printf("Deposit successful: $%.2f%n", amount);
        }

        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal rejected: amount must be > 0");
                return;
            }
            if (amount > balance) {
                System.out.println("Withdrawal rejected: insufficient balance");
                return;
            }
            balance -= amount;
            addTransaction(new Transaction("Withdraw", amount));
            System.out.printf("Withdrawal successful: $%.2f%n", amount);
        }

        private void addTransaction(Transaction transaction) {
            if (transactionCount >= transactions.length) {
                System.out.println("Transaction history full; cannot record more.");
                return;
            }
            transactions[transactionCount++] = transaction;
        }

        void displayAccountInfo() {
            System.out.println("--- Account Information ---");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.printf("Balance: $%.2f%n", balance);
        }

        void displayTransactionHistory() {
            System.out.println("--- Transaction History ---");
            if (transactionCount == 0) {
                System.out.println("  (no transactions)");
                return;
            }
            for (int i = 0; i < transactionCount; i++) {
                transactions[i].display();
            }
        }

        double getBalance() {
            return balance;
        }
    }

    /**
     * Program entry point.
     *
     * @param args CLI args (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Creating Bank Account ---");

        BankAccount account = new BankAccount("ACC123456", "Tejas Kumar", 5000);

        System.out.println("\n--- Performing Transactions ---");
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(2000);
        account.withdraw(300);
        account.withdraw(100_000); // rejected example

        System.out.println("\n--- Account Status ---");
        account.displayAccountInfo();

        System.out.println("\n--- Transaction History (Composition in Action) ---");
        account.displayTransactionHistory();

        System.out.printf("%nFinal Balance: $%.2f%n", account.getBalance());
    }
}
