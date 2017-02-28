import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

class JDBCTest {
  public void connect(String username, String password) {
    String url = "jdbc:mysql://localhost:3306/student_attend";
    String db_user = "root";
    String db_password = "root";
    Connection con;
    Statement stmt;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, db_user, db_password);
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from users");

      while(rs.next()) {
        if(username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
          System.out.println("Your login Successfully");
          break;
        }
        else {
          System.out.println("Failed to login");
        }
        con.close();
      } 
    }
      catch (Exception e) {
      e.printStackTrace();
    }
  }
}