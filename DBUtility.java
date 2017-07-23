package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
public static Connection getConnections(){
	String url="jdbc:mysql://localhost:3307/project";
	String username="root";
	String password="root";
	Connection conn=null;
	//System.out.println("l");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("k");
		//System.out.println("driver registered");
		conn=DriverManager.getConnection(url,username,password);
		//System.out.println("connected");
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return conn;
}}
