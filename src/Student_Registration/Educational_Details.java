
package Student_Registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Vikrant
 */
public class Educational_Details extends JPanel implements ActionListener {
    String Id;
    public Educational_Details(String praaptaank_id){
        this.Id = praaptaank_id;
        setBounds(0, 0, 900, 900);
        setBackground(Color.WHITE);
        setLayout(null);
        setForeground(Color.BLACK);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 880, 200);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Higher Education", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel.setLayout(null);
        panel.setForeground(Color.BLACK);
        add(panel);
        
        
        JLabel sname = new JLabel("Board: ");
        sname.setForeground(Color.black);
        sname.setBounds(20, 40, 150, 20);
        panel.add(sname);
        
        JLabel Sname = new JLabel("");
        Sname.setBounds(150, 40, 300, 20);
        panel.add(Sname);
        
        JLabel fname = new JLabel("School Name: ");
        fname.setForeground(Color.black);
        fname.setBounds(20, 65, 150, 20);
        panel.add(fname);
        
        JLabel Fname = new JLabel("");
        Fname.setBounds(150, 65, 300, 20);
        panel.add(Fname);
        
        JLabel mname = new JLabel("Enroll.No: ");
        mname.setForeground(Color.black);
        mname.setBounds(20, 90, 150, 20);
        panel.add(mname);
        
        JLabel Mname = new JLabel("");
        Mname.setBounds(150, 90, 300, 20);
        panel.add(Mname);
       
        
        JLabel gender = new JLabel("Percentage: ");
        gender.setForeground(Color.black);
        gender.setBounds(20, 115, 150, 20);
        panel.add(gender);
        
        JLabel Gender = new JLabel("");
        Gender.setBounds(150, 115, 300, 20);
        panel.add(Gender);
        
        JLabel dob = new JLabel("year of passing:");
        dob.setForeground(Color.black);
        dob.setBounds(20, 140, 150, 20);
        panel.add(dob);
        
        JLabel Dob = new JLabel("");
        Dob.setBounds(150, 140, 300, 20);
        panel.add(Dob);
        
        
        
        
        
        
        
        
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 200, 880, 200);
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Intermediate Education", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel2.setLayout(null);
        panel2.setForeground(Color.BLACK);
        add(panel2);
        
       
        
        JLabel flat = new JLabel("Board: ");
        flat.setForeground(Color.black);
        flat.setBounds(20, 50, 150, 20);
        panel2.add(flat);
        
        JLabel Flat = new JLabel("");
        Flat.setBounds(150, 50, 300, 20);
        panel2.add(Flat);
        
        JLabel area = new JLabel("School Name: ");
        area.setForeground(Color.black);
        area.setBounds(20, 75, 150, 20);
        panel2.add(area);
        
        JLabel Area = new JLabel("");
        Area.setBounds(150, 75, 300, 20);
        panel2.add(Area);
        
        JLabel pin = new JLabel("Enroll.No: ");
        pin.setForeground(Color.black);
        pin.setBounds(20, 100, 150, 20);
        panel2.add(pin);
        
        JLabel Pin = new JLabel("");
        Pin.setBounds(150, 100, 300, 20);
        panel2.add(Pin);
        
        JLabel city = new JLabel("Percentage: ");
        city.setForeground(Color.black);
        city.setBounds(20, 125, 150, 20);
        panel2.add(city);
        
        JLabel City = new JLabel("");
        City.setBounds(150, 125, 300, 20);
        panel2.add(City);
        
        JLabel state = new JLabel("year of passing: ");
        state.setForeground(Color.black);
        state.setBounds(20, 150, 150, 20);
        panel2.add(state);
        
        JLabel State = new JLabel("");
        State.setBounds(150, 150, 300, 20);
        panel2.add(State);
        
        
        
        
        
        
        
        
        
        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 400, 880, 400);
        panel3.setBackground(Color.WHITE);
        panel3.setBorder(new TitledBorder(new LineBorder(new Color(216,173,230), 2), "Intermediate Education", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(216,173,230)));
        panel3.setLayout(null);
        panel3.setForeground(Color.BLACK);
        add(panel3);
        
        
        JLabel uni = new JLabel("University: ");
        uni.setForeground(Color.black);
        uni.setBounds(20, 45, 150, 20);
        panel3.add(uni);
        
        JLabel Uni = new JLabel("");
        Uni.setBounds(150, 45, 300, 20);
        panel3.add(Uni);
        
        JLabel cname = new JLabel("College Name: ");
        cname.setForeground(Color.black);
        cname.setBounds(20, 70, 150, 20);
        panel3.add(cname);
        
        JLabel Cname = new JLabel("");
        Cname.setBounds(150, 70, 300, 20);
        panel3.add(Cname);
        
        JLabel coursename = new JLabel("Course Name: ");
        coursename.setForeground(Color.black);
        coursename.setBounds(20, 95, 150, 20);
        panel3.add(coursename);
        
        JLabel Coursename = new JLabel("");
        Coursename.setBounds(150, 95, 300, 20);
        panel3.add(Coursename);
        
        JLabel specification = new JLabel("Specification: ");
        specification.setForeground(Color.black);
        specification.setBounds(20, 120, 150, 20);
        panel3.add(specification);
        
        JLabel Specification = new JLabel("");
        Specification.setBounds(150, 120, 300, 20);
        panel3.add(Specification);
        
        
        JLabel enroll_no = new JLabel("Enroll No: ");
        enroll_no.setForeground(Color.black);
        enroll_no.setBounds(20, 145, 150, 20);
        panel3.add(enroll_no);
        
        JLabel Enroll_no = new JLabel("");
        Enroll_no.setBounds(150, 145, 300, 20);
        panel3.add(Enroll_no);
        
        JLabel yearpass = new JLabel("year of passing: ");
        yearpass.setForeground(Color.black);
        yearpass.setBounds(20, 170, 150, 20);
        panel3.add(yearpass);
        
        JLabel Yearpass = new JLabel("");
        Yearpass.setBounds(150, 170, 300, 20);
        panel3.add(Yearpass);
        
        
        JLabel sem1 = new JLabel("Sem1: ");
        sem1.setForeground(Color.black);
        sem1.setBounds(20, 195, 150, 20);
        panel3.add(sem1);
        
        JLabel Sem1 = new JLabel("");
        Sem1.setBounds(150, 195, 300, 20);
        panel3.add(Sem1);
        
        
        JLabel sem2 = new JLabel("Sem2: ");
        sem2.setForeground(Color.black);
        sem2.setBounds(20, 220, 150, 20);
        panel3.add(sem2);
        
        JLabel Sem2 = new JLabel("");
        Sem2.setBounds(150, 220, 300, 20);
        panel3.add(Sem2);
        
        JLabel sem3 = new JLabel("Sem3: ");
        sem3.setForeground(Color.black);
        sem3.setBounds(20, 245, 150, 20);
        panel3.add(sem3);
        
        JLabel Sem3 = new JLabel("");
        Sem3.setBounds(150, 245, 300, 20);
        panel3.add(Sem3);
        
        
        JLabel sem4 = new JLabel("Sem4: ");
        sem4.setForeground(Color.black);
        sem4.setBounds(20, 270, 150, 20);
        panel3.add(sem4);
        
        JLabel Sem4 = new JLabel("");
        Sem4.setBounds(150, 270, 300, 20);
        panel3.add(Sem4);
        
        
        JLabel sem5 = new JLabel("Sem5: ");
        sem5.setForeground(Color.black);
        sem5.setBounds(20, 295, 150, 20);
        panel3.add(sem5);
        
        JLabel Sem5 = new JLabel("");
        Sem5.setBounds(150, 295, 300, 20);
        panel3.add(Sem5);
        
        
        JLabel sem6 = new JLabel("Sem6: ");
        sem6.setForeground(Color.black);
        sem6.setBounds(20, 320, 150, 20);
        panel3.add(sem6);
        
        JLabel Sem6 = new JLabel("");
        Sem6.setBounds(150, 320, 300, 20);
        panel3.add(Sem6);
        
        
        JLabel sem7 = new JLabel("Sem7: ");
        sem7.setForeground(Color.black);
        sem7.setBounds(20, 345, 150, 20);
        panel3.add(sem7);
        
        JLabel Sem7 = new JLabel("");
        Sem7.setBounds(150, 345, 300, 20);
        panel3.add(Sem7);
        
        
        JLabel sem8 = new JLabel("Sem8: ");
        sem8.setForeground(Color.black);
        sem8.setBounds(20, 370, 150, 20);
        panel3.add(sem8);
        
        JLabel Sem8 = new JLabel("");
        Sem8.setBounds(150, 370, 300, 20);
        panel3.add(Sem8);
        
        
        
        
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(true);
    }
            
    
    
    public static void main(String[] args){
        new Educational_Details("");
    }
}
