import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
class FrameAttendance implements ActionListener {
  JTable table;
  JScrollPane panel;
  JFrame attend= new JFrame("Attendance Details");  
  JLabel lblStud_rno, lblStud_name, lblStandard, lblClass_teacher;  
  JTextField txtStud_rno, txtStud_name, txtStandard, txtClass_teacher;
  JButton btnSubmit, btnCancel;
    FrameAttendance() {
      lblStud_rno = new JLabel("Student Roll_num : ");  
      lblStud_rno.setBounds(50,50,200,30);  
      lblStud_name = new JLabel("Student Name : ");  
      lblStud_name.setBounds(50,100,200,30);
      lblStandard = new JLabel("Student Standard : ");
      lblStandard.setBounds(50,150,200,30);
      lblClass_teacher = new JLabel("Class Teacher Name : ");
      lblClass_teacher.setBounds(50,200,200,30); 

      txtStud_rno = new JTextField("");
      txtStud_rno.setBounds(300,50, 200,30);
      txtStud_name = new JTextField("");
      txtStud_name.setBounds(300,100, 200,30);
      txtStandard = new JTextField("");
      txtStandard.setBounds(300,150,200,30);
      txtClass_teacher = new JTextField("");
      txtClass_teacher.setBounds(300,200,200,30);

      btnSubmit = new JButton("Submit");
      btnSubmit.setBounds(120,250,100,30);
      btnCancel = new JButton("Cancel");
      btnCancel.setBounds(260,250,100,30);
   
      attend.add(lblStud_rno);
      attend.add(lblStud_name);
      attend.add(lblStandard);
      attend.add(lblClass_teacher);

      attend.add(txtStud_rno);
      attend.add(txtStud_name);
      attend.add(txtStandard);
      attend.add(txtClass_teacher);

      attend.add(btnSubmit);
      attend.add(btnCancel);
      attend.setSize(800,500);  
      attend.setLayout(null);  
      attend.setVisible(true);

      btnSubmit.addActionListener(this);
      btnCancel.addActionListener(this); 
    }

      
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSubmit) {
      String stud_rno = txtStud_rno.getText();
      String stud_name = txtStud_name.getText();
      String standard = txtStandard.getText();
      String class_teachers = txtClass_teacher.getText();
      int success = InsertAttendance.insert_sdatnd(stud_rno,stud_name,standard,class_teachers);
        
        if (success == 1) {
          JOptionPane.showMessageDialog(attend,"Student Details inserted successfully");
        }
      else{
        JOptionPane.showMessageDialog(attend,"Student Details inserted fails");
      }
      String column[] = {"ID","STUD_RNO","NAME","STANDARD","CLASS_TEACHERS"};
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from attendance");
        rs.last();
        Object [][] data = new Object[rs.getRow() - 1][5];
        rs.first();
        int i = 0;
        while (rs.next()) {
          
          data[i][0] = rs.getInt(1);
          data[i][1] = rs.getInt(2);
          data[i][2] = rs.getString(3);
          data[i][3] = rs.getString(4);
          data[i][4] = rs.getString(5);
          i++;
        }
        table = new JTable(data,column);
        table.setBounds(30,350,400,200); 
        panel = new JScrollPane(table);
        panel.setBounds(table.getBounds());
        attend.add(panel);
      }
      catch (Exception ea) {
        System.out.println("Exception Occur"+ea);
      }
    }
    
    else if(e.getSource() == btnCancel) {
      txtStandard.setText("");
      txtStud_name.setText("");
      txtStud_rno.setText("");
      txtClass_teacher.setText("");
    }
  }
}
