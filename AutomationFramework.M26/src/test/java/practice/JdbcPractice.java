package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcPractice {

	@Test
	public void executeQueryJDBC() throws SQLException {
		
		Driver dref = new Driver();
		
		//Step 1: Register the Driver
		DriverManager.registerDriver(dref);
		
		//Step 2: Get the connection with driver/database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
		
		//Step 3: Issue Create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute any query
		ResultSet result = state.executeQuery("select * from sakilainfo;");
				
		while(result.next()) {
			System.err.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		
		//step 5: close the database
		con.close();
		System.out.println("DB is closed");
	
	}
}
