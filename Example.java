import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
public class Example implements ActionListener {
	JFrame frame, school_details;
	JButton btnLogin, btnCancel, btnSubmit, btnClear;
	JLabel lblUsername, lblPassword, lblSchool_name, lblSchool_address, lblSchool_pincipal, lblUniversity_code;
	JTextField txtUsername, txtPassword,txtSchool_name, txtSchool_address, txtSchool_principal, txtUniversity_code;
	Example() {
		frame = new JFrame();
		school_details = new JFrame();
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 
		school_details.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 

		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

		btnSubmit = new JButton("Submit");
		btnClear = new JButton("Cancel");

		lblSchool_name = new JLabel("Enter Teacher Name : ");  
    lblSchool_name.setBounds(50,50,200,30); 
    lblSchool_address =new JLabel("Enter Teacher Subject : ");  
    lblSchool_address.setBounds(50,100,200,30);  
    lblSchool_pincipal = new JLabel("Enter Teacher Degree : ");
    lblSchool_pincipal.setBounds(50,150,200,30);
    lblUniversity_code = new JLabel("Enter Teacher Degree : ");
    lblUniversity_code.setBounds(50,200,200,30);

    lblUsername = new JLabel("Enter the Username : ");
    lblUsername.setBounds(50,50, 200,30);
    lblPassword = new JLabel("Enter Valid Password : ");
    lblPassword.setBounds(50,100, 200,30);

	  txtUsername = new JTextField("Username");  
	  txtPassword = new JTextField("Password");
	  txtSchool_principal = new JTextField("");
	  txtSchool_name = new JTextField("");
	  txtSchool_address = new JTextField("");  
	  txtUniversity_code = new JTextField("");
	
	  txtUsername.setBounds(300,50,200,30);  
	  txtPassword.setBounds(300,100,200,30);  
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
	  frame.add(txtPassword);
	  frame.add(lblUsername);
	  frame.add(lblPassword);
		frame.setSize(1200,800);
		frame.setLayout(null);
		frame.setVisible(true);

 		btnLogin.setBounds(120,250,100,40);
		btnCancel.setBounds(300,250,100,40);
		btnSubmit.setBounds(120,350,100,40);
		btnClear.setBounds(300,350,100,40);

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
    
    if(e.getSource() == btnLogin){  
    	JOptionPane.showMessageDialog(school_details,"Hello, Welcome to Javatpoint.");
      String username = txtUsername.getText();
      String password = txtPassword.getText();

   
      	JDBCTest db = new JDBCTest();
	    	db.connect(username, password);

	    school_details.setVisible(true);
	    frame.setVisible(false);
    }else if(e.getSource() == btnCancel){  
      txtUsername.setText("");
      txtPassword.setText("");
    }  
  }
}