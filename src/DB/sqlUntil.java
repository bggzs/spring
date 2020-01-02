package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlUntil {
	public static  Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/user";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		String userName="root";
		String userPassword="123456";
		Connection connection=DriverManager.getConnection(url, userName, userPassword);
		return connection;
		
	}
}
