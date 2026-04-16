/**
 * Day 14 - Access Modifiers and Packages: Package Organization
 *
 * Concept:
 * Shows how to organize code into packages for better structure.
 * This example demonstrates package concepts through nested classes.
 *
 * In real projects, these would be in separate files/packages.
 *
 * Real-life analogy:
 * Library (project) → Sections (packages) → Books (classes)
 */
public class PackageOrganizationExample {

    // Simulating: package com.bank.models
    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
        }
    }

    // Simulating: package com.bank.accounts
    static class Account {
        private String accountNumber;
        private double balance;
        private User owner;

        public Account(String accountNumber, User owner) {
            this.accountNumber = accountNumber;
            this.owner = owner;
            this.balance = 0;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public double getBalance() { return balance; }

        @Override
        public String toString() {
            return "Account{" + "owner=" + owner + ", balance=" + balance + '}';
        }
    }

    // Simulating: package com.bank.services
    static class BankService {
        private Account account;

        public BankService(Account account) {
            this.account = account;
        }

        public void processTransaction(double amount, String type) {
            if ("deposit".equalsIgnoreCase(type)) {
                account.deposit(amount);
            } else if ("withdraw".equalsIgnoreCase(type)) {
                account.withdraw(amount);
            }
            System.out.println("Current Balance: $" + account.getBalance());
        }
    }

    /**
     * Main method - entry point
     */
    public static void main(String[] args) {

        System.out.println("=== Package Organization Example ===\n");

        System.out.println("--- Creating User (from models package) ---");
        User user = new User("John Doe", "john@example.com");
        System.out.println(user);

        System.out.println("\n--- Creating Account (from accounts package) ---");
        Account account = new Account("ACC123456", user);
        System.out.println(account);

        System.out.println("\n--- Using BankService (from services package) ---");
        BankService service = new BankService(account);

        service.processTransaction(1000, "deposit");
        service.processTransaction(300, "withdraw");
        service.processTransaction(5000, "withdraw");

        System.out.println("\n=== Typical Package Structure ===");
        System.out.println("""
                com.bank (root)
                ├── models
                │   ├── User.java
                │   └── Account.java
                ├── services
                │   └── BankService.java
                └── controllers
                    └── BankController.java
                """);

        System.out.println("=== Benefits ===");
        System.out.println("- Organized code structure");
        System.out.println("- Clear separation of concerns");
        System.out.println("- Easy to locate classes");
        System.out.println("- Prevents naming conflicts");

    }

}


