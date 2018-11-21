package MakerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public static boolean validateLogin(String  UserName, String Password) {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query =  "select count(*) from LOGIN_DETAILS_DATABASE where UserName='"+  UserName + "' and Password ='"+ Password + "'";
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			if (resultSet.getInt(1) == 0)
			{
				return false;
			} 
			return true;
			
		} catch (Exception e) {
			System.out.println("Error validating in db : " + e);
		}
		return false;
	}

}

