package Utils.UserUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conection.Conn;

public class readComand {

	private static Connection con = Conn.getConnection();

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		readComand.con = con;
	}

	public String getPrice(String location) throws SQLException {
		PreparedStatement pr = con.prepareStatement("SELECT price FROM locations WHERE locationname=" + "'"	+ location + "'");
		ResultSet rs = pr.executeQuery();
		Statement statement = getCon().createStatement();
		rs.next();

		return rs.getString(1);
	}
//	public static void main(String[] args) throws SQLException
//	{
//		System.out.println(readComand.getPrice("Bucharest"));
//	}
}
