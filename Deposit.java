import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame {

    public Deposit(int accNo, Bank bank) {

        setTitle("Deposit");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));
        add(panel);

        // Heading
        JLabel heading = new JLabel("Enter Amount to Deposit");
        heading.setBounds(150, 80, 350, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // Amount Field
        JTextField amountField = new JTextField();
        amountField.setBounds(200, 130, 200, 35);
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(amountField);

        // Deposit Button
        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(180, 200, 100, 35);
        depositBtn.setBackground(new Color(76, 175, 80));
        depositBtn.setForeground(Color.WHITE);
        depositBtn.setFocusPainted(false);
        panel.add(depositBtn);

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(320, 200, 100, 35);
        backBtn.setBackground(new Color(0, 150, 136));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        panel.add(backBtn);

        // Deposit Action
        depositBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                bank.deposit(accNo, amount);
                JOptionPane.showMessageDialog(this, "Deposit Successful!");
                dispose();
                new Menu(accNo);
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