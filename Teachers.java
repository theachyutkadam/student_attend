import javax.swing.*;  
class Teachers  
{  
public static void main(String args[])  
    {  
    JFrame teach = new JFrame("Teachers Detail");  
    JLabel lblTeach_name, lblTeach_subject, lblDegree, lblMobile_no,lblGender; 
    JTextField txtTeach_name, txtTeach_subject, txtDegree, txtMobile_no;
    JButton btnSubmit, btnCancel;
    JRadioButton rbMale, rbFemale, rbTrance_gender;

    
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
    rbTrance_gender = new JRadioButton("Trance_gender");
    rbTrance_gender.setBounds(500,250,200,30);

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,350,100,40);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(300,350,100,40);
 
    teach.add(lblTeach_subject);
    teach.add(lblTeach_name);
    teach.add(lblDegree);
    teach.add(lblMobile_no);
    teach.add(lblGender);

    teach.add(txtTeach_name);
    teach.add(txtTeach_subject);
    teach.add(txtDegree);
    teach.add(txtMobile_no);
    teach.add(rbMale);
    teach.add(rbFemale);
    teach.add(rbTrance_gender);
    teach.add(btnSubmit);
    teach.add(btnCancel);
    teach.setSize(800,500);  
    teach.setLayout(null);  
    teach.setVisible(true);  
    }  
    }