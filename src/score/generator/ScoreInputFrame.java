package score.generator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreInputFrame extends JPanel implements ActionListener {

    private final JTextField scoreTextField;
    private final JButton submitButton;

    public ScoreInputFrame() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Score Input");

        scoreTextField = new JTextField();
        scoreTextField.setPreferredSize(new Dimension(100, 30));

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter your score:"));
        inputPanel.add(scoreTextField);
        inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);

//        pack();
//        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = scoreTextField.getText();
            int score;
            try {
                score = Integer.parseInt(input);
                new ScoreDisplayFrame(score);
//                dispose();
            } catch (NumberFormatException ex) {
                scoreTextField.setText("");
                scoreTextField.requestFocus();
            }
        }
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(true);
    }
    
     public static void main(String[] args) {
        new ScoreInputFrame();
    }
}
