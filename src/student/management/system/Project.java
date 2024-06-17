package student.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1930, 1080);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/vips.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        //Menu bar Declaration
        JMenuBar mb = new JMenuBar();

        //New Registration of Student and Faculty
        JMenu newInformation = new JMenu("New Registration");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);
        //List item under new Info -- New Faculty
        JMenuItem newFaculty = new JMenuItem("New Faculty Registration");
        newFaculty.setBackground(Color.white);
        newFaculty.addActionListener(this);
        newInformation.add(newFaculty);
        //List item under new Info -- New Student
        JMenuItem newStudent = new JMenuItem("New Student Registration");
        newStudent.setBackground(Color.white);
        newStudent.addActionListener(this);
        newInformation.add(newStudent);

        //Details of Faculty and Students
        JMenu details = new JMenu("Details");
        details.setForeground(Color.red);
        mb.add(details);
        //List item under Details
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //Leave apply
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);
        //List item under Details
        JMenuItem FacultyLeave = new JMenuItem("Faculty Leave");
        FacultyLeave.setBackground(Color.WHITE);
        FacultyLeave.addActionListener(this);
        leave.add(FacultyLeave);

        JMenuItem StudentLeave = new JMenuItem("Student Leave");
        StudentLeave.setBackground(Color.WHITE);
        StudentLeave.addActionListener(this);
        leave.add(StudentLeave);

        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.red);
        mb.add(leaveDetails);
        //List item under Details
        JMenuItem facultyLeaveDetails = new JMenuItem("View Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("View Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Examination Details
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.blue);
        mb.add(exam);
        //List item under Details
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        JMenuItem viewMarks = new JMenuItem("View Results");
        viewMarks.setBackground(Color.WHITE);
        exam.add(viewMarks);

        //Update Info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);
        //List item under Details
        JMenuItem updateFacultyIfno = new JMenuItem("Update Faculty Details");
        updateFacultyIfno.setBackground(Color.WHITE);
        updateInfo.add(updateFacultyIfno);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateInfo.add(updateStudentInfo);

        // fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenu about = new JMenu("About");
        about.setForeground(Color.RED);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About Us");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        

        //Utility Window
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        mb.add(utility);
        //List item under Details
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        //Exit Window
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);
        //List item under Details
        JMenuItem ex = new JMenuItem("Exit Window");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit Window")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("New Student Registration")) {
            new AddStudent();
        } else if (msg.equals("New Faculty Registration")) {
            new AddFaculty();
        } else if (msg.equals("View Faculty Details")) {
            new FacultyDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new FacultyLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("View Faculty Leave Details")) {
            new FacultyLeaveDetails();
        } else if (msg.equals("View Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("View Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About Us")) {
            new About();
        } 
    }

    public static void main(String[] args) {
        new Project();
    }
}
