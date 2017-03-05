import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class FrameTeachers implements ActionListener {
  JTable table;
  JScrollPane panel;
  JFrame teach = new JFrame("Teachers Detail");
  JLabel lblTeach_name, lblTeach_subject, lblDegree, lblMobile_no,lblGender;
  JTextField txtTeach_name, txtTeach_subject, txtDegree, txtMobile_no;
  JButton btnSubmit, btnCancel;
  JRadioButton rbMale, rbFemale, rbTrance_gender;
  ButtonGroup gender_group;

  FrameTeachers() {
    lblTeach_name = new JLabel("Enter Teacher Name : ");
    lblTeach_name.setBounds(50,50, 200,30);
    lblTeach_subject =new JLabel("Enter Teacher Subject : ");
    lblTeach_subject.setBounds(50,100,200,30);
    lblDegree = new JLabel("Enter Teacher Degree : ");
    lblDegree.setBounds(50,150, 200,30);
    lblMobile_no = new JLabel("Enter Teacher Mobile_no : ");
    lblMobile_no.setBounds(50,200, 200,30);
    lblGender = new JLabel("Select Gender : ");
    lblGender.setBounds(50,250, 200,30);

    txtTeach_name = new JTextField("");
    txtTeach_name.setBounds(300,50, 200,30);
    txtTeach_subject=new JTextField("");
    txtTeach_subject.setBounds(300,100, 200,30);
    txtDegree=new JTextField("");
    txtDegree.setBounds(300,150,200,30);
    txtMobile_no=new JTextField("");
    txtMobile_no.setBounds(300,200,200,30);

    rbMale = new JRadioButton("Male");
    rbMale.setBounds(300,250,100,30);
    rbFemale = new JRadioButton("Female");
    rbFemale.setBounds(400,250,100,30);
    rbTrance_gender = new JRadioButton("Trance");
    rbTrance_gender.setBounds(500,250,200,30);
    gender_group = new ButtonGroup();

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,300,100,30);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(300,300,100,30);

    teach.add(lblTeach_subject);
    teach.add(lblTeach_name);
    teach.add(lblDegree);
    teach.add(lblMobile_no);
    teach.add(lblGender);

    teach.add(txtTeach_name);
    teach.add(txtTeach_subject);
    teach.add(txtDegree);
    teach.add(txtMobile_no);

    gender_group.add(rbMale);
    gender_group.add(rbFemale);
    gender_group.add(rbTrance_gender);
    teach.add(rbMale);
    teach.add(rbFemale);
    teach.add(rbTrance_gender);

    teach.add(btnSubmit);
    teach.add(btnCancel);
    teach.setSize(800,500);
    teach.setLayout(null); 
    teach.setVisible(true);
    btnCancel.addActionListener(this);
    btnSubmit.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSubmit) {
      String gender = null;
      if (rbMale.isSelected()){
        gender = "Male";
      }else if (rbFemale.isSelected()){
        gender = "Female";
      }else if(rbTrance_gender.isSelected()) {
        gender = "Trance";
      }else {
        JOptionPane.showMessageDialog(teach,"Select Gender");
      }
      if (gender != null) {
        String teach_name = txtTeach_name.getText();
        String teach_sub = txtTeach_subject.getText();
        String degree = txtDegree.getText();
        String mob_no = txtMobile_no.getText();
        int success = InsertTeachers.insert_teach(teach_name, teach_sub, degree, gender, mob_no);
        
        if (success == 1){
          JOptionPane.showMessageDialog(teach,"Student Details inserted successfully");
        }
        else{
          JOptionPane.showMessageDialog(teach,"Student Details inserted fails");
        }
        String column[] = {"ID","TEACHER NAME","SUBJECT","DEGREE","MOBILE_NO","GENDER"};
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from teachers");
        rs.last();
        Object [][] data = new Object[rs.getRow() - 1][6];
        rs.first();
        int i = 0;
        while (rs.next()) {
          
          data[i][0] = rs.getInt(1);
          data[i][1] = rs.getString(2);
          data[i][2] = rs.getString(3);
          data[i][3] = rs.getString(4);
          data[i][4] = rs.getInt(5);
          data[i][5] = rs.getString(6);
          i++;
        }
        table = new JTable(data,column);
        table.setBounds(30,350,400,200); 
        panel = new JScrollPane(table);
        panel.setBounds(table.getBounds());
        teach.add(panel);
      }
      catch (Exception ea) {
        System.out.println("Exception Occur"+ea);
      }
      }
    }
    else if(e.getSource() == btnCancel) {
      txtTeach_name.setText("");
      txtTeach_subject.setText("");
      txtDegree.setText("");
      txtMobile_no.setText("");
    }
  }
}  
