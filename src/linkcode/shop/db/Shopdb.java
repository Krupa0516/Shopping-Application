package linkcode.shop.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	public class Shopdb {
		public static Connection getConnection(){
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			  catch (SQLException e)
			{
				  e.printStackTrace();
			}
			return con;
		}
	}


