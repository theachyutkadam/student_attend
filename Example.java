import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
public class Example implements ActionListener {
	JFrame frame;
	JButton btnLogin, btnCancel;
	JTextField txtUsername, txtPassword;
	Example() {
		frame = new JFrame();

		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 

		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

	  txtUsername = new JTextField("Username");  
	  txtPassword = new JTextField("Password");  
	  
	  txtUsername.setBounds(10,10,210,30);  
	  txtPassword.setBounds(10,50,210,30);  
	  frame.add(txtUsername);
	  frame.add(txtPassword);

	  btnLogin.setBounds(10,90,100,30);
		btnCancel.setBounds(120,90,100,30);
		frame.add(btnLogin);
		frame.add(btnCancel);
		frame.setSize(1200,800);
		frame.setLayout(null);
		frame.setVisible(true);

		btnLogin.addActionListener(this);  
    btnCancel.addActionListener(this);  
	}
		

	public void actionPerformed(ActionEvent e) {  
    
    if(e.getSource() == btnLogin){  
      String username = txtUsername.getText();
      String password = txtPassword.getText();

      JDBCTest db = new JDBCTest();
	    db.connect(username, password);

    }else if(e.getSource() == btnCancel){  
      txtUsername.setText("");
      txtPassword.setText("");
    }  
  }
}