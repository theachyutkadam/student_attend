import javax.swing.*;  
class Classes
{  
public static void main(String args[])  
    {  
    JFrame teach = new JFrame("Teachers Detail");  
    JLabel lblStandard, lblClass_teacher, lblIntake; 
    JTextField txtStandard, txtClass_teacher, txtIntake;
    JButton btnSubmit, btnCancel;
    
    lblStandard = new JLabel("Enter Teacher Name : ");  
    lblStandard.setBounds(50,50, 200,30); 
    lblClass_teacher =new JLabel("Enter Teacher Subject : ");  
    lblClass_teacher.setBounds(50,100,200,30);  
    lblIntake = new JLabel("Enter Teacher Degree : ");
    lblIntake.setBounds(50,150, 200,30); 
   
    txtStandard = new JTextField("");  
    txtStandard.setBounds(300,50, 200,30);
    txtClass_teacher=new JTextField("");  
    txtClass_teacher.setBounds(300,100, 200,30); 
    txtIntake=new JTextField("");  
    txtIntake.setBounds(300,150,200,30); 
    

    btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(120,350,100,40);
    btnCancel = new JButton("Cancel");
    btnCancel.setBounds(300,350,100,40);
 
    teach.add(lblClass_teacher);
    teach.add(lblStandard);
    teach.add(lblIntake);

    teach.add(txtStandard);
    teach.add(txtClass_teacher);
    teach.add(txtIntake);
    teach.add(btnSubmit);
    teach.add(btnCancel);
    teach.setSize(800,500);  
    teach.setLayout(null);  
    teach.setVisible(true);  
    }  
    }