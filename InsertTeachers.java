import java.util.Scanner;
import java.sql.*;  
class InsertTeachers {
  public static int insert_teach(String teach_name,String teach_sub,String degree,String gender_group,String mob_no) {
    int success = 0;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
      Statement stmt = con.createStatement();
      success = stmt.executeUpdate("insert into teachers(teacher_name,subject,degree,mobile_no,gender) values('" + teach_name +"','" + teach_sub +"','" + degree +"','" + mob_no + "','" + gender_group + "')");
    //stmt.executeUpdate("delete from  emp where eid ='rk4'");
    //stmt.executeUpdate("update emp set ename='sallu bhai' where eid='rk5'");
      con.close();
    }
    catch(Exception e) {
    System.out.println(e);
    }
    return success;
  }  
}