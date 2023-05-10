package Student_Registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.*;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

//import Student_Registration.RegisterFrame.DateLabelFormatter;

public class StudentReview extends JFrame implements ActionListener{
	
	private JLabel message, nameLabel, FnameLabel, MnameLabel, GenderLabel, DOBLabel, emailLabel, MobNumLabel, praaptaankIdLabel, praaptaankId;
	private JTextField nameText, FnameText, MnameText, GenderText, DOBText, emailText, MobNumText;
	private JButton Edit, confirm, back;
	private JRadioButton genderMale;
	private JRadioButton genderFemale;
	private ButtonGroup genderGroup;
//	private JDatePanelImpl datePanel;
//	private JDatePickerImpl datePicker;
//	private JLabel dobFormat;

	public StudentReview() {
		
		super("Praptank | Student Review");
		
		getContentPane().setBackground(new Color(173, 216, 230));
		setBounds(250, 50, 650, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
        message = new JLabel("Personal Details");
        message.setFont(new Font("Courier", Font.BOLD, 20));
		message.setBounds(230, 10, 600, 30);
        add(message);
		
		Edit = new JButton("🖊️");
		Edit.setBounds(400, 15, 50, 20);
		Edit.addActionListener(this);
		add(Edit);
        
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 20);
        add(nameLabel);
        
		nameText = new JTextField();
		/*****************************/
		nameText.setText("Lorem Lorem");
		/*****************************/
		nameText.setBounds(150, 60, 200, 20);
		nameText.setEditable(false);
		add(nameText);
		
		FnameLabel = new JLabel("Father's Name:");
		FnameLabel.setBounds(50, 90, 100, 20);
		add(FnameLabel);
		
		FnameText = new JTextField();
		FnameText.setBounds(150, 90, 200, 20);
		/*****************************/
		FnameText.setText("Lorem Lorem");
		/*****************************/
		FnameText.setEditable(false);
		add(FnameText);
		
		MnameLabel = new JLabel("Mother's Name:");
		MnameLabel.setBounds(50, 120, 100, 20);
		add(MnameLabel);
		
		MnameText = new JTextField();
		MnameText.setBounds(150, 120, 200, 20);
		/*****************************/
		MnameText.setText("Lorem Lorem");
		/*****************************/
		MnameText.setEditable(false);
		add(MnameText);
		
		DOBLabel = new JLabel("DOB");
		DOBLabel.setBounds(50, 150, 100, 20);
		add(DOBLabel);
		
		/************************************/
//		UtilDateModel model = new UtilDateModel();
//		model.setDate(1999, 01, 02);
//		model.setSelected(true);
//		Properties p = new Properties();
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");
//		datePanel = new JDatePanelImpl(model, p);
//		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//		dobFormat = new JLabel("");
		
		GenderLabel = new JLabel("Gender");
		GenderLabel.setBounds(50, 180, 100, 20);
		add(GenderLabel);
		
		genderMale = new JRadioButton("Male", true);
		genderMale.setBackground(new Color(173, 216, 230));
		genderMale.setBounds(150, 180, 100, 20);
		/*****************************/
		genderMale.setSelected(true);
		/*****************************/
		genderMale.setEnabled(false);
		add(genderMale);
		
		genderFemale = new JRadioButton("Female");
		genderFemale.setBackground(new Color(173, 216, 230));
		genderFemale.setBounds(250, 180, 100, 20);
		genderFemale.setEnabled(false);
		add(genderFemale);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(genderMale);
		genderGroup.add(genderFemale);
		
		emailLabel = new JLabel("Mail Id");
		emailLabel.setBounds(50, 210, 100, 20);
		add(emailLabel);
		
		emailText = new JTextField();
		emailText.setBounds(150, 210, 200, 20);
		emailText.setEditable(false);
		/*******************************/
		emailText.setText("example@gmail.com");
		/*******************************/
		add(emailText);
		
		MobNumLabel = new JLabel("Mobile No");
		MobNumLabel.setBounds(50, 240, 100, 20);
		add(MobNumLabel);
		
		MobNumText = new JTextField();
		/*********************************/
		MobNumText.setText("9999999999");
		/*********************************/
		MobNumText.setEditable(false);
		MobNumText.setBounds(150, 240, 200, 20);
		add(MobNumText);
		
		praaptaankIdLabel = new JLabel("Praaptank Id:");
		praaptaankIdLabel.setBounds(50, 270, 100, 20);
		add(praaptaankIdLabel);
		
		praaptaankId = new JLabel();
		/***********************************/
		praaptaankId.setText("********");
		/***********************************/
		praaptaankId.setBounds(150, 270, 200, 20);
		add(praaptaankId);
		
		confirm = new JButton("Confirm & next");
		confirm.setBounds(200, 350, 200, 20);
		confirm.addActionListener(this);
		add(confirm);
		
		back = new JButton("←");
		back.setForeground(Color.black);
		back.addActionListener(this);
		back.setBounds(0, 0, 50, 20);
		add(back);
		
        
        setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == back) {
			setVisible(false);
			new Education_Frame();
		}
		
		if(e.getSource() == confirm) {
			
		}
		
		if(e.getSource() == Edit) {
			nameText.setEditable(true);
			FnameText.setEditable(true);
			MnameText.setEditable(true);
			genderFemale.setEnabled(true);
			genderMale.setEnabled(true);
			emailText.setEditable(true);
			MobNumText.setEditable(true);
		}
		
	}
	
	public static void main(String[] args) {
		new StudentReview();
	}

}
