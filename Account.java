import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private int accountNumber;
    private String name;
    private double balance;
    private int pin;

    // Store transactions
    private StringBuilder transactions = new StringBuilder();

    // Date 
    private static final SimpleDateFormat sdf =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");

    public Account(int accountNumber, String name, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.pin = pin;

        // Record initial balance if provided
        if (balance > 0) {
            addTransaction("Initial Deposit", balance);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    // Method to log transactions
    private void addTransaction(String type, double amount) {
        String date = sdf.format(new Date());
        transactions.append(String.format(
                "%-35s %-12s Rs %.2f%n",
                date, type, amount
        ));
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", amount);
        } else {
            addTransaction("Failed Withdrawal", amount);
        }
    }

    // Return transaction history
    public String getMiniStatement() {
        if (transactions.length() == 0) {
            return "No transactions yet.\n";
        }
        return transactions.toString();
    }
}