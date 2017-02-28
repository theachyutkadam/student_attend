import javax.swing.*;  
class Attendance  
{  
public static void main(String args[])  
    {  
    JFrame attend= new JFrame("Attendance Details");  
    JLabel lblStud_rno, lblStud_name, lblClass_teacher;  
    JTextField txtStud_rno, txtStud_name, txtClass_teacher;
    JButton btnSubmit, btnCancel;

    lblStud_rno=new JLabel("Student Roll_num : ");  
    lblStud_rno.setBounds(50,50,200,30);  
    lblStud_name=new JLabel("Student Name : ");  
    lblStud_name.setBounds(50,100, 200,30); 
    lblClass_teacher=new JLabel("Class Teacher Name : ");
    lblClass_teacher.setBounds(50,150, 200,30); 

    txtStud_rno = new JTextField("Student Roll_num.");  
    txtStud_rno.setBounds(300,50, 200,30);
    txtStud_name=new JTextField("Student name");  
    txtStud_name.setBounds(300,100, 200,30); 
    txtClass_teacher=new JTextField("Teacher name");  
    txtClass_teacher.setBounds(300,150, 200,30); 

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,250,100,40);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(260,250,100,40);
 
    attend.add(lblStud_rno);
    attend.add(lblStud_name);
    attend.add(lblClass_teacher);

    attend.add(txtStud_rno);
    attend.add(txtStud_name);
    attend.add(txtClass_teacher);

    attend.add(btnSubmit);
    attend.add(btnCancel);
    attend.setSize(800,500);  
    attend.setLayout(null);  
    attend.setVisible(true);  
    }  
    }
