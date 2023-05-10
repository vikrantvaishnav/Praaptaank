package Student_Registration;
/**
 *
 * @author Vikrant
 */

import java.awt.Color;
import College_Registration.Account;
import Database.ConnectJDBC;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Personal_Details extends JPanel implements ActionListener{
    
    String Id;
    public Personal_Details(String praaptaank_id){
        this.Id = praaptaank_id;
        setBounds(0, 0, 900, 600);
        setBackground(Color.WHITE);
        setLayout(null);
        setForeground(Color.BLACK);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 880, 300);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        add(panel);
        
        
        JLabel sname = new JLabel("Name: ");
        sname.setForeground(Color.black);
        sname.setBounds(20, 40, 150, 20);
        panel.add(sname);
        
        JLabel Sname = new JLabel("");
        Sname.setBounds(150, 40, 300, 20);
        panel.add(Sname);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setForeground(Color.black);
        fname.setBounds(20, 60, 150, 20);
        panel.add(fname);
        
        JLabel Fname = new JLabel("");
        Fname.setBounds(150, 60, 300, 20);
        panel.add(Fname);
        
        JLabel mname = new JLabel("Mother's Name: ");
        mname.setForeground(Color.black);
        mname.setBounds(20, 80, 150, 20);
        panel.add(mname);
        
        JLabel Mname = new JLabel("");
        Mname.setBounds(150, 80, 300, 20);
        panel.add(Mname);
       
        
        JLabel gender = new JLabel("Gender: ");
        gender.setForeground(Color.black);
        gender.setBounds(20, 100, 150, 20);
        panel.add(gender);
        
        JLabel Gender = new JLabel("");
        Gender.setBounds(150, 100, 300, 20);
        panel.add(Gender);
        
        JLabel dob = new JLabel("DOB: ");
        dob.setForeground(Color.black);
        dob.setBounds(20, 120, 150, 20);
        panel.add(dob);
        
        JLabel Dob = new JLabel("");
        Dob.setBounds(150, 120, 300, 20);
        panel.add(Dob);
        
        JLabel mail = new JLabel("Mail: ");
        mail.setForeground(Color.black);
        mail.setBounds(20, 140, 150, 20);
        panel.add(mail);
        
        JLabel Mail = new JLabel("");
        Mail.setBounds(150, 140, 300, 20);
        panel.add(Mail);
        
        JLabel phone = new JLabel("Mob no: ");
        phone.setForeground(Color.black);
        phone.setBounds(20, 160, 150, 20);
        panel.add(phone);
        
        JLabel Phone = new JLabel("");
        Phone.setBounds(150, 160, 300, 20);
        panel.add(Phone);
        
        JLabel pid = new JLabel("Praaptaank Id: ");
        pid.setForeground(Color.black);
        pid.setBounds(20, 180, 150, 20);
        panel.add(pid);
        
        JLabel Pid = new JLabel("");
        Pid.setBounds(150, 180, 300, 20);
        panel.add(Pid);
        
        
        
        
        
        
        
        
        try{
            ConnectJDBC c = new ConnectJDBC();
            ResultSet rs = c.s.executeQuery("select * from student_personal_detail where Praaptaank_Id = '"+Id+"'");
            
            while(rs.next()){
                Sname.setText(rs.getString("Sname"));
                Fname.setText(rs.getString("Fname"));
                Mname.setText(rs.getString("Mname"));
                Gender.setText(rs.getString("Gender"));
                Dob.setText(rs.getString("DOB"));
                Mail.setText(rs.getString("Mailid"));
                Phone.setText(rs.getString("Mobile_no"));
                Pid.setText(rs.getString("Praaptaank_id"));
                
                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new Personal_Details("");
    }
    
             
}
