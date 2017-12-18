package com.cg.ars.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.ars.exception.ArsException;

public class DBUtil {

	private DBUtil() {
	}

	private static Connection connection;

	public static Connection obtainConnection() throws ArsException {
		try {
			if (connection == null || connection.isClosed()) {
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String username = "system";
				String password = "oracle";
				connection = DriverManager.getConnection(url, username,
						password);
			}
		} catch (SQLException e) {
			throw new ArsException(e.getMessage());
		}
		return connection;
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}

	public static void main(String[] args) throws ArsException {
		System.out.println(obtainConnection());
	}
}
