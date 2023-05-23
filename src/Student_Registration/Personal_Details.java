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
    ConnectJDBC c;
    public Personal_Details(String praaptaank_id){
        this.Id = praaptaank_id;
        setBounds(0, 0, 900, 900);
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
        fname.setBounds(20, 65, 150, 20);
        panel.add(fname);
        
        JLabel Fname = new JLabel("");
        Fname.setBounds(150, 65, 300, 20);
        panel.add(Fname);
        
        JLabel mname = new JLabel("Mother's Name: ");
        mname.setForeground(Color.black);
        mname.setBounds(20, 90, 150, 20);
        panel.add(mname);
        
        JLabel Mname = new JLabel("");
        Mname.setBounds(150, 90, 300, 20);
        panel.add(Mname);
       
        
        JLabel gender = new JLabel("Gender: ");
        gender.setForeground(Color.black);
        gender.setBounds(20, 115, 150, 20);
        panel.add(gender);
        
        JLabel Gender = new JLabel("");
        Gender.setBounds(150, 115, 300, 20);
        panel.add(Gender);
        
        JLabel dob = new JLabel("DOB: ");
        dob.setForeground(Color.black);
        dob.setBounds(20, 140, 150, 20);
        panel.add(dob);
        
        JLabel Dob = new JLabel("");
        Dob.setBounds(150, 140, 300, 20);
        panel.add(Dob);
        
        JLabel mail = new JLabel("Mail: ");
        mail.setForeground(Color.black);
        mail.setBounds(20, 165, 150, 20);
        panel.add(mail);
        
        JLabel Mail = new JLabel("");
        Mail.setBounds(150, 165, 300, 20);
        panel.add(Mail);
        
        JLabel phone = new JLabel("Mob no: ");
        phone.setForeground(Color.black);
        phone.setBounds(20, 190, 150, 20);
        panel.add(phone);
        
        JLabel Phone = new JLabel("");
        Phone.setBounds(150, 190, 300, 20);
        panel.add(Phone);
        
        JLabel pid = new JLabel("Praaptaank Id: ");
        pid.setForeground(Color.black);
        pid.setBounds(20, 215, 150, 20);
        panel.add(pid);
        
        JLabel Pid = new JLabel("");
        Pid.setBounds(150, 215, 300, 20);
        panel.add(Pid);
        
        
        
        
        
        
        
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 300, 880, 400);
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Address Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel2.setLayout(null);
        panel2.setForeground(Color.BLACK);
        add(panel2);
        
        
        JLabel permanent = new JLabel("Permanent Address: ");
        permanent.setForeground(Color.black);
        permanent.setBounds(20, 20, 150, 20);
        permanent.setFont(new Font("Courier", Font.BOLD, 15));
        panel2.add(permanent);
        
        JLabel flat = new JLabel("Flat/House No: ");
        flat.setForeground(Color.black);
        flat.setBounds(20, 50, 150, 20);
        panel2.add(flat);
        
        JLabel Flat = new JLabel("");
        Flat.setBounds(150, 50, 300, 20);
        panel2.add(Flat);
        
        JLabel area = new JLabel("Area/Street: ");
        area.setForeground(Color.black);
        area.setBounds(20, 75, 150, 20);
        panel2.add(area);
        
        JLabel Area = new JLabel("");
        Area.setBounds(150, 75, 300, 20);
        panel2.add(Area);
        
        JLabel pin = new JLabel("Pincode: ");
        pin.setForeground(Color.black);
        pin.setBounds(20, 100, 150, 20);
        panel2.add(pin);
        
        JLabel Pin = new JLabel("");
        Pin.setBounds(150, 100, 300, 20);
        panel2.add(Pin);
        
        JLabel city = new JLabel("City/Town: ");
        city.setForeground(Color.black);
        city.setBounds(20, 125, 150, 20);
        panel2.add(city);
        
        JLabel City = new JLabel("");
        City.setBounds(150, 125, 300, 20);
        panel2.add(City);
        
        JLabel state = new JLabel("State: ");
        state.setForeground(Color.black);
        state.setBounds(20, 150, 150, 20);
        panel2.add(state);
        
        JLabel State = new JLabel("");
        State.setBounds(150, 150, 300, 20);
        panel2.add(State);
        
        
        
        
        
        
        JLabel current = new JLabel("Current Address: ");
        current.setForeground(Color.black);
        current.setBounds(20, 180, 150, 20);
        current.setFont(new Font("Courier", Font.BOLD, 15));
        panel2.add(current);
        
        JLabel cflat = new JLabel("Flat/House No: ");
        cflat.setForeground(Color.black);
        cflat.setBounds(20, 205, 150, 20);
        panel2.add(cflat);
        
        JLabel CFlat = new JLabel("");
        CFlat.setBounds(150, 205, 300, 20);
        panel2.add(CFlat);
        
        JLabel carea = new JLabel("Area/Street: ");
        carea.setForeground(Color.black);
        carea.setBounds(20, 230, 150, 20);
        panel2.add(carea);
        
        JLabel Carea = new JLabel("");
        Carea.setBounds(150, 230, 300, 20);
        panel2.add(Carea);
        
        JLabel cpin = new JLabel("Pincode: ");
        cpin.setForeground(Color.black);
        cpin.setBounds(20, 255, 150, 20);
        panel2.add(cpin);
        
        JLabel Cpin = new JLabel("");
        Cpin.setBounds(150, 255, 300, 20);
        panel2.add(Cpin);
        
        JLabel ccity = new JLabel("City/Town: ");
        ccity.setForeground(Color.black);
        ccity.setBounds(20, 280, 150, 20);
        panel2.add(ccity);
        
        JLabel Ccity = new JLabel("");
        Ccity.setBounds(150, 280, 300, 20);
        panel2.add(Ccity);
        
        JLabel cstate = new JLabel("State: ");
        cstate.setForeground(Color.black);
        cstate.setBounds(20, 305, 150, 20);
        panel2.add(cstate);
        
        JLabel Cstate = new JLabel("");
        Cstate.setBounds(150, 305, 300, 20);
        panel2.add(Cstate);

        
        
        try{
            c = new ConnectJDBC();
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
            
            ResultSet rs1 = c.s.executeQuery("select * from address_info where Praaptaank_id = '"+Id+"'");
          
            while(rs1.next()){
                Flat.setText(rs1.getString("flatno"));
                Area.setText(rs1.getString("area"));
                Pin.setText(rs1.getString("pin"));
                City.setText(rs1.getString("city"));
                State.setText(rs1.getString("state")); 
                
                CFlat.setText(rs1.getString("flatnosec"));
                Carea.setText(rs1.getString("areasec"));
                Cpin.setText(rs1.getString("pinsec"));
                Ccity.setText(rs1.getString("citysec"));
                Cstate.setText(rs1.getString("statesec")); 
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
