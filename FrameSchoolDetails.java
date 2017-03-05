import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
public class FrameSchoolDetails implements ActionListener {
  JTable table;
  JScrollPane panel;
  JFrame frame, school_details;
  JButton btnLogin, btnCancel, btnSubmit, btnClear;
  JPasswordField value;
  JLabel lblUsername, lblPassword, lblSchool_name, lblSchool_address, lblSchool_pincipal, lblUniversity_code;
  JTextField txtUsername, txtSchool_name, txtSchool_address, txtSchool_principal, txtUniversity_code;
  FrameSchoolDetails() {
    frame = new JFrame("Login Window");
    school_details = new JFrame("School Details");
    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 
    school_details.dispatchEvent(new WindowEvent(school_details, WindowEvent.WINDOW_CLOSING)); 
    

    btnLogin = new JButton("Login");
    btnCancel = new JButton("Cancel");
    value = new JPasswordField("");
    btnSubmit = new JButton("Submit");
    btnClear = new JButton("Cancel");

    lblSchool_name = new JLabel("Enter School Name : ");  
    lblSchool_name.setBounds(50,50,200,30); 
    lblSchool_address =new JLabel("Enter School Address : ");  
    lblSchool_address.setBounds(50,100,200,30);  
    lblSchool_pincipal = new JLabel("Enter School Principal : ");
    lblSchool_pincipal.setBounds(50,150,200,30);
    lblUniversity_code = new JLabel("Enter University Code : ");
    lblUniversity_code.setBounds(50,200,200,30);

    lblUsername = new JLabel("Enter the Username : ");
    lblUsername.setBounds(50,50, 200,30);
    lblPassword = new JLabel("Enter Valid Password : ");
    lblPassword.setBounds(50,100, 200,30);

    txtUsername = new JTextField("achyut");  
    value = new JPasswordField("10203");

    txtSchool_principal = new JTextField("");
    txtSchool_name = new JTextField("");
    txtSchool_address = new JTextField("");  
    txtUniversity_code = new JTextField("");
  
    txtUsername.setBounds(300,50,200,30);  
    value.setBounds(300,100,200,30);  
    txtSchool_principal.setBounds(300,150,200,30);
    txtSchool_name.setBounds(300,50,200,30);
    txtSchool_address.setBounds(300,100,200,30);  
    txtUniversity_code.setBounds(300,200,200,30);

  
    school_details.add(txtSchool_principal);
    school_details.add(txtSchool_name);
    school_details.add(txtSchool_address);
    school_details.add(txtUniversity_code);
   
    frame.add(btnLogin);
    frame.add(btnCancel);
    frame.add(txtUsername);
    frame.add(value);
    frame.add(lblUsername);
    
    frame.add(lblPassword);
    frame.setSize(1200,800);
    frame.setLayout(null);
    frame.setVisible(true);


    btnLogin.setBounds(120,250,100,40);
    btnCancel.setBounds(300,250,100,40);
    btnSubmit.setBounds(120,250,100,30);
    btnClear.setBounds(300,250,100,30);

    school_details.add(btnSubmit);
    school_details.add(btnClear);
    school_details.add(txtUniversity_code);
    school_details.add(txtSchool_name);
    school_details.add(txtSchool_address);
    school_details.add(txtSchool_principal);
    school_details.add(lblUniversity_code);
    school_details.add(lblSchool_pincipal);
    school_details.add(lblSchool_name);
    school_details.add(lblSchool_address);
    school_details.setSize(1200,800);
    school_details.setLayout(null);

    btnLogin.addActionListener(this);
    btnCancel.addActionListener(this);
    btnSubmit.addActionListener(this);
    btnClear.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSubmit) {
      String school_name = txtSchool_name.getText();
      String school_address = txtSchool_address.getText();
      String school_principal = txtSchool_principal.getText();
      String university_code = txtUniversity_code.getText();
      int success = InsertSchoolDetails.insert_sd(school_name,school_address,school_principal,university_code);
      if (success == 1){
        JOptionPane.showMessageDialog(school_details,"School Details inserted successfully");
      }
      else{
        JOptionPane.showMessageDialog(school_details,"School Details inserted fails");
      }
      String column[] = {"ID","SCHOOL NAME","SCHOOL ADDRESS","PRINCIPAL","UNIVERSITY CODE"};
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from school_details");
        rs.last();
        Object [][] data = new Object[rs.getRow() - 1][5];
        rs.first();
        int i = 0;
        while (rs.next()) {
          
          data[i][0] = rs.getInt(1);
          data[i][1] = rs.getString(2);
          data[i][2] = rs.getString(3);
          data[i][3] = rs.getString(4);
          data[i][4] = rs.getInt(5);
          i++;
        }
        table = new JTable(data,column);
        table.setBounds(30,350,400,200); 
        panel = new JScrollPane(table);
        panel.setBounds(table.getBounds());
        school_details.add(panel);
      }
      catch (Exception ea) {
        System.out.println("Exception Occur"+ea);
      }
    }  
    else if(e.getSource() == btnClear) {
      txtSchool_name.setText("");
      txtSchool_address.setText("");
      txtSchool_principal.setText("");
      txtUniversity_code.setText("");
    }
    
    if(e.getSource() == btnLogin){
      String username = txtUsername.getText();
      String password = value.getText();
      Connection con = Fetch.dell();
      Boolean login = Login.check(username, password, con);

      if (login == true){
      	school_details.setVisible(true);
        frame.setVisible(false);
        JOptionPane.showMessageDialog(school_details,"Hello, Welcome to Student Attendance");
      }
      else {
      	JOptionPane.showMessageDialog(frame,"Login Failed.");
      }
	   
    }else if(e.getSource() == btnCancel) {
      txtUsername.setText("");
      value.setText("");
    }
  }
}