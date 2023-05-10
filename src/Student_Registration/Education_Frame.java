package Student_Registration;

//public class Education_Frame {
//    
//}
import Database.ConnectJDBC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Education_Frame extends JFrame implements ActionListener {

    private JComboBox<String> educationList, boardList, courseList;
    private JButton addEducationButton, completeButton, addButton, addMoreButton, back, back2, fileButton;
    private JLabel educationLabel, schoolNameLabel, UniversityLabel, courseNameLabel, successLabel, headingLabel,
            boardLabel, enrollmentNumberLabel, sem1Label, sem2Label, sem3Label, sem4Label, sem5Label, sem6Label,
            sem7Label, sem8Label, aggLabel, SpecificationLabel, durationLabel, percentageLabel, yearOfPassingLabel,
            fileLabel;
    private String educationLevel;
    private JPanel p;
    private JTextField schoolNameField, enrollmentNumberField, SpecificationField, percentageField, yearOfPassingField,
            sem1Field, sem2Field, sem3Field, sem4Field, sem5Field, sem6Field, sem7Field, sem8Field, aggField,
            durationField;

    public Education_Frame() {
        super("Praptank | Student Registration");
        setBounds(100, 100, 400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        educationLabel = new JLabel("Select Education Level:");
        educationLabel.setBounds(29, 49, 142, 14);
        p.add(educationLabel);

        String[] educationLevels = {"Select", "High School", "Intermediate", "Graduation", "Post-Graduation", "P.Hd"};

        educationList = new JComboBox<>(educationLevels);
        educationList.setBounds(181, 46, 143, 20);
        p.add(educationList);

        addEducationButton = new JButton("Add Education");
        addEducationButton.setBounds(176, 102, 120, 23);
        addEducationButton.addActionListener(this);
        p.add(addEducationButton);

        back = new JButton("←");
        back.setForeground(Color.black);
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(this);
        p.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Education_Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new AddressFrame("");
        }

        if (e.getSource() == addEducationButton) {

            educationLevel = (String) educationList.getSelectedItem();

            if (educationLevel.equals("High School")) {
                setBounds(100, 100, 800, 600);
                p.removeAll();
                p.revalidate();
                p.repaint();

                headingLabel = new JLabel(educationLevel);
                headingLabel.setBounds(150, 20, 200, 30);
                headingLabel.setFont(new Font("Courier", Font.BOLD, 12));
                p.add(headingLabel);

                boardLabel = new JLabel("Board:");
                boardLabel.setBounds(30, 60, 150, 20);
                p.add(boardLabel);

                String[] boards = {"Select", "CBSE", "State Board", "ICSE"};

                boardList = new JComboBox<String>(boards);
                boardList.setBounds(180, 60, 200, 20);
                p.add(boardList);

                schoolNameLabel = new JLabel("School Name:");
                schoolNameLabel.setBounds(30, 90, 150, 20);
                p.add(schoolNameLabel);

                schoolNameField = new JTextField();
                schoolNameField.setBounds(180, 90, 200, 20);
                p.add(schoolNameField);

                enrollmentNumberLabel = new JLabel("Enrollment Number:");
                enrollmentNumberLabel.setBounds(30, 120, 150, 20);
                p.add(enrollmentNumberLabel);

                enrollmentNumberField = new JTextField();
                enrollmentNumberField.setBounds(180, 120, 200, 20);
                p.add(enrollmentNumberField);

                percentageLabel = new JLabel("Percentage:");
                percentageLabel.setBounds(30, 150, 150, 20);
                p.add(percentageLabel);

                percentageField = new JTextField();
                percentageField.setBounds(180, 150, 200, 20);
                p.add(percentageField);

                yearOfPassingLabel = new JLabel("Year of Passing:");
                yearOfPassingLabel.setBounds(30, 180, 150, 20);
                p.add(yearOfPassingLabel);

                yearOfPassingField = new JTextField();
                yearOfPassingField.setBounds(180, 180, 200, 20);
                p.add(yearOfPassingField);

                fileLabel = new JLabel("Marksheet:");
                fileLabel.setBounds(30, 210, 150, 20);
                p.add(fileLabel);

                fileButton = new JButton("Choose File");
                fileButton.setBounds(180, 210, 150, 20);
                fileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PDF Images", "jpg", "pdf");
                        fileChooser.setFileFilter(filter);
                        int result = fileChooser.showOpenDialog(fileButton);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String fileName = selectedFile.getName();
                            fileLabel.setText("Marksheet:                           " + fileName);
                            fileLabel.setBounds(30, 210, 350, 20);
                            fileButton.setText("Change File");
                            fileButton.setBounds(400, 210, 150, 20);
                        }
                    }
                });
                p.add(fileButton);

                back2 = new JButton("←");
                back2.setForeground(Color.black);
                back2.setBounds(0, 0, 50, 20);
                back2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Education_Frame();

                    }
                });
                p.add(back2);

                addButton = new JButton("Add");
                addButton.setBounds(150, 260, 100, 20);
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // TODO: Code to save the details to the database goes here
                        String board = (String) boardList.getSelectedItem();
                        String schoolName = schoolNameField.getText();
                        String enrollmentNumber = enrollmentNumberField.getText();
                        String percentage = percentageField.getText();
                        String yearOfPassing = yearOfPassingField.getText();
                        String fileName = fileLabel.getText().replace("Marksheet: ", "");

                        // Use JDBC to save the education details to the database

                        Connection conn = null;
                        PreparedStatement ps = null;
                        conn = ConnectJDBC.getConnection();

                        try {

                            // Create a prepared statement for the SQL insert command
                            String query = "INSERT INTO highschool (Board, SchoolName, Enroll_no, Percentage, year_of_passing) "
                                    + "VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, board);
                            statement.setString(2, schoolName);
                            statement.setString(3, enrollmentNumber);
                            statement.setString(4, percentage);
                            statement.setString(5, yearOfPassing);
//                            statement.setString(6, fileName);

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new education record was inserted successfully!");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        // Clear the input fields
                        boardList.setSelectedIndex(0);
                        schoolNameField.setText("");
                        enrollmentNumberField.setText("");
                        percentageField.setText("");
                        yearOfPassingField.setText("");
                        fileLabel.setText("Marksheet:");

                        p.removeAll();
                        p.revalidate();
                        p.repaint();
                        setBounds(100, 100, 400, 400);

                        successLabel = new JLabel(educationLevel + " details added successfully!");
                        successLabel.setBounds(100, 80, 300, 30);
                        p.add(successLabel);

                        addMoreButton = new JButton("Add More Education");
                        addMoreButton.setBounds(100, 120, 150, 20);
                        addMoreButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new Education_Frame();
                            }
                        });
                        p.add(addMoreButton);

                        completeButton = new JButton("Save and next");
                        completeButton.setBounds(100, 150, 150, 20);
                        completeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);

                                 new StudentLogin();
//                              new StudentReview();
                            }
                        });
                        p.add(completeButton);
                    }
                });
                p.add(addButton);
            } else if (educationLevel.equals("Intermediate")) {
                setBounds(100, 100, 800, 600);
                p.removeAll();
                p.revalidate();
                p.repaint();

                headingLabel = new JLabel(educationLevel);
                headingLabel.setBounds(150, 20, 200, 30);
                p.add(headingLabel);

                boardLabel = new JLabel("Board:");
                boardLabel.setBounds(30, 60, 150, 20);
                p.add(boardLabel);

                String[] boards = {"Select", "CBSE", "State Board", "ICSE"};

                boardList = new JComboBox<String>(boards);
                boardList.setBounds(180, 60, 200, 20);
                p.add(boardList);

                schoolNameLabel = new JLabel("School Name:");
                schoolNameLabel.setBounds(30, 90, 150, 20);
                p.add(schoolNameLabel);

                schoolNameField = new JTextField();
                schoolNameField.setBounds(180, 90, 200, 20);
                p.add(schoolNameField);

                enrollmentNumberLabel = new JLabel("Enrollment Number:");
                enrollmentNumberLabel.setBounds(30, 120, 150, 20);
                p.add(enrollmentNumberLabel);

                enrollmentNumberField = new JTextField();
                enrollmentNumberField.setBounds(180, 120, 200, 20);
                p.add(enrollmentNumberField);

                percentageLabel = new JLabel("Percentage:");
                percentageLabel.setBounds(30, 150, 150, 20);
                p.add(percentageLabel);

                percentageField = new JTextField();
                percentageField.setBounds(180, 150, 200, 20);
                p.add(percentageField);

                yearOfPassingLabel = new JLabel("Year of Passing:");
                yearOfPassingLabel.setBounds(30, 180, 150, 20);
                p.add(yearOfPassingLabel);

                yearOfPassingField = new JTextField();
                yearOfPassingField.setBounds(180, 180, 200, 20);
                p.add(yearOfPassingField);

                fileLabel = new JLabel("Marksheet:");
                fileLabel.setBounds(30, 210, 150, 20);
                p.add(fileLabel);

                fileButton = new JButton("Choose File");
                fileButton.setBounds(180, 210, 150, 20);
                fileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                        fileChooser.setFileFilter(filter);
                        int result = fileChooser.showOpenDialog(fileButton);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String fileName = selectedFile.getName();
                            fileLabel.setText("Marksheet:                           " + fileName);
                            fileLabel.setBounds(30, 210, 350, 20);
                            fileButton.setText("Change File");
                            fileButton.setBounds(400, 210, 150, 20);
                        }
                    }
                });
                p.add(fileButton);

                back2 = new JButton("←");
                back2.setForeground(Color.black);
                back2.setBounds(0, 0, 50, 20);
                back2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Education_Frame();

                    }
                });
                p.add(back2);

                addButton = new JButton("Add");
                addButton.setBounds(150, 260, 100, 20);
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // TODO: Code to save the details to the database goes here
                        String board = (String) boardList.getSelectedItem();
                        String schoolName = schoolNameField.getText();
                        String enrollmentNumber = enrollmentNumberField.getText();
                        String percentage = percentageField.getText();
                        String yearOfPassing = yearOfPassingField.getText();
                        String fileName = fileLabel.getText().replace("Marksheet: ", "");

                        // Use JDBC to save the education details to the database

                        Connection conn = null;
                        PreparedStatement ps = null;
                        conn = ConnectJDBC.getConnection();

                        try {

                            // Create a prepared statement for the SQL insert command
                            String query = "INSERT INTO intermediate (Board, SchoolName, Enroll_no, Percentage, year_of_passing) "
                                    + "VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, board);
                            statement.setString(2, schoolName);
                            statement.setString(3, enrollmentNumber);
                            statement.setString(4, percentage);
                            statement.setString(5, yearOfPassing);
//                            statement.setString(6, fileName);

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new education record was inserted successfully!");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        // Clear the input fields
                        boardList.setSelectedIndex(0);
                        schoolNameField.setText("");
                        enrollmentNumberField.setText("");
                        percentageField.setText("");
                        yearOfPassingField.setText("");
                        fileLabel.setText("Marksheet:");

                        p.removeAll();
                        p.revalidate();
                        p.repaint();
                        setBounds(100, 100, 400, 400);

                        successLabel = new JLabel(educationLevel + " details added successfully!");
                        successLabel.setBounds(100, 80, 300, 30);
                        p.add(successLabel);

                        addMoreButton = new JButton("Add More Education");
                        addMoreButton.setBounds(100, 120, 150, 20);
                        addMoreButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new Education_Frame();
                            }
                        });
                        p.add(addMoreButton);

                        completeButton = new JButton("Save and next");
                        completeButton.setBounds(100, 150, 150, 20);
                        completeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                              new StudentLogin();
//                              new StudentReview();
                            }
                        });
                        p.add(completeButton);
                    }
                });
                p.add(addButton);
            } else if (educationLevel.equals("Graduation")) {
                setBounds(100, 100, 800, 600);
                p.removeAll();
                p.revalidate();
                p.repaint();

                headingLabel = new JLabel(educationLevel);
                headingLabel.setBounds(150, 20, 200, 30);
                p.add(headingLabel);

                UniversityLabel = new JLabel("University:");
                UniversityLabel.setBounds(30, 60, 150, 20);
                p.add(UniversityLabel);

                String[] boards = {"Select", "University of Rajasthan", "Jai Narain Vyas University",
                    "Jaipur National University", "Banasthali Vidyapith", "Amity University",
                    "Rajasthan Technical University", "Manipal University",
                    "Birla Institute of Technology and Science, Pilani", "JECRC University",
                    "Malaviya National Institute of Technology", "IIS University",
                    "Mody University of Science and Technology", "Poornima University"};

                boardList = new JComboBox<String>(boards);
                boardList.setBounds(180, 60, 200, 20);
                p.add(boardList);

                schoolNameLabel = new JLabel("College Name:");
                schoolNameLabel.setBounds(30, 90, 150, 20);
                p.add(schoolNameLabel);

                schoolNameField = new JTextField();
                schoolNameField.setBounds(180, 90, 200, 20);
                p.add(schoolNameField);

                courseNameLabel = new JLabel("Course Name:");
                courseNameLabel.setBounds(30, 120, 150, 20);
                p.add(courseNameLabel);

                String[] courses = {"Select", "Bachelor of Arts (BA)", "Bachelor of Science (BSc)",
                    "Bachelor of Commerce (BCom)", "Bachelor of Engineering (BE)", "Bachelor of Technology (BTech)",
                    "Bachelor of Business Administration (BBA)", "Bachelor of Computer Applications (BCA)",
                    "Bachelor of Architecture (BArch)"};

                courseList = new JComboBox<String>(courses);
                courseList.setBounds(180, 120, 200, 20);
                p.add(courseList);

                SpecificationLabel = new JLabel("Specification:");
                SpecificationLabel.setBounds(30, 150, 150, 20);
                p.add(SpecificationLabel);

                SpecificationField = new JTextField();
                SpecificationField.setBounds(180, 150, 200, 20);
                p.add(SpecificationField);

                enrollmentNumberLabel = new JLabel("Enrollment No.:");
                enrollmentNumberLabel.setBounds(30, 180, 150, 20);
                p.add(enrollmentNumberLabel);

                enrollmentNumberField = new JTextField();
                enrollmentNumberField.setBounds(180, 180, 200, 20);
                p.add(enrollmentNumberField);

                yearOfPassingLabel = new JLabel("Year of Passing:");
                yearOfPassingLabel.setBounds(30, 210, 150, 20);
                p.add(yearOfPassingLabel);

                yearOfPassingField = new JTextField();
                yearOfPassingField.setBounds(180, 210, 200, 20);
                p.add(yearOfPassingField);

                sem1Label = new JLabel("1st Sem:");
                sem1Label.setBounds(30, 240, 150, 20);
                p.add(sem1Label);
                sem1Field = new JTextField();
                sem1Field.setBounds(180, 240, 80, 20);
                p.add(sem1Field);
                sem2Label = new JLabel("2nd Sem:");
                sem2Label.setBounds(350, 240, 150, 20);
                p.add(sem2Label);
                sem2Field = new JTextField();
                sem2Field.setBounds(450, 240, 80, 20);
                p.add(sem2Field);

                sem3Label = new JLabel("3rd Sem:");
                sem3Label.setBounds(30, 270, 150, 20);
                p.add(sem3Label);
                sem3Field = new JTextField();
                sem3Field.setBounds(180, 270, 80, 20);
                p.add(sem3Field);
                sem4Label = new JLabel("4th Sem:");
                sem4Label.setBounds(350, 270, 150, 20);
                p.add(sem4Label);
                sem4Field = new JTextField();
                sem4Field.setBounds(450, 270, 80, 20);
                p.add(sem4Field);

                sem5Label = new JLabel("5th Sem:");
                sem5Label.setBounds(30, 300, 150, 20);
                p.add(sem5Label);
                sem5Field = new JTextField();
                sem5Field.setBounds(180, 300, 80, 20);
                p.add(sem5Field);
                sem6Label = new JLabel("6th Sem:");
                sem6Label.setBounds(350, 300, 150, 20);
                p.add(sem6Label);
                sem6Field = new JTextField();
                sem6Field.setBounds(450, 300, 80, 20);
                p.add(sem6Field);

                sem7Label = new JLabel("7th Sem:");
                sem7Label.setBounds(30, 330, 150, 20);
                p.add(sem7Label);
                sem7Field = new JTextField();
                sem7Field.setBounds(180, 330, 80, 20);
                p.add(sem7Field);
                sem8Label = new JLabel("8th Sem:");
                sem8Label.setBounds(350, 330, 150, 20);
                p.add(sem8Label);
                sem8Field = new JTextField();
                sem8Field.setBounds(450, 330, 80, 20);
                p.add(sem8Field);

                aggLabel = new JLabel("Aggregate CGPA:");
                aggLabel.setBounds(30, 360, 150, 20);
                p.add(aggLabel);
                aggField = new JTextField();
                aggField.setBounds(180, 360, 80, 20);
                p.add(aggField);

                fileLabel = new JLabel("Last Sem Marksheet:");
                fileLabel.setBounds(30, 390, 150, 20);
                p.add(fileLabel);

                fileButton = new JButton("Choose File");
                fileButton.setBounds(180, 390, 150, 20);
                fileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                        fileChooser.setFileFilter(filter);
                        int result = fileChooser.showOpenDialog(fileButton);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String fileName = selectedFile.getName();
                            fileLabel.setText("Last Sem Marksheet:          " + fileName);
                            fileLabel.setBounds(30, 390, 350, 20);
                            fileButton.setText("Change File");
                            fileButton.setBounds(400, 390, 150, 20);
                        }
                    }
                });
                p.add(fileButton);

                back2 = new JButton("←");
                back2.setForeground(Color.black);
                back2.setBounds(0, 0, 50, 20);
                back2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        setVisible(false);
                        new Education_Frame();

                    }
                });
                p.add(back2);

                addButton = new JButton("Add");
                addButton.setBounds(150, 500, 100, 30);
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // TODO: Code to save the details to the database goes here
                        String uni = (String) boardList.getSelectedItem();
                        String collegeName = schoolNameField.getText();
                        String courseName = (String)courseList.getSelectedItem();
                        String specification = SpecificationField.getText();
                        String enrollmentNumber = enrollmentNumberField.getText();
                        String yearOfPassing = yearOfPassingField.getText();
                        String sem1 = sem1Field.getText();
                        String sem2 = sem2Field.getText();
                        String sem3 = sem3Field.getText();
                        String sem4 = sem4Field.getText();
                        String sem5 = sem5Field.getText();
                        String sem6 = sem6Field.getText();
                        String sem7 = sem7Field.getText();
                        String sem8 = sem8Field.getText();
                        String aggregate = aggField.getText();
                        String fileName = fileLabel.getText().replace("Marksheet: ", "");

                        // Use JDBC to save the education details to the database

                        Connection conn = null;
                        PreparedStatement ps = null;
                        conn = ConnectJDBC.getConnection();

                        try {

                            // Create a prepared statement for the SQL insert command
                            String query = "INSERT INTO graduation (University, CollegeName, CourseName, Specification, Enroll_no,year_of_passing,1st_sem,2nd_sem,3rd_sem,4th_sem,5th_sem,6th_sem,7th_sem,8th_sem,Aggregate_CGPA) "
                                    + "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?,?, ?, ?,?, ?, ? )";
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, uni);
                            statement.setString(2, collegeName);
                            statement.setString(3, courseName);
                            statement.setString(4, specification);
                            statement.setString(5, enrollmentNumber);
                            statement.setString(6, yearOfPassing);
                            statement.setString(7, sem1);
                            statement.setString(8, sem2);
                            statement.setString(9, sem3);
                            statement.setString(10, sem4);
                            statement.setString(11, sem5);
                            statement.setString(12, sem6);
                            statement.setString(13, sem7);
                            statement.setString(14, sem8);
                            statement.setString(15, aggregate);
//                          statement.setString(6, fileName);

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new education record was inserted successfully!");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        // Clear the input fields
                        boardList.setSelectedIndex(0);
                        schoolNameField.setText("");
                        courseList.setSelectedIndex(0);
                        enrollmentNumberField.setText("");
                        SpecificationField.setText("");
                        enrollmentNumberField.setText("");
                        yearOfPassingField.setText("");
                        sem1Field.setText("");
                        sem2Field.setText("");
                        sem3Field.setText("");
                        sem4Field.setText("");
                        sem5Field.setText("");
                        sem6Field.setText("");
                        sem7Field.setText("");
                        sem8Field.setText("");
                        aggField.setText("");
                        fileLabel.setText("Marksheet:");

                        p.removeAll();
                        p.revalidate();
                        p.repaint();
                        setBounds(100, 100, 400, 400);

                        successLabel = new JLabel(educationLevel + " details added successfully!");
                        successLabel.setBounds(100, 80, 300, 30);
                        p.add(successLabel);

                        addMoreButton = new JButton("Add More Education");
                        addMoreButton.setBounds(100, 120, 150, 20);
                        addMoreButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new Education_Frame();
                            }
                        });
                        p.add(addMoreButton);

                        completeButton = new JButton("Save and next");
                        completeButton.setBounds(100, 150, 150, 20);
                        completeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                              new StudentLogin();
                              
//                              new StudentReview();
                            }
                        });
                        p.add(completeButton);
                    }
                });
                p.add(addButton);
            } else if (educationLevel.equals("Post-Graduation")) {
                setBounds(100, 100, 800, 600);
                p.removeAll();
                p.revalidate();
                p.repaint();

                headingLabel = new JLabel(educationLevel);
                headingLabel.setBounds(150, 20, 200, 30);
                p.add(headingLabel);

                UniversityLabel = new JLabel("University:");
                UniversityLabel.setBounds(30, 60, 150, 20);
                p.add(UniversityLabel);

                String[] Univ = {"Select", "University of Rajasthan", "Jai Narain Vyas University",
                    "Jaipur National University", "Banasthali Vidyapith", "Amity University",
                    "Rajasthan Technical University", "Manipal University",
                    "Birla Institute of Technology and Science, Pilani", "JECRC University",
                    "Malaviya National Institute of Technology", "IIS University",
                    "Mody University of Science and Technology", "Poornima University"};

                boardList = new JComboBox<String>(Univ);
                boardList.setBounds(180, 60, 200, 20);
                p.add(boardList);

                schoolNameLabel = new JLabel("College Name:");
                schoolNameLabel.setBounds(30, 90, 150, 20);
                p.add(schoolNameLabel);

                schoolNameField = new JTextField();
                schoolNameField.setBounds(180, 90, 200, 20);
                p.add(schoolNameField);

                courseNameLabel = new JLabel("Course Name:");
                courseNameLabel.setBounds(30, 120, 150, 20);
                p.add(courseNameLabel);

                String[] courses = {"Select", "Master of Arts (MA)", "Master of Science (MSc)",
                    "Master of Commerce (MCom)", "Master of Engineering (ME)", "Master of Technology (MTech)",
                    "Master of Business Administration (MBA)", "Master of Computer Applications (MCA)",
                    "Master of Architecture (MArch)", "Master of Dental Surgery (MDS)",
                    "Master of Medicine and Master of Surgery (MD/MS)", "Master of Laws (LLM)",
                    "Master of Social Work (MSW)"};

                courseList = new JComboBox<String>(courses);
                courseList.setBounds(180, 120, 200, 20);
                p.add(courseList);

                SpecificationLabel = new JLabel("Specification:");
                SpecificationLabel.setBounds(30, 150, 150, 20);
                p.add(SpecificationLabel);

                SpecificationField = new JTextField();
                SpecificationField.setBounds(180, 150, 200, 20);
                p.add(SpecificationField);

                enrollmentNumberLabel = new JLabel("Enrollment No.:");
                enrollmentNumberLabel.setBounds(30, 180, 150, 20);
                p.add(enrollmentNumberLabel);

                enrollmentNumberField = new JTextField();
                enrollmentNumberField.setBounds(180, 180, 200, 20);
                p.add(enrollmentNumberField);

                yearOfPassingLabel = new JLabel("Year of Passing:");
                yearOfPassingLabel.setBounds(30, 210, 150, 20);
                p.add(yearOfPassingLabel);

                yearOfPassingField = new JTextField();
                yearOfPassingField.setBounds(180, 210, 200, 20);
                p.add(yearOfPassingField);

                sem1Label = new JLabel("1st Sem:");
                sem1Label.setBounds(30, 240, 150, 20);
                p.add(sem1Label);
                sem1Field = new JTextField();
                sem1Field.setBounds(180, 240, 80, 20);
                p.add(sem1Field);
                sem2Label = new JLabel("2nd Sem:");
                sem2Label.setBounds(350, 240, 150, 20);
                p.add(sem2Label);
                sem2Field = new JTextField();
                sem2Field.setBounds(450, 240, 80, 20);
                p.add(sem2Field);

                sem3Label = new JLabel("3rd Sem:");
                sem3Label.setBounds(30, 270, 150, 20);
                p.add(sem3Label);
                sem3Field = new JTextField();
                sem3Field.setBounds(180, 270, 80, 20);
                p.add(sem3Field);
                sem4Label = new JLabel("4th Sem:");
                sem4Label.setBounds(350, 270, 150, 20);
                p.add(sem4Label);
                sem4Field = new JTextField();
                sem4Field.setBounds(450, 270, 80, 20);
                p.add(sem4Field);

                aggLabel = new JLabel("Aggregate CGPA:");
                aggLabel.setBounds(30, 300, 150, 20);
                p.add(aggLabel);
                aggField = new JTextField();
                aggField.setBounds(180, 300, 80, 20);
                p.add(aggField);

                fileLabel = new JLabel("Last Sem Marksheet:");
                fileLabel.setBounds(30, 330, 150, 20);
                p.add(fileLabel);

                fileButton = new JButton("Choose File");
                fileButton.setBounds(180, 330, 150, 20);
                fileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                        fileChooser.setFileFilter(filter);
                        int result = fileChooser.showOpenDialog(fileButton);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String fileName = selectedFile.getName();
                            fileLabel.setText("Last Sem Marksheet:          " + fileName);
                            fileLabel.setBounds(30, 330, 350, 20);
                            fileButton.setText("Change File");
                            fileButton.setBounds(400, 330, 150, 20);
                        }
                    }
                });
                p.add(fileButton);

                back2 = new JButton("←");
                back2.setForeground(Color.black);
                back2.setBounds(0, 0, 50, 20);
                back2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Education_Frame();

                    }
                });
                p.add(back2);

                addButton = new JButton("Add");
                addButton.setBounds(150, 500, 100, 30);
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // TODO: Code to save the details to the database goes here
                        String uni = (String) boardList.getSelectedItem();
                        String collegeName = schoolNameField.getText();
                        String courseName = (String)courseList.getSelectedItem();
                        String specification = SpecificationField.getText();
                        String enrollmentNumber = enrollmentNumberField.getText();
                        String yearOfPassing = yearOfPassingField.getText();
                        String sem1 = sem1Field.getText();
                        String sem2 = sem2Field.getText();
                        String sem3 = sem3Field.getText();
                        String sem4 = sem4Field.getText();
                        String aggregate = aggField.getText();
                        String fileName = fileLabel.getText().replace("Marksheet: ", "");

                        // Use JDBC to save the education details to the database

                        Connection conn = null;
                        PreparedStatement ps = null;
                        conn = ConnectJDBC.getConnection();

                        try {

                            // Create a prepared statement for the SQL insert command
                            String query = "INSERT INTO post_graduation (University, CollegeName, CourseName, Specification, Enroll_no,year_of_passing,sem1,sem2,sem3,sem4,Aggregate_CGPA) "
                                    + "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?,?, ? )";
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, uni);
                            statement.setString(2, collegeName);
                            statement.setString(3, courseName);
                            statement.setString(4, specification);
                            statement.setString(5, enrollmentNumber);
                            statement.setString(6, yearOfPassing);
                            statement.setString(7, sem1);
                            statement.setString(8, sem2);
                            statement.setString(9, sem3);
                            statement.setString(10, sem4);
                            statement.setString(11, aggregate);
//                          statement.setString(6, fileName);

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new education record was inserted successfully!");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        // Clear the input fields
                        boardList.setSelectedIndex(0);
                        schoolNameField.setText("");
                        courseList.setSelectedIndex(0);
                        SpecificationField.setText("");
                        enrollmentNumberField.setText("");
                        yearOfPassingField.setText("");
                        sem1Field.setText("");
                        sem2Field.setText("");
                        sem3Field.setText("");
                        sem4Field.setText("");
                        aggField.setText("");
                        fileLabel.setText("Marksheet:");

                        p.removeAll();
                        p.revalidate();
                        p.repaint();
                        setBounds(100, 100, 400, 400);

                        successLabel = new JLabel(educationLevel + " details added successfully!");
                        successLabel.setBounds(100, 80, 300, 30);
                        p.add(successLabel);

                        addMoreButton = new JButton("Add More Education");
                        addMoreButton.setBounds(100, 120, 150, 20);
                        addMoreButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new Education_Frame();
                            }
                        });
                        p.add(addMoreButton);

                        completeButton = new JButton("Save and next");
                        completeButton.setBounds(100, 150, 150, 20);
                        completeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new StudentLogin();
//                              new StudentReview();
                            }
                        });
                        p.add(completeButton);
                    }
                });
                p.add(addButton);
            } else if (educationLevel.equals("P.Hd")) {
                setBounds(100, 100, 800, 600);
                p.removeAll();
                p.revalidate();
                p.repaint();

                headingLabel = new JLabel(educationLevel);
                headingLabel.setBounds(150, 20, 200, 30);
                p.add(headingLabel);

                UniversityLabel = new JLabel("University:");
                UniversityLabel.setBounds(30, 60, 150, 20);
                p.add(UniversityLabel);

                String[] Univ = {"Select", "Banasthali Vidyapith", "Central University of Rajasthan", "IIT Jodhpur",
                    "JECRC University", "JNU Jaipur", "Malaviya National Institute of Technology",
                    "Manipal University Jaipur", "Mody University of Science and Technology",
                    "Rajasthan Technical University", "Rajasthan Technical University",
                    "Sardar Patel University of Police, Security and Criminal Justice",
                    "Sir Padampat Singhania University", "University of Kota"};

                boardList = new JComboBox<String>(Univ);
                boardList.setBounds(180, 60, 200, 20);
                p.add(boardList);

                schoolNameLabel = new JLabel("College Name:");
                schoolNameLabel.setBounds(30, 90, 150, 20);
                p.add(schoolNameLabel);

                schoolNameField = new JTextField();
                schoolNameField.setBounds(180, 90, 200, 20);
                p.add(schoolNameField);

                SpecificationLabel = new JLabel("Specification:");
                SpecificationLabel.setBounds(30, 120, 150, 20);
                p.add(SpecificationLabel);

                SpecificationField = new JTextField();
                SpecificationField.setBounds(180, 120, 200, 20);
                p.add(SpecificationField);

                enrollmentNumberLabel = new JLabel("Enrollment No.:");
                enrollmentNumberLabel.setBounds(30, 150, 150, 20);
                p.add(enrollmentNumberLabel);

                enrollmentNumberField = new JTextField();
                enrollmentNumberField.setBounds(180, 150, 200, 20);
                p.add(enrollmentNumberField);

                durationLabel = new JLabel("Course Duration:");
                durationLabel.setBounds(30, 180, 150, 20);
                p.add(durationLabel);

                durationField = new JTextField();
                durationField.setBounds(180, 180, 200, 20);
                p.add(durationField);

                yearOfPassingLabel = new JLabel("Year of Accomplishment:");
                yearOfPassingLabel.setBounds(30, 210, 150, 20);
                p.add(yearOfPassingLabel);

                yearOfPassingField = new JTextField();
                yearOfPassingField.setBounds(180, 210, 200, 20);
                p.add(yearOfPassingField);

                fileLabel = new JLabel("Attach Accomplishment:");
                fileLabel.setBounds(30, 240, 150, 20);
                p.add(fileLabel);

                fileButton = new JButton("Choose File");
                fileButton.setBounds(180, 240, 150, 20);
                fileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                        fileChooser.setFileFilter(filter);
                        int result = fileChooser.showOpenDialog(fileButton);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String fileName = selectedFile.getName();
                            fileLabel.setText("Attach Accomplishment:      " + fileName);
                            fileLabel.setBounds(30, 240, 350, 20);
                            fileButton.setText("Change File");
                            fileButton.setBounds(400, 240, 150, 20);
                        }
                    }
                });
                p.add(fileButton);

                back2 = new JButton("←");
                back2.setForeground(Color.black);
                back2.setBounds(0, 0, 50, 20);
                back2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Education_Frame();

                    }
                });
                p.add(back2);

                addButton = new JButton("Add");
                addButton.setBounds(150, 500, 100, 30);
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        // TODO: Code to save the details to the database goes here
                        String uni = (String) boardList.getSelectedItem();
                        String collegeName = schoolNameField.getText();
                        String specification = SpecificationField.getText();
                        String enrollmentNumber = enrollmentNumberField.getText();
                        String CourseDuration = durationField.getText();
                        String yearOfPassing = yearOfPassingField.getText();
                        String fileName = fileLabel.getText().replace("Marksheet: ", "");

                        // Use JDBC to save the education details to the database

                        Connection conn = null;
                        PreparedStatement ps = null;
                        conn = ConnectJDBC.getConnection();

                        try {

                            // Create a prepared statement for the SQL insert command
                            String query = "INSERT INTO phd (University, CollegeName, Specification, Enroll_no,Course_Duration,Year_of_Accomplishment) "
                                    + "VALUES (?, ?, ?, ?, ?,? )";
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, uni);
                            statement.setString(2, collegeName);
                            statement.setString(3, specification);
                            statement.setString(4, enrollmentNumber);
                            statement.setString(5, CourseDuration);
                             statement.setString(6, yearOfPassing);
//                          statement.setString(6, fileName);

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new education record was inserted successfully!");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        // Clear the input fields
                        boardList.setSelectedIndex(0);
                        schoolNameField.setText("");
                        SpecificationField.setText("");
                        enrollmentNumberField.setText("");
                        durationField.setText("");
                        yearOfPassingField.setText("");
                        fileLabel.setText("Marksheet:");

                        p.removeAll();
                        p.revalidate();
                        p.repaint();
                        setBounds(100, 100, 400, 400);

                        successLabel = new JLabel(educationLevel + " details added successfully!");
                        successLabel.setBounds(100, 80, 300, 30);
                        p.add(successLabel);

                        addMoreButton = new JButton("Add More Education");
                        addMoreButton.setBounds(100, 120, 150, 20);
                        addMoreButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                new Education_Frame();
                            }
                        });
                        p.add(addMoreButton);

                        completeButton = new JButton("Save and next");
                        completeButton.setBounds(100, 150, 150, 20);
                        completeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                
                              new StudentLogin();
//                              new StudentReview();
                            }
                        });
                        p.add(completeButton);
                    }
                });
                p.add(addButton);
            }

        }

    }

}
