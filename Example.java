import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
public class Example implements ActionListener {
	JFrame frame,frame2;
	JButton btnLogin, btnCancel, btnSubmit, btnClear;
	JTextField txtUsername, txtPassword,txtSchool_name, txtSchool_principal;
	Example() {
		frame = new JFrame();
		frame2 = new JFrame();

		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 
		frame2.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 

		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

		btnSubmit = new JButton("Submit");
		btnClear = new JButton("Cancel");

	  txtUsername = new JTextField("Username");  
	  txtPassword = new JTextField("Password");  
	  txtSchool_principal = new JTextField("s");  
	  txtSchool_name = new JTextField("");
	 
	  txtUsername.setBounds(10,10,210,30);  
	  txtPassword.setBounds(10,50,210,30);  
	  txtSchool_principal.setBounds(10,10,210,30);  
	  txtSchool_name.setBounds(10,50,210,30);  
	  frame.add(txtUsername);
	  frame.add(txtPassword);
	  frame2.add(txtSchool_principal);
	  frame2.add(txtSchool_name);

	  btnLogin.setBounds(10,90,100,30);
		btnCancel.setBounds(120,90,100,30);
		frame.add(btnLogin);
		frame.add(btnCancel);
		frame.setSize(1200,800);
		frame.setLayout(null);
		frame.setVisible(true);

		btnSubmit.setBounds(50,130,100,30);
		btnClear.setBounds(180,130,100,30);
		frame2.add(btnSubmit);
		frame2.add(btnClear);
		frame2.setSize(1200,800);
		frame2.setLayout(null);
		

		btnLogin.addActionListener(this);  
    btnCancel.addActionListener(this);  
	  btnSubmit.addActionListener(this);  
    btnClear.addActionListener(this);


	}
		

	public void actionPerformed(ActionEvent e) {  
    
    if(e.getSource() == btnLogin){  
    	JOptionPane.showMessageDialog(frame2,"Hello, Welcome to Javatpoint.");
      String username = txtUsername.getText();
      String password = txtPassword.getText();

   
      	JDBCTest db = new JDBCTest();
	    	db.connect(username, password);

	    frame2.setVisible(true);
	    frame.setVisible(false);
    }else if(e.getSource() == btnCancel){  
      txtUsername.setText("");
      txtPassword.setText("");
    }  
  }
}