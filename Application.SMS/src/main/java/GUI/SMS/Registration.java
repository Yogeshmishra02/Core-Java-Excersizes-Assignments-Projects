package GUI.SMS;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class Registration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField; // Phone number field
    private JTextField addressField; // Address field
    private JTextField dobField; // Date of birth field
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton backButton;
    private JCheckBox showPasswordCheckBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Registration frame = new Registration();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1088, 660);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250)); // Light blue-green background
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Registration label
        JLabel registrationLabel = new JLabel("REGISTRATION");
        registrationLabel.setFont(new Font("Arial", Font.BOLD, 45));
        registrationLabel.setForeground(new Color(0, 128, 0)); // Green text
        registrationLabel.setBounds(250, 10, 602, 60);
        registrationLabel.setHorizontalAlignment(JLabel.CENTER);
        registrationLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        registrationLabel.setOpaque(true);
        contentPane.add(registrationLabel);

        // Name field
        addField("Name:", 100, nameField);
        nameField = new JTextField();
        contentPane.add(nameField);

        // Email field
        addField("Email:", 160, emailField);
        emailField = new JTextField();
        contentPane.add(emailField);

        // Phone number field
        addField("Phone:", 220, phoneField);
        phoneField = new JTextField();
        contentPane.add(phoneField);

        // Address field
        addField("Address:", 280, addressField);
        addressField = new JTextField();
        contentPane.add(addressField);

        // Date of birth field
        addField("DOB (YYYY-MM-DD):", 340, dobField);
        dobField = new JTextField();
        contentPane.add(dobField);

        // Password field
        addField("Password:", 400, passwordField);
        passwordField = new JPasswordField();
        contentPane.add(passwordField);

        // Confirm password field
        addField("Confirm Password:", 460, confirmPasswordField);
        confirmPasswordField = new JPasswordField();
        contentPane.add(confirmPasswordField);

        // Show password checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(414, 500, 150, 20);
        contentPane.add(showPasswordCheckBox);
        showPasswordCheckBox.addActionListener(e -> {
            char echoChar = showPasswordCheckBox.isSelected() ? (char) 0 : '*';
            passwordField.setEchoChar(echoChar);
            confirmPasswordField.setEchoChar(echoChar);
        });

        // Terms checkbox
        JCheckBox termsCheckBox = new JCheckBox("I agree to the terms and conditions");
        termsCheckBox.setBounds(415, 530, 250, 20);
        contentPane.add(termsCheckBox);

        // Register button
        registerButton = new JButton("REGISTER");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setBackground(new Color(34, 139, 34));
        registerButton.setBounds(394, 570, 170, 43);
        contentPane.add(registerButton);

        // Add action listener to the register button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String dob = dobField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (isEmpty(name, email, phone, address, dob, password, confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Password and confirm password do not match", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Add your registration logic here
                    System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Date of Birth: " + dob + ", Password: " + password);
                    JOptionPane.showMessageDialog(null, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            });

            // Back button
            backButton = new JButton("BACK");
            backButton.setFont(new Font("Arial", Font.BOLD, 18));
            backButton.setForeground(new Color(255, 255, 255));
            backButton.setBackground(new Color(34, 139, 34));
            backButton.setBounds(574, 571, 170, 42);
            contentPane.add(backButton);

            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                // Go back to login form
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                dispose();
                }
            });
        }

        private void addField(String label, int y, JTextField field) {
            JLabel labelField = new JLabel(label);
            labelField.setFont(new Font("Arial", Font.BOLD, 18));
            labelField.setForeground(new Color(0, 0, 0));
            labelField.setBounds(275, y, 115, 30);
            contentPane.add(labelField);

            field = new JTextField();
            field.setFont(new Font("Arial", Font.BOLD, 18));
            field.setForeground(new Color(0, 0, 0));
            field.setBackground(new Color(240, 240, 240));
            field.setBounds(414, y - 5, 301, 40);
            contentPane.add(field);
        }

        private boolean isEmpty(String... fields) {
            for (String field : fields) {
                if (field.isEmpty()) {
                    return true;
                }
            }
            return false;
        }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }
}
Registration.java
Displaying Registration.java.