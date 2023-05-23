package score.generator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CreditScoreGenerator extends JPanel {

    private static final int PANEL_WIDTH = 510;
    private static final int PANEL_HEIGHT = 290;

    private int score;

    public CreditScoreGenerator() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);

        generateScore();
    }

    private void generateScore() {
        Timer timer = new Timer(50, new ActionListener() {
            int currentScore = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentScore < score) {
                    currentScore += 10; // Increment the score gradually
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer when the score reaches the desired value
                }
            }
        });

        Random random = new Random();
        score = random.nextInt(201) + 400; // Generates a random number between 400 and 600 (inclusive)

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panelWidth, panelHeight);

        int arcDiameter = 480;
        int arcStartAngle = -180;
        int arcSweepAngle = -180;

        int scorePercentage = score * 100 / 1000;
        int arcFillAngle = scorePercentage * arcSweepAngle / 100;

        int arcX = 10;
        int arcY = 10;

        // Draw the light blue arc
        g.setColor(new Color(30, 144, 255));
        g.fillArc(arcX, arcY, arcDiameter, arcDiameter, arcStartAngle, arcFillAngle);

        // Draw the outline of the arc
        g.setColor(Color.BLACK);
        g.drawArc(arcX, arcY, arcDiameter, arcDiameter, arcStartAngle, arcSweepAngle);

        // Draw the credit score text
        String scoreText = "Credit Score: " + score;
        g.setFont(new Font("Arial", Font.BOLD, 24));

        // Draw the score text in white color
        g.setColor(Color.BLACK);
        g.drawString(scoreText, panelWidth / 2 - 100, panelHeight / 2 +130);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Credit Score Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new CreditScoreGenerator());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

