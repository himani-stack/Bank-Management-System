import javax.swing.*;
import java.awt.*;

public class MiniStatement extends JFrame {

    public MiniStatement(int accNo, Bank bank) {

        setTitle("Mini Statement");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Account acc = bank.findAccount(accNo);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 184, 183)); 
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(panel);

        JTextArea statementArea = new JTextArea();
        statementArea.setEditable(false);
        statementArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        statementArea.setBackground(new Color(230, 184, 183));

        if (acc != null) {
            StringBuilder sb = new StringBuilder();

            sb.append("Card Number: ")
            .append(acc.getAccountNumber())
            .append("\n\n");

            sb.append("Date & Time                     Type         Amount\n");
            sb.append("-----------------------------------------------------------\n");
            sb.append(acc.getMiniStatement());

            sb.append("\nYour Total Balance is Rs ")
            .append(String.format("%.2f", acc.getBalance()));


            statementArea.setText(sb.toString());
        } else {
            statementArea.setText("Account not found.");
        }

        JScrollPane scrollPane = new JScrollPane(statementArea);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 12));
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setFocusPainted(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 184, 183));
        buttonPanel.add(exitBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        exitBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
}