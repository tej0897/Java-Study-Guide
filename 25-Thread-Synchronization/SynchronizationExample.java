/**
 * Day 25 - Thread Synchronization: Synchronized Methods
 */
public class SynchronizationExample {

    static class Account {
        private double balance = 1000;

        synchronized void deposit(double amount) {
            double temp = balance;
            temp += amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = temp;
            System.out.println("Deposited: " + amount + ", Balance: " + balance);
        }

        synchronized void withdraw(double amount) {
            double temp = balance;
            if (temp >= amount) {
                temp -= amount;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance = temp;
                System.out.println("Withdrew: " + amount + ", Balance: " + balance);
            }
        }

        synchronized double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Synchronization ===\n");

        Account account = new Account();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(100);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(50);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nFinal Balance: " + account.getBalance());
    }
}


