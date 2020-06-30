package best_travel;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	private static Connection connection;
	private static Statement statement;

	/*
	 * return true if database is connected
	 */
	public static boolean DataConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;integratedSecurity=true";
			connection = DriverManager.getConnection(url);

			if (connection != null)
				return true;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * create a new database with dbo.History if it doesn't exist
	 */
	public static void createDataBase() throws SQLException {
		if (DataConnection()) {
			statement = connection.createStatement();
			try {
				statement.execute("CREATE DATABASE BestTravel");
				statement.execute("USE BestTravel");
				statement.execute(
						"CREATE TABLE History(id INT IDENTITY(1,1) PRIMARY KEY , time datetime , listOfDistances varchar(8000), numberOfCities int, distanceLimitation int, output varchar(20), flag bit)");
			} catch (Exception e) {
			}
		}
	}

	/*
	 * add a new record from user's using history into dbo.History
	 */
	public static void addHistory(String time, String listOfDistances, int numberOfCities, int distanceLimitation,
			String ouput) throws SQLException {
		if (DataConnection()) {
			statement = connection.createStatement();
			try {
				statement.execute("USE BestTravel");
				String query = String.format(
						"INSERT INTO History (time, listOfDistances, numberOfCities, distanceLimitation, output, flag) VALUES( '%s', '%s', %d, %d, '%s', %d)",
						time, listOfDistances, numberOfCities, distanceLimitation, ouput, 0);
				statement.execute(query);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	/*
	 * delete the chosen record from dbo.History. This is not hard delete.
	 */
	public static void delHistory(int id) throws SQLException {
		if (DataConnection()) {
			statement = connection.createStatement();
			try {
				statement.execute("USE BestTravel");
				String query = String.format("UPDATE History SET flag = 1 WHERE id = %d", id);
				statement.execute(query);
			} catch (Exception e) {
			}
		}
	}

	/*
	 * delete the all record from dbo.History. This is not hard delete.
	 */
	public static void delAllHistory() throws SQLException {
		if (DataConnection()) {
			statement = connection.createStatement();
			try {
				statement.execute("USE BestTravel");
				statement.execute("UPDATE History SET flag = 1 WHERE flag = 0");
			} catch (Exception e) {
			}
		}
	}

	/*
	 * get ResultSet from dbo.History to show in JTable
	 */
	public static ResultSet getAllHistory() throws SQLException {
		ResultSet historyResultSet = null;
		if (DataConnection()) {
			statement = connection.createStatement();
			try {
				statement.execute("USE BestTravel");
				historyResultSet = statement.executeQuery("SELECT * FROM History WHERE flag = 0");
			} catch (Exception e) {
			}
		}

		return historyResultSet;
	}

	public static void main(String[] args) throws SQLException {
	}
}