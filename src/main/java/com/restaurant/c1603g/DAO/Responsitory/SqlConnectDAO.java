package com.restaurant.c1603g.DAO.Responsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.restaurant.c1603g.Config.SqlConfiguration;

public abstract class SqlConnectDAO {
	
	protected Connection getConnection() {
		return new SqlConfiguration().getConnection();
	}
	
	protected PreparedStatement preparedStatement(String sql) {
		try {
			return getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
