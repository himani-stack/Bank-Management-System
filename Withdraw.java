import javax.swing.*;
import java.awt.*;

public class Withdraw extends JFrame {

    public Withdraw(int accNo, Bank bank) {

        setTitle("Withdraw");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));
        add(panel);

        // Heading
        JLabel heading = new JLabel("Enter Amount to Withdraw");
        heading.setBounds(140, 80, 350, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // Amount Field
        JTextField amountField = new JTextField();
        amountField.setBounds(200, 130, 200, 35);
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(amountField);

        // Withdraw Button
        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(170, 200, 120, 35);
        withdrawBtn.setBackground(new Color(244, 67, 54));
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(withdrawBtn);

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(310, 200, 120, 35);
        backBtn.setBackground(new Color(0, 150, 136));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(backBtn);

        // Withdraw Action
        withdrawBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Account acc = bank.findAccount(accNo);

                if (acc != null && amount <= acc.getBalance()) {
                    bank.withdraw(accNo, amount);
                    JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
                    dispose();
                    new Menu(accNo);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Amount!");
            }
        });

        // Back Action
        backBtn.addActionListener(e -> {
            dispose();
            new Menu(accNo);
        });

        setVisible(true);
    }
}