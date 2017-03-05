import java.util.Scanner;
import java.sql.*;  
class InsertUsers {  
  public static void main(String args[]) {
  	Scanner in = new Scanner(System.in);
    String u = "";
  	String p = "";
    try{  
      Class.forName("com.mysql.jdbc.Driver");  
      Connection con = DriverManager.getConnection(  
 	   "jdbc:mysql://localhost:3306/student_attend","root","root");  
	  //here rk is database name, root is username and password
	    Statement stmt = con.createStatement();
	    System.out.println("Enter username : ");
	    u = in.nextLine();
	    System.out.println("Enter password : ");
	    p = in.nextLine();
	    stmt.executeUpdate("insert into users(username,password) values('" + u +"','" + p +"')");
	   // stmt.executeUpdate("delete from  emp where eid ='rk4'");
	   //stmt.executeUpdate("update emp set ename='sallu bhai' where eid='rk5'");
      con.close();
      System.out.println("Record Inserted Successfully");
    }
      catch(Exception e) {
       System.out.println(e);
     }
  }  
 }  