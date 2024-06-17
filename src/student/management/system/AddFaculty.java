package student.management.system;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.*;
public class AddFaculty extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfemail,tfmarkx10,tfmarkx12,tfphone,tfadhr;
    JLabel LabelEmpId;
    JDateChooser dcdob;
    JComboBox cbdepartment;
    JButton submit,cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddFaculty(){
        setSize(900,600);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Faculty Registration");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //Name of Student.............
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //Name of Student's Father...............
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //Students Roll No..........
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50,200,150,30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);
        LabelEmpId = new JLabel(first4 + "02022");
        LabelEmpId.setBounds(200,200,150,30);
        LabelEmpId.setFont(new Font("serif",Font.BOLD,20));
        add(LabelEmpId);
        
        //Student's Date of Birthday
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,100,30);
        add(dcdob);
        
        //Address.............
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,100,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //Email...............
        JLabel Email = new JLabel("Email");
        Email.setBounds(400,250,100,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        add(Email);
        tfemail = new JTextField();
        tfemail.setBounds(600,250,150,30);
        add(tfemail);
        
        //Class X Markx............
        JLabel lblmarkx10 = new JLabel("Class X(%)");
        lblmarkx10.setBounds(50,300,100,30);
        lblmarkx10.setFont(new Font("serif",Font.BOLD,20));
        add(lblmarkx10);
        tfmarkx10 = new JTextField();
        tfmarkx10.setBounds(200,300,150,30);
        add(tfmarkx10);
        
        //Phone NO................
        JLabel phone = new JLabel("Contact No.");
        phone.setBounds(400,300,100,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);
        tfphone = new JTextField();
        tfphone.setBounds(600,300,150,30);
        add(tfphone);
        
        //Class X Markx............
        JLabel lblmarkx12 = new JLabel("Class XII(%)");
        lblmarkx12.setBounds(50,350,100,30);
        lblmarkx12.setFont(new Font("serif",Font.BOLD,20));
        add(lblmarkx12);
        tfmarkx12 = new JTextField();
        tfmarkx12.setBounds(200,350,150,30);
        add(tfmarkx12);
        
        //adhaar
        JLabel lbladhr = new JLabel("Adhaar: ");
        lbladhr.setBounds(400,350,100,30);
        lbladhr.setFont(new Font("serif",Font.BOLD,20));
        add(lbladhr);
        tfadhr = new JTextField();
        tfadhr.setBounds(600,350,150,30);
        add(tfadhr);
        
        //Course Selection
        JLabel lbldpt = new JLabel("Department");
        lbldpt.setBounds(50,400,120,30);
        lbldpt.setFont(new Font("serif",Font.BOLD,20));
        add(lbldpt);
        String course[] = {"Choose","B.Tech","BCA","BBA","MCA","Bsc","Msc","LLB","ITI"};
        cbdepartment = new JComboBox(course);
        cbdepartment.setBounds(200,400,150,30);
        add(cbdepartment);  
        
        submit = new JButton("Submit");
        submit.setBounds(250,480,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400,480,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = LabelEmpId.getText();
            String dob =((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfmarkx10.getText();
            String xii = tfmarkx12.getText();
            String aadhar = tfadhr.getText();
            String course = (String)cbdepartment.getSelectedItem();
            
            try{
                String query = "insert into faculty values('"+name+"' , '"+fname+"' , '"+empId+"' , '"+dob+"' , '"+address+"' , '"+phone+"' , '"+email+"' , '"+x+"' , '"+xii+"' , '"+aadhar+"' , '"+course+"')";
            
                conn con = new conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Faculty Information Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddFaculty();
    }
}
