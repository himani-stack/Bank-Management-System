import javax.swing.*;
import java.awt.*;

public class Balance extends JFrame {

    public Balance(int accNo, Bank bank) {

        setTitle("Balance Inquiry");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Account acc = bank.findAccount(accNo);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));
        add(panel);

        // Balance Label
        JLabel balanceLabel = new JLabel(
                "Your Current Balance is Rs " +
                        (acc != null ? acc.getBalance() : "0"));
        balanceLabel.setBounds(120, 140, 400, 30);
        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        balanceLabel.setForeground(Color.WHITE);
        panel.add(balanceLabel);

        // Back Button
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(230, 220, 120, 35);
        backBtn.setBackground(new Color(0, 150, 136));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(backBtn);

        backBtn.addActionListener(e -> {
            dispose();
            new Menu(accNo);
        });

        setVisible(true);
    }
}