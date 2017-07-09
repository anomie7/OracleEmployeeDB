package OracleEmployeeDBPrj;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@127.0.0.1:1593:xe";
	
	static public Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "Test", "1234");
		
		return conn;
	}
}
