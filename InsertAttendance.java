import java.sql.*;  
class InsertAttendance {
  public static int insert_sdatnd(String stud_rno,String stud_name,String standard,String class_teachers) {
    int success = 0;
    
     try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
      Statement stmt = con.createStatement();
      success = stmt.executeUpdate("insert into attendance(student_rno,student_name,standard,class_teachers) values('" + stud_rno +"','" + stud_name + "','" + standard +"','" + class_teachers + "')");
      
      con.close();

    }
    catch(Exception e) {
     System.out.println(e);
    }
      return success;
  }  
}