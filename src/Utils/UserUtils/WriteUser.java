package Utils.UserUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conection.Conn;

public class WriteUser {

	private static Connection con = Conn.getConnection();
	public void insertUser(String email, String firstName, String lastName, String parola, String role)
			throws SQLException, ClassNotFoundException {
		PreparedStatement pr = con.prepareStatement("insert into users values (?,?,?,?,?)");

		pr.setString(1, email);
		pr.setString(2, firstName);
		pr.setString(3, lastName);
		pr.setString(4, parola);
		pr.setString(5, role);
		pr.executeUpdate();
		System.out.println("user inserted");
		pr.close();
	}
	public int total(String username) throws SQLException {
		int total =0;
		PreparedStatement pr = con.prepareStatement("SELECT price FROM tickets WHERE username=" + "'"	+ username + "'");
		ResultSet rs = pr.executeQuery();
		Statement statement = getCon().createStatement();
		while(rs.next()) {
			 total += Integer.parseInt(rs.getString(1));
		}

		return total;
	}
//	public static void main(String[] args) throws SQLException
//	{
//		System.out.println(WriteUser.total("czaada@gmail.com"));
//	}
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		WriteUser.con = con;
	}
}
