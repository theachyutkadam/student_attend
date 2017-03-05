import java.sql.*;
class Fetch {
	public static Connection dell() {
	  String url = "jdbc:mysql://localhost:3306/student_attend";
    String db_user = "root";
    String db_password = "root";
    Connection con = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, db_user, db_password);
    }
    catch(Exception ex) {}
    return(con);
	}
}