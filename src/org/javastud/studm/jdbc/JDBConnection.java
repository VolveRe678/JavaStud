package org.javastud.studm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. Register driver.
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. Create Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncitdb", "root", "");
		
		//3. Create Statement
		Statement stat = conn.createStatement();
		
		//4. Execute query and fetch record.
		ResultSet rs = stat.executeQuery("SELECT * FROM user");
		while(rs.next()){
			//rs = one row of database
			long id = rs.getLong("id");
			String user = rs.getString("username");
			String pass = rs.getString("password");
			System.out.println(id + "\t" + user + "\t" + pass);
		}
		
	}
}