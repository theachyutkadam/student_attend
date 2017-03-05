import java.sql.*;  
class InsertStudents {
  public static int insert_stud(String stud_rno,String stud_name,String std,String m_no) {
    int success = 0;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
      Statement stmt = con.createStatement();
  
      success = stmt.executeUpdate("insert into students(student_rno,student_name,standard,mobile_no) values('" + stud_rno +"','" + stud_name +"','" + std +"','" + m_no + "')");
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