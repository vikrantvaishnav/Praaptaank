package score.generator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class HalfArcPanel extends JPanel {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;
    private static final int ARC_DIAMETER = 300;
    private static final int ARC_START_ANGLE = 180;
    private static final int ARC_SWEEP_ANGLE = 180;
    private static final int BORDER_WIDTH = 20;

    private int score;

    public HalfArcPanel(int score) {
        this.score = score;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int scorePercentage = score * 100 / 1000;
        int arcFillAngle = scorePercentage * ARC_SWEEP_ANGLE / 100;

        g.setColor(Color.BLACK);
        g.fillArc((PANEL_WIDTH - ARC_DIAMETER) / 2, (PANEL_HEIGHT - ARC_DIAMETER) / 2, ARC_DIAMETER, ARC_DIAMETER, ARC_START_ANGLE, ARC_SWEEP_ANGLE);

        g.setColor(Color.RED);
        g.fillArc((PANEL_WIDTH - ARC_DIAMETER) / 2, (PANEL_HEIGHT - ARC_DIAMETER) / 2, ARC_DIAMETER, ARC_DIAMETER, ARC_START_ANGLE, arcFillAngle);

        g.setColor(Color.BLACK);
        g.drawArc((PANEL_WIDTH - ARC_DIAMETER) / 2, (PANEL_HEIGHT - ARC_DIAMETER) / 2, ARC_DIAMETER, ARC_DIAMETER, ARC_START_ANGLE, ARC_SWEEP_ANGLE);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, PANEL_WIDTH / 2 - 40, PANEL_HEIGHT / 2 + 20);
    }
}
