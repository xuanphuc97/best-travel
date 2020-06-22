package best_travel;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataBase {
	public static Connection conn;
	static Statement sm;

	public static boolean DataConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true";
			conn = DriverManager.getConnection(url);

			if (conn != null)
				return true;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void createDataBase() throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("CREATE DATABASE BestTravel");
				sm.execute("USE BestTravel");
				sm.execute("CREATE TABLE History(id int PRIMARY KEY, time date, list varchar(8000), k int, t int, output int)");
			} catch (Exception e) {}
		}
	}
	
	public static void addHistory(int id, String time, String list, int k, int t, int ouput) throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				String query = String.format("INSERT INTO History VALUES(%d, %s, %s, %d, %d, %d)", id, time, list, k, t, ouput); 
				sm.execute(query); 
			} catch (Exception e) {}
		}
	}
	public static void delHistory(int id) throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				String query = String.format("DELETE FROM History WHERE id = %d",id);
				sm.execute(query); 
			} catch (Exception e) {}
		}
	}
	public static void delAllHistory() throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				sm.execute("DROP TABLE History");
				sm.execute("CREATE TABLE History(id int PRIMARY KEY, time date, list varchar(8000), k int, t int, output int)");
			} catch (Exception e) {}
		}
	}
	
	public static ResultSet getAllHistory() throws SQLException {
		ResultSet rs = null;
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				 sm.execute("USE BestTravel");
				 rs= sm.executeQuery("SELECT * FROM History");
			} catch (Exception e) {}
		}
		
		return rs;
	}
	
	public static String[] getList() throws SQLException {
		List<String> list = new ArrayList<String>();
		String[] res;
		ResultSet rs = null;
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				 rs = sm.executeQuery("SELECT History.list FROM History");
			} catch (Exception e) {}
		}
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		res = list.toArray(new String[0]);
		return res;
	}
	public static void main(String[] args) throws SQLException {
		delAllHistory();
		
	}
}
