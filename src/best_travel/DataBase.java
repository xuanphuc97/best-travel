package best_travel;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
				sm.execute(
						"CREATE TABLE History(id INT IDENTITY(1,1) PRIMARY KEY , time datetime , list varchar(8000), k int, t int, output varchar(20), flag bit)");
			} catch (Exception e) {
			}
		}
	}

	public static void addHistory(String time, String list, int k, int t, String ouput) throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				String query = String.format(
						"INSERT INTO History (time, list, k, t, output, flag) VALUES( '%s', '%s', %d, %d, '%s', %d)", time, list,
						k, t, ouput, 0);
				sm.execute(query);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	public static void delHistory(int id) throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				String query = String.format("UPDATE History SET flag = 1 WHERE id = %d", id);
				sm.execute(query);
			} catch (Exception e) {
			}
		}
	}

	public static void delAllHistory() throws SQLException {
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				sm.execute("UPDATE History SET flag = 1 WHERE flag = 0");
			} catch (Exception e) {
			}
		}
	}

	public static ResultSet getAllHistory() throws SQLException {
		ResultSet rs = null;
		if (DataConnection()) {
			sm = conn.createStatement();
			try {
				sm.execute("USE BestTravel");
				rs = sm.executeQuery("SELECT * FROM History WHERE flag = 0");
			} catch (Exception e) {
			}
		}

		return rs;
	}
	
	public static void main(String[] args) throws SQLException {

	}
}