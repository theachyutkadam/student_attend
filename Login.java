import java.sql.*;
class Login {
	public static Boolean check(String username, String password, Connection con) {
 		Boolean login = false;
 		try {
 			Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from users");
	    
			while(rs.next()) {
	      if(username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
	      	login = true;
	        break;
	      }
	      else {
	        login = false;
	      }
	    }
 		}
 		catch(Exception e) {}
    return(login);
	}
}