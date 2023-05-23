package Student_Registration;

/**
 *
 * @author Vikrant
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddCertificate extends JFrame implements ActionListener {

	private JLabel addCert, line, courseName, organisation, credentialId, accomplishment, successful;
	private JButton addCertButton, accomplishmentFile, add;
	private JPanel p;
	private JTextField courseNameField, credentialIdField;
	private JComboBox<String> orgs;
	private JButton completeButton;

	public AddCertificate() {
		super("Praaptaank | Certification");

		setBounds(250, 50, 650, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(173, 216, 230));

		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216, 230));
		add(p);

		addCert = new JLabel("Additional Certifications");
		addCert.setBounds(230, 10, 600, 30);
		addCert.setFont(new Font("Courier", Font.BOLD, 20));
		p.add(addCert);

		line = new JLabel("Add more certification to enhance your score");
		line.setBounds(50, 60, 500, 20);
		line.setFont(new Font("Courier", Font.PLAIN, 16));
		p.add(line);

		addCertButton = new JButton("Add Certification+");
		addCertButton.setBounds(50, 100, 200, 30);
		addCertButton.setForeground(Color.BLACK);
		addCertButton.addActionListener(this);
		p.add(addCertButton);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addCertButton) {
			p.removeAll();
			p.revalidate();
			p.repaint();

			addCert = new JLabel("Additional Certifications");
			addCert.setBounds(230, 10, 600, 30);
			addCert.setFont(new Font("Courier", Font.BOLD, 20));
			p.add(addCert);

			line = new JLabel("Add more certification to enhance your score");
			line.setBounds(50, 60, 500, 20);
			line.setFont(new Font("Courier", Font.PLAIN, 16));
			p.add(line);

			courseName = new JLabel("Course Name : ");
			courseName.setBounds(50, 90, 150, 20);
			p.add(courseName);

			courseNameField = new JTextField();
			courseNameField.setBounds(210, 90, 200, 20);
			p.add(courseNameField);

			organisation = new JLabel("Orgranisation Name : ");
			organisation.setBounds(50, 120, 150, 20);
			p.add(organisation);

			String[] certificationOrgs = { "Select", "CompTIA", "Microsoft", "Cisco", "Amazon Web Services", "Google",
					"Oracle", "Red Hat", "VMware", "Project Management Institute", "Scrum Alliance",
					"International Institute of Business Analysis" };

			orgs = new JComboBox<String>(certificationOrgs);
			orgs.setBounds(210, 120, 200, 20);
			p.add(orgs);

			credentialId = new JLabel("Credential ID : ");
			credentialId.setBounds(50, 150, 150, 20);
			p.add(credentialId);

			credentialIdField = new JTextField();
			credentialIdField.setBounds(210, 150, 200, 20);
			p.add(credentialIdField);

			accomplishment = new JLabel("Add accomplishment : ");
			accomplishment.setBounds(50, 180, 150, 20);
			p.add(accomplishment);

			accomplishmentFile = new JButton("Choose File");
			accomplishmentFile.setBounds(210, 180, 150, 20);
			accomplishmentFile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
					fileChooser.setFileFilter(filter);
					int result = fileChooser.showOpenDialog(accomplishmentFile);
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						String fileName = selectedFile.getName();
						accomplishment.setText("Add accomplishment :            " + fileName);
						accomplishment.setBounds(50, 180, 330, 20);
						accomplishmentFile.setText("Change File");
						accomplishmentFile.setBounds(400, 180, 150, 20);
					}
				}
			});
			p.add(accomplishmentFile);
			
			successful = new JLabel("");
			successful.setBounds(50, 260, 300, 30);
			p.add(successful);
			
			add = new JButton("Save");
			add.setBounds(50, 230, 120, 30);
			add.setForeground(Color.BLACK);
			add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					successful.setText("Certification details added successfully");
				}
			});
			p.add(add);

			addCertButton = new JButton("Add More");
			addCertButton.setBounds(200, 230, 120, 30);
			addCertButton.setForeground(Color.BLACK);
			addCertButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					successful = new JLabel("Certification details saved successfully");
					successful.setBounds(50, 260, 200, 30);
					p.add(successful);
					setVisible(false);
					new AddCertificate();
				}
			});
			p.add(addCertButton);
			
			completeButton = new JButton("Next");
			completeButton.setBounds(350, 230, 120, 30);
			completeButton.setForeground(Color.BLACK);
			completeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
                                        new StudentLogin();
				}
			});
			p.add(completeButton);
		}

	}

	public static void main(String[] args) {
		new AddCertificate();
	}

}
