package GUI.SMS;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton googleButton;
    private JButton facebookButton;
    private JCheckBox showPasswordCheckBox;
    private JCheckBox rememberCheckBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1088, 660);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250)); // Light blue-green background
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Create the logo and "LOGIN" text
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("Image/Student.png")); // Replace "logo.png" with your actual logo image
        logo.setBounds(158, 23, 721, 265);
        contentPane.add(logo);
        
        // Resize the image
        int labelWidth = logo.getWidth();
        int labelHeight = logo.getHeight();
        Image img = new ImageIcon("Image/Student.png").getImage();
        Image newImage = img.getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);
        logo.setIcon(newIcon);

        // Create the email field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        emailLabel.setForeground(new Color(0, 0, 0)); // Black text
        emailLabel.setBounds(275, 325, 115, 30); // Larger bounds
        contentPane.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(400, 320, 301, 40); // Larger bounds
        emailField.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        emailField.setForeground(new Color(0, 0, 0)); // Black text
        emailField.setBackground(new Color(240, 240, 240)); // Light gray background
        contentPane.add(emailField);
        emailField.setColumns(10);

        // Create the password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        passwordLabel.setForeground(new Color(0, 0, 0)); // Black text
        passwordLabel.setBounds(275, 375, 120, 30); // Larger bounds
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 370, 301, 40); // Larger bounds
        passwordField.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        passwordField.setForeground(new Color(0, 0, 0)); // Black text
        passwordField.setBackground(new Color(240, 240, 240)); // Light gray background
        contentPane.add(passwordField);

        // Create the show password checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(new Font("Arial", Font.BOLD, 14)); // Larger font size
        showPasswordCheckBox.setForeground(new Color(0, 0, 0)); // Black text
        showPasswordCheckBox.setBounds(400, 420, 150, 20); // Larger bounds
        contentPane.add(showPasswordCheckBox);

        showPasswordCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0); // show password
                } else {
                    passwordField.setEchoChar('*'); // hide password
                }
            }
        });

     // Create the login button
        loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size
        loginButton.setForeground(new Color(255, 255, 255)); // White text
        loginButton.setBackground(new Color(34, 139, 34)); // Forest green background
        loginButton.setBounds(400, 519, 301, 40); // Larger bounds
        contentPane.add(loginButton);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Check if email and password are not empty
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(loginButton, "Please enter both email and password", 
                    		"Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Validate email
                    if (!isValidEmail(email)) {
                        JOptionPane.showMessageDialog(loginButton, "Invalid email address", "Error", 
                        		JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Validate password
                        if (!isValidPassword(password)) {
                            JOptionPane.showMessageDialog(loginButton, "Password must be at least 8 characters "
                            		+ "long and contain at least one uppercase letter, one lowercase letter, "
                            		+ "and one digit", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Add your login logic here
                            System.out.println("Email: " + email + ", Password: " + password);
                            JOptionPane.showMessageDialog(loginButton, "Login successful", "Success", 
                            		JOptionPane.INFORMATION_MESSAGE);
                         StudentData sdata = new StudentData();
                       	 sdata.setVisible(true);
                       	 dispose();
                            
                        }
                    }
                }
            }
        });

     // Create the Google button
        googleButton = new JButton("Google");
        googleButton.setFont(new Font("Arial", Font.BOLD, 14)); // Larger font size
        googleButton.setForeground(new Color(0, 0, 0)); // Black text
        googleButton.setBackground(new Color(255, 255, 255)); // White background
        googleButton.setBounds(400, 569, 150, 30); // Larger bounds
        contentPane.add(googleButton);

        // Add action listener to the Google button
        googleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Google login page in default browser
                String url = "https://accounts.google.com/signin";
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                } catch (java.io.IOException ex) {
                    System.out.println("Error opening Google login page: " + ex.getMessage());
                }
            }
        });

        // Create the Facebook button
        facebookButton = new JButton("Facebook");
        facebookButton.setFont(new Font("Arial", Font.BOLD, 14)); // Larger font size
        facebookButton.setForeground(new Color(0, 0, 0)); // Black text
        facebookButton.setBackground(new Color(255, 255, 255)); // White background
        facebookButton.setBounds(568, 569, 133, 30); // Larger bounds
        contentPane.add (facebookButton);

        // Add action listener to the Facebook button
        facebookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Facebook login page in default browser
                String url = "https://www.facebook.com/login/";
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                } catch (java.io.IOException ex) {
                    System.out.println("Error opening Facebook login page: " + ex.getMessage());
                }
            }
        });

        rememberCheckBox = new JCheckBox("Remember me");
        rememberCheckBox.setFont(new Font("Arial", Font.BOLD, 14)); // Larger font size
        rememberCheckBox.setForeground(new Color(0, 0, 0)); // Black text
        rememberCheckBox.setBounds(400, 450, 150, 20); // Larger bounds
        contentPane.add(rememberCheckBox);

     // Create the registration prompt
        JLabel registerPrompt = new JLabel("Don't have an account?");
        registerPrompt.setFont(new Font("Arial", Font.PLAIN, 14)); // Font size
        registerPrompt.setForeground(new Color(0, 0, 0)); // Black text
        registerPrompt.setBounds(410, 479, 157, 30); // Positioning
        contentPane.add(registerPrompt);

        // Create the register button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Font size
        registerButton.setForeground(new Color(0, 0, 255)); // Blue text
        registerButton.setBackground(new Color(240, 240, 240)); // Light gray background
        registerButton.setBounds(567, 479, 100, 30); // Positioning
        contentPane.add(registerButton);

        // Add action listener to the register button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Registration regsbtn = new Registration();
            	 regsbtn.setVisible(true);
            	 dispose();
            }
        });
    }
    // Method to validate email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    // Method to validate password
    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }
}
