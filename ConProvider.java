import java.sql.*;
public class ConProvider {
  public static Connection getConnection() {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/student_attend";
    String db_user = "root";
    String db_password = "root";
    try {
      // Class.forName("oracle.jdbc.driver.OracleDriver");
      // con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, db_user, db_password);
    }
    catch(Exception e) {
      System.out.println(e);
    }
    return con;
  }
}
