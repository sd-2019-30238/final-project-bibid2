package Utils.UserUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conection.Conn;

public class WriteComand {
	private static Connection con = Conn.getConnection();
	public void insertComand(String email, String location, String price)
			throws SQLException, ClassNotFoundException {
		PreparedStatement pr = con.prepareStatement("insert into tickets values (?,?,?)");

		pr.setString(1, email);
		pr.setString(2, location);
		pr.setString(3, price);
		pr.executeUpdate();
		pr.close();
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		WriteComand.con = con;
	}
}
