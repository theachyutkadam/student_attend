import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
public class FrameStudents implements ActionListener {
  JTable table;
  JScrollPane panel;
  JFrame studs = new JFrame("Students Detail");
  JLabel lblStud_rno, lblStud_name, lblStandard, lblMobile_num;
  JTextField txtStud_rno, txtStud_name,txtStandard, txtMobile_num;
  JButton btnSubmit, btnCancel;  

  FrameStudents() {
    studs.dispatchEvent(new WindowEvent(studs, WindowEvent.WINDOW_CLOSING));

    lblStud_rno = new JLabel("Student Roll_num : "); 
    lblStud_rno.setBounds(50,50,200,30);

    lblStud_name = new JLabel("Student Name : ");
    lblStud_name.setBounds(50,100,200,30);

    lblStandard = new JLabel("Student Standard : ");
    lblStandard.setBounds(50,150,200,30);

    lblMobile_num = new JLabel("Enter Mobile_num");
    lblMobile_num.setBounds(50,200,200,30);

    txtStud_rno = new JTextField("Student Roll_num.");
    txtStud_rno.setBounds(300,50,200,30);
    txtStud_name = new JTextField("Student name");
    txtStud_name.setBounds(300,100,200,30);
    txtStandard = new JTextField("Student Standard");
    txtStandard.setBounds(300,150,200,30);
    txtMobile_num = new JTextField("Enter Mobile_num");
    txtMobile_num.setBounds(300,200,200,30); 

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,250,100,30);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(260,250,100,30);
    
    studs.add(lblStud_rno);
    studs.add(lblStud_name);
    studs.add(lblStandard);
    studs.add(lblMobile_num);

    studs.add(txtStud_rno);
    studs.add(txtStud_name);
    studs.add(txtStandard);
    studs.add(txtMobile_num);
    studs.add(btnSubmit);
    studs.add(btnCancel);
    studs.setSize(1200,1000);
    studs.setLayout(null);
    studs.setVisible(true);

    btnCancel.addActionListener(this);
    btnSubmit.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSubmit) {
      String stud_rno = txtStud_rno.getText();
      String stud_name = txtStud_name.getText();
      String standard = txtStandard.getText();
      String m_no = txtMobile_num.getText();
      int success = InsertStudents.insert_stud(stud_rno,stud_name,standard,m_no);
      if (success == 1){
        JOptionPane.showMessageDialog(studs,"Student Details inserted successfully");
      }
      else{
        JOptionPane.showMessageDialog(studs,"Student Details inserted fails");
      }
      
      String column[] = {"ID","STUD_RNO","NAME","STANDARD","MOB_NUM"};
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from students");
        rs.last();
        Object [][] data = new Object[rs.getRow() - 1][5];
        rs.first();
        int i = 0;
        while (rs.next()) {
          
          data[i][0] = rs.getInt(1);
          data[i][1] = rs.getInt(2);
          data[i][2] = rs.getString(3);
          data[i][3] = rs.getString(4);
          data[i][4] = rs.getInt(5);
          i++;
        }
        table = new JTable(data,column);
        table.setBounds(30,350,400,200); 
        panel = new JScrollPane(table);
        panel.setBounds(table.getBounds());
        studs.add(panel);
      }
      catch (Exception ea) {
        System.out.println("Exception Occur"+ea);
      }
    }
    else if(e.getSource() == btnCancel) {
      txtStandard.setText("");
      txtStud_name.setText("");
      txtStud_rno.setText("");
      txtMobile_num.setText("");
    }
  }
}


