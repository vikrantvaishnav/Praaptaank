
package Student_Registration;

import College_Registration.Account;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import score.generator.ScoreInputFrame;

public class projectPage extends JFrame implements ActionListener{
    
    String Id;
    public projectPage(String praaptaank_id){
        super("Praaptaank:");
        this.Id = praaptaank_id;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        
        JLayeredPane jpl = new JLayeredPane();
        JTabbedPane jtp = new JTabbedPane();
        jpl.add(jtp);
        
        JTextArea ta = new JTextArea("Home page");
        jtp.addTab("Home", ta);
        getContentPane().add(jtp);
        
//        ScoreInputFrame hp = new ScoreInputFrame();
//        jtp.add("Home", hp);
        
        Personal_Details pd = new Personal_Details(Id);
        jtp.add("Personal Detail", pd);
        
      
        JTextArea ta1 = new JTextArea("Education Detail");
        
        jtp.addTab("Education Detail", ta1);
        getContentPane().add(jtp);
 
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Account")){
            System.out.println("YZ");
        }
    }
    
    
    public static void main(String[] args)
    {
        new projectPage("");
    }
}
