package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton cancel, login;
    JTextField tfusername;
    JTextField tfpassword;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //username text
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 30, 100, 30);
        add(lblusername);
        //username textBox
        tfusername = new JTextField();
        tfusername.setBounds(150, 30, 200, 30);
        add(tfusername);

        //password text
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 90, 200, 30);
        add(lblpassword);
        //password textBox
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 90, 200, 30);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(100, 150, 80, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 150, 80, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username = '" + username + "'and password ='" + password + "'";

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password \n Try with correct information");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
