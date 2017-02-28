import javax.swing.*;  
class Students
{  
public static void main(String args[])
    {  
    JFrame studs = new JFrame("Students Detail");  
    JLabel lblStud_rno, lblStud_name, lblStandard, lblMobile_num;  
    JTextField txtStud_rno, txtStud_name,txtStandard, txtMobile_num;
    JButton btnSubmit, btnCancel;


    lblStud_rno = new JLabel("Student Roll_num : ");  
    lblStud_rno.setBounds(50,50,200,30);  
    lblStud_name = new JLabel("Student Name : ");  
    lblStud_name.setBounds(50,100,200,30); 
    lblStandard = new JLabel("Student Standard : ");
    lblStandard.setBounds(50,150,200,30); 
    lblMobile_num = new JLabel("Enter Mobile_num");
    lblStandard.setBounds(50,200,200,30);

    txtStud_rno = new JTextField("Student Roll_num.");  
    txtStud_rno.setBounds(300,50,200,30);
    txtStud_name = new JTextField("Student name");  
    txtStud_name.setBounds(300,100,200,30); 
    txtStandard = new JTextField("Student Standard");  
    txtStandard.setBounds(300,150,200,30); 
    txtMobile_num = new JTextField("Enter Mobile_num");  
    txtMobile_num.setBounds(300,200,200,30); 


    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,250,100,50);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(260,250,100,50);
 
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
    studs.setSize(1200,500);  
    studs.setLayout(null);  
    studs.setVisible(true);  
    }  
    }
