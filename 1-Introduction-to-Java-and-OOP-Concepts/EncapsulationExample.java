/**
 * Day 1 - Encapsulation
 *
 * Concept:
 * Encapsulation means hiding internal data and exposing it only through controlled methods.
 *
 * This example demonstrates:
 * - Private variable (data hiding)
 * - Public getter and setter methods
 *
 * Real-life analogy:
 * ATM machine - you cannot access balance directly,
 * you use methods like checkBalance() or deposit()
 */
class BankAccount {

    /**
     * Private variable to store balance
     * Cannot be accessed directly outside the class
     */
    private double balance;

    /**
     * Getter method to access balance
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method to deposit money into account
     * @param amount amount to be deposited
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

public class EncapsulationExample {

    /**
     * Main method demonstrating encapsulation
     */
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(1000);

        // Accessing balance using getter
        System.out.println("Balance: " + account.getBalance());
    }
}
