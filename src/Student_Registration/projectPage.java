
package Student_Registration;

import College_Registration.Account;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import score.generator.CreditScoreGenerator;

public class projectPage extends JFrame implements ActionListener{
    
    String Id;
    private JPanel p;
    public projectPage(String praaptaank_id){
        super("Praaptaank:");
        
        p = new JPanel();
        p.setSize(900, 900);       
        p.setLayout(null);
        p.setBackground(Color.white);
        
        this.Id = praaptaank_id;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 40, 900, 900);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(new Dimension(900, 900));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        
        JLayeredPane jpl = new JLayeredPane();
        JTabbedPane jtp = new JTabbedPane();
        jpl.add(jtp);
        getContentPane().add(jtp);
        
        
         JTextArea ta = new JTextArea("Factors of Student Score.\nXth Certificate\nXIIth Certification or Equivalent"
                 + "\nCollege Agaregate\nCertification from World-Wide Recognized Organization\nRegular Certification"
                 + "\nCo-Curricular Achivements\nConsistant improvement&Addon");
         ta.setFont(new Font("Courier", Font.BOLD, 15));
         
         ta.setBounds(480,350,500,300);
        p.add(ta);
        
        
        CreditScoreGenerator cs = new CreditScoreGenerator();
//        cs.setPreferredSize(new Dimension(300, 200));
        
        cs.setBounds(20, 50, 510, 290);
        p.add(cs);
        jtp.add("Home",p);
        
        
        Personal_Details pd = new Personal_Details(Id);
        jtp.add("Personal Detail", pd);
        
      
        Educational_Details ed = new Educational_Details(Id);
        JScrollPane scrollPane = new JScrollPane(ed);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jtp.add("Educational_Details",ed);
 
        
        setVisible(true);
        pack();
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
