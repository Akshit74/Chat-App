import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, forgotPasswordLink;

    public LoginPage() {
        setTitle("Log in to Chatbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the UI components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add welcome message
        JLabel welcomeLabel = new JLabel("Welcome back! Sign in using your social account or email to continue.");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(welcomeLabel, constraints);

        // Add email label and text field
        JLabel emailLabel = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(emailLabel, constraints);

        emailField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(emailField, constraints);

        // Add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(passwordField, constraints);

        // Add login button
        loginButton = new JButton("Log in to Chatbox");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(loginButton, constraints);

        // Add forgot password link
        forgotPasswordLink = new JButton("Forgot Password?");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 10, 5, 10);
        panel.add(forgotPasswordLink, constraints);

        // Add the panel to the frame
        add(panel);

        // Set the frame size and make it visible
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                //Validate email and password input
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginPage.this,
                            "Please enter both email and password.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate email format
                if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    JOptionPane.showMessageDialog(LoginPage.this,
                            "Please enter a valid email address.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Proceed with the login process
                // ...
            }
        });

        // Add action listener for the forgot password link
        forgotPasswordLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the forgot password page
                // ...
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginPage();
            }
        });
    }
}