import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class Welcome {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Load the background image
                ImageIcon backgroundImageIcon = new ImageIcon("/Images/background.png");
                Image backgroundImage = backgroundImageIcon.getImage();

                // Load the logo image
                ImageIcon logoImageIcon = new ImageIcon("/Images/logo.png");
                Image logoImage = logoImageIcon.getImage();

                // Create the splash screen frame
                JFrame splashFrame = new JFrame();
                splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                splashFrame.setUndecorated(true);
                splashFrame.setShape(new RoundRectangle2D.Double(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight(), 20, 20));

                // Create a panel to hold the background image
                JPanel backgroundPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(backgroundImage, 0, 0, null);
                    }
                };
                backgroundPanel.setLayout(new BorderLayout());

                // Add the logo and title to the panel
                JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
                JLabel titleLabel = new JLabel("ChatPP", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
                titleLabel.setForeground(Color.WHITE);

                backgroundPanel.add(logoLabel, BorderLayout.CENTER);
                backgroundPanel.add(titleLabel, BorderLayout.SOUTH);

                splashFrame.add(backgroundPanel);
                splashFrame.pack();
                splashFrame.setLocationRelativeTo(null);
                splashFrame.setVisible(true);

                // Simulate loading time
                Thread.sleep(3000);

                // Close the splash screen frame
                splashFrame.dispose();

                // Create the welcome frame
                JFrame welcomeFrame = new JFrame("ChatPP Welcome Page");
                welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                welcomeFrame.setSize(400, 200);
                welcomeFrame.setLocationRelativeTo(null);
                welcomeFrame.setLayout(new GridBagLayout());

                // Add a label to the welcome frame
                JLabel welcomeLabel = new JLabel("Welcome to ChatPP!");
                welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
                welcomeFrame.add(welcomeLabel, new GridBagConstraints());

                // Show the welcome frame
                welcomeFrame.setVisible(true);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
