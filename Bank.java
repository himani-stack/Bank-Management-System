import java.io.*;
import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void createAccount(Account acc) {
        accounts.add(acc);
        saveToFile();
    }

    public Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo)
                return acc;
        }
        return null;
    }

    public boolean verifyPin(int accNo, int pin) {
        Account acc = findAccount(accNo);
        return acc != null && acc.getPin() == pin;
    }

    public void deposit(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
            saveToFile();
        }
    }

    public void withdraw(int accNo, double amount) {
    Account acc = findAccount(accNo);
    if (acc != null) {
        acc.withdraw(amount);
        saveToFile();
    }
}

    public String checkBalance(int accNo, int pin) {
        Account acc = findAccount(accNo);
        if (acc == null) return "Account not found!";
        if (acc.getPin() != pin) return "Invalid PIN!";

        return "Balance: " + acc.getBalance();
    }

    public String getAllAccounts() {
        if (accounts.isEmpty()) return "No accounts available.";

        StringBuilder sb = new StringBuilder();
        for (Account acc : accounts) {
            sb.append("Account No: ").append(acc.getAccountNumber()).append("\n");
            sb.append("Name: ").append(acc.getName()).append("\n");
            sb.append("Balance: ").append(acc.getBalance()).append("\n");
            sb.append("---------------------\n");
        }
        return sb.toString();
    }

    public void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bank.dat"));
            out.writeObject(accounts);
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("bank.dat"));
            accounts = (List<Account>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}