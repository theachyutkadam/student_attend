import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class FrameClasses implements ActionListener {
  JTable table;
  JScrollPane panel;
  JFrame klass = new JFrame("Classes Details");
  JLabel lblStandard, lblClass_teacher, lblIntake;
  JTextField txtStandard, txtClass_teacher, txtIntake;
  JButton btnSubmit, btnCancel;

  FrameClasses() {
    lblStandard = new JLabel("Enter Standart : ");  
    lblStandard.setBounds(50,50, 200,30); 
    lblClass_teacher =new JLabel("Enter Class Teacher : ");  
    lblClass_teacher.setBounds(50,100,200,30);  
    lblIntake = new JLabel("Enter Intake : ");
    lblIntake.setBounds(50,150, 200,30);
   
    txtStandard = new JTextField("");  
    txtStandard.setBounds(300,50, 200,30);
    txtClass_teacher=new JTextField("");  
    txtClass_teacher.setBounds(300,100, 200,30); 
    txtIntake=new JTextField("");
    txtIntake.setBounds(300,150,200,30); 
    

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,200,100,40);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(300,200,100,40);
 
    klass.add(lblClass_teacher);
    klass.add(lblStandard);
    klass.add(lblIntake);

    klass.add(txtStandard);
    klass.add(txtClass_teacher);
    klass.add(txtIntake);
    klass.add(btnSubmit);
    klass.add(btnCancel);
    klass.setSize(800,500);
    klass.setLayout(null); 
    klass.setVisible(true);

    btnSubmit.addActionListener(this);
    btnCancel.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSubmit) {
      String standard = txtStandard.getText();
      String class_teacher = txtClass_teacher.getText();
      String intake = txtIntake.getText();
      int success = InsertClasses.insert_cls(standard,class_teacher,intake);
      if (success == 1){
        JOptionPane.showMessageDialog(klass,"Student Details inserted successfully");
      }
      else{
        JOptionPane.showMessageDialog(klass,"Student Details inserted fails");
      }
      String column[] = {"ID","STANDARD","CLASS_TEACHERS","INTAKE"};
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from classes");
        rs.last();
        Object [][] data = new Object[rs.getRow() - 1][4];
        rs.first();
        int i = 0;
        while (rs.next()) {
          
          data[i][0] = rs.getInt(1);
          data[i][1] = rs.getInt(2);
          data[i][2] = rs.getString(3);
          data[i][3] = rs.getInt(4);
          i++;
        }
        table = new JTable(data,column);
        table.setBounds(30,250,400,200); 
        panel = new JScrollPane(table);
        panel.setBounds(table.getBounds());
        klass.add(panel);
      }
      catch (Exception ea) {
        System.out.println("Exception Occur"+ea);
      }

    }
    else if(e.getSource() == btnCancel) {
      txtStandard.setText("");
      txtClass_teacher.setText("");
      txtIntake.setText("");
    }
  }
}