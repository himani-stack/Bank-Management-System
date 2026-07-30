import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JTextField accField, nameField, amountField, pinField;
    JButton create;
    Bank bank;

    public Signup() {
        bank = new Bank();
        bank.loadFromFile();

        setLayout(null);

        JLabel heading = new JLabel("CREATE ACCOUNT");
        heading.setBounds(120, 30, 200, 30);
        heading.setFont(new Font("System", Font.BOLD, 18));
        add(heading);

        JLabel acc = new JLabel("Account No:");
        acc.setBounds(50, 80, 100, 25);
        add(acc);

        accField = new JTextField();
        accField.setBounds(180, 80, 150, 25);
        add(accField);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 120, 100, 25);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(180, 120, 150, 25);
        add(nameField);

        JLabel amt = new JLabel("Amount:");
        amt.setBounds(50, 160, 100, 25);
        add(amt);

        amountField = new JTextField();
        amountField.setBounds(180, 160, 150, 25);
        add(amountField);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(50, 200, 100, 25);
        add(pin);

        pinField = new JTextField();
        pinField.setBounds(180, 200, 150, 25);
        add(pinField);

        create = new JButton("Create");
        create.setBounds(130, 250, 120, 30);
        add(create);

        create.addActionListener(this);

        setSize(400, 350);
        setLocation(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int accNo = Integer.parseInt(accField.getText());
            String name = nameField.getText();
            double amount = Double.parseDouble(amountField.getText());
            int pin = Integer.parseInt(pinField.getText());

            bank.createAccount(new Account(accNo, name, amount, pin));

            JOptionPane.showMessageDialog(this, "Account Created!");
            new Login();
            setVisible(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}