import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton, existingAccountButton;
    private Image backgroundImage;

    public SignUpPage() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon("/Images/logo.png");
        backgroundImage = backgroundImageIcon.getImage();

        // Create a JPanel to paint the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(400, 300));
        setContentPane(backgroundPanel);

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel bodyLabel = new JLabel("Connect effortlessly, chat endlessly – our chat app is your gateway to seamless communication.");
        bodyLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        backgroundPanel.add(bodyLabel, constraints);

        JLabel emailLabel = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridwidth = 1;
        backgroundPanel.add(emailLabel, constraints);

        emailField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        backgroundPanel.add(emailField, constraints);

        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.gridwidth = 1;
        backgroundPanel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        backgroundPanel.add(passwordField, constraints);

        signUpButton = new JButton("Sign Up");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = 2;
        backgroundPanel.add(signUpButton, constraints);

        existingAccountButton = new JButton("Login with existing account");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = 2;
        backgroundPanel.add(existingAccountButton, constraints);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Validate the input and sign up the user
                //...

                // Clear the input fields
                emailField.setText("");
                passwordField.setText("");
            }
        });

        existingAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the login page
                //...
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage();
            }
        });
    }
}