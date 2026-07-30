import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

    private int accNo;
    private JButton deposit, withdraw, balance, logout, miniStatement;
    private Bank bank;

    public Menu(int accNo) {
        this.accNo = accNo;
        bank = new Bank();
        bank.loadFromFile();

        setTitle("ATM - Transactions");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(30, 30, 30));
        add(mainPanel);

        // CENTER BOX
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBackground(new Color(45, 45, 45));
        box.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        box.setPreferredSize(new Dimension(400, 320));

        // HEADING
        JLabel heading = new JLabel("Please Select Your Transaction");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(Box.createVerticalStrut(20));
        box.add(heading);
        box.add(Box.createVerticalStrut(20));

        // BUTTONS
        deposit = createATMButton("DEPOSIT");
        withdraw = createATMButton("WITHDRAW");
        miniStatement = createATMButton("MINI STATEMENT");
        balance = createATMButton("BALANCE");
        logout = createATMButton("EXIT");

        box.add(deposit);
        box.add(Box.createVerticalStrut(12));
        box.add(withdraw);
        box.add(Box.createVerticalStrut(12));
        box.add(miniStatement);
        box.add(Box.createVerticalStrut(12));
        box.add(balance);
        box.add(Box.createVerticalStrut(12));
        box.add(logout);

        mainPanel.add(box);

        // ACTIONS
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        miniStatement.addActionListener(this);
        balance.addActionListener(this);
        logout.addActionListener(this);

        setVisible(true);
    }

   
    private JButton createATMButton(String text) {
        JButton btn = new JButton(text);
        btn.setMaximumSize(new Dimension(200, 40));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));

        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == deposit) {
            new Deposit(accNo,bank);

        } else if (e.getSource() == withdraw) {
            new Withdraw(accNo,bank);

        } else if (e.getSource() == miniStatement) {
            new MiniStatement(accNo,bank);

        } else if (e.getSource() == balance) {
            new Balance(accNo,bank);

        } else if (e.getSource() == logout) {
            new Login();
            dispose();
        }
    }
}