package com.restaurant.c1603g.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConfiguration {
	private Connection connection;

	public SqlConfiguration() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=12345;database=ASM");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
