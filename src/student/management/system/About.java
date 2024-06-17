package student.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 10, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>Student<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Developed By: Adit Sharma");
        name.setBounds(150, 220, 650, 100);
        name.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(name);
        
        JLabel rollno = new JLabel("Roll No. 12217702022");
        rollno.setBounds(150, 290, 550, 70);
        rollno.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(rollno);
        
        JLabel contact = new JLabel("Contact: aditkumarsharma2004@gmail.com");
        contact.setBounds(150, 350, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
        
        setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}