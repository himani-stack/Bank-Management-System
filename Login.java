import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JTextField cardField;
    private JPasswordField pinField;
    private JButton loginBtn, clearBtn, signupBtn;

    private Bank bank;

    public Login() {
        bank = new Bank();
        bank.loadFromFile();

        setTitle("ATM Login");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAIN PANEL 
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(52, 122, 150)); 
        add(mainPanel);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(550, 300));
        panel.setBackground(new Color(52, 122, 150)); 

        mainPanel.add(panel); 
        // HEADING
        JLabel heading = new JLabel("WELCOME TO ATM");
        heading.setBounds(150, 40, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // CARD NO
        JLabel cardLabel = new JLabel("Account No:");
        cardLabel.setBounds(120, 100, 100, 25);
        cardLabel.setForeground(Color.WHITE);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(cardLabel);

        cardField = new JTextField();
        cardField.setBounds(220, 100, 200, 25);
        panel.add(cardField);

        // PIN
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(120, 140, 100, 25);
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(220, 140, 200, 25);
        panel.add(pinField);

        // BUTTONS
        loginBtn = new JButton("SIGN IN");
        loginBtn.setBounds(150, 190, 100, 30);

        clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(270, 190, 100, 30);

        signupBtn = new JButton("SIGN UP");
        signupBtn.setBounds(200, 240, 150, 30);

        // style buttons
        styleButton(loginBtn);
        styleButton(clearBtn);
        styleButton(signupBtn);

        panel.add(loginBtn);
        panel.add(clearBtn);
        panel.add(signupBtn);

        // ACTIONS
        loginBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        signupBtn.addActionListener(this);

        setVisible(true);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginBtn) {

                int accNo = Integer.parseInt(cardField.getText().trim());
                int pin = Integer.parseInt(new String(pinField.getPassword()));

                Account acc = bank.findAccount(accNo);

                if (acc != null && acc.getPin() == pin) {
                    new Menu(accNo);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials!");
                }

            } else if (e.getSource() == clearBtn) {
                cardField.setText("");
                pinField.setText("");

            } else if (e.getSource() == signupBtn) {
                new Signup();
                dispose();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid details!");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}