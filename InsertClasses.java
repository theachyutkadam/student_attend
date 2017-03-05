import java.sql.*;  
class InsertClasses {
  public static int insert_cls(String standard,String class_teacher,String intake) {
    int success = 0;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
      Statement stmt = con.createStatement();
      success = stmt.executeUpdate("insert into classes(standard,class_teacher,intake) values('" + standard +"','" + class_teacher +"','" + intake +"')");
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