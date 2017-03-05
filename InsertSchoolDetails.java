import java.sql.*;  
class InsertSchoolDetails {
  public static int insert_sd(String school_name,String school_address,String school_principal,String university_code) {
    int success = 0;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attend","root","root");
      Statement stmt = con.createStatement();
      
      success = stmt.executeUpdate("insert into school_details(school_name,School_address,school_principal,university_code) values('" + school_name +"','" + school_address +"','" + school_principal +"','" + university_code + "')");
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