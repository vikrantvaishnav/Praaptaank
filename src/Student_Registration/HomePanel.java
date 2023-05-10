
package Student_Registration;

import College_Registration.Account;
import Database.ConnectJDBC;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import score.generator.ScoreInputFrame;

public class HomePanel extends JPanel implements ActionListener{
    
    
    public HomePanel(String praaptaank_id){
        setBounds(0, 0, 900, 600);
        setBackground(Color.WHITE);
        setLayout(null);
        setForeground(Color.BLACK);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Praaptaank Score", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        
       
        add(panel);
        
        
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        
        new HomePanel("");
    }
    
             
}
