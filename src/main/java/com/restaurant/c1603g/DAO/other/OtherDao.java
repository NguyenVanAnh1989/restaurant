package com.restaurant.c1603g.DAO.other;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.Constant.OtherQueries;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;

public class OtherDao extends SqlConnectDAO {

	public String checkCode(String code) {
		PreparedStatement preparedStatement = preparedStatement(OtherQueries.CHECK_CODE);
		try {
			preparedStatement.setString(1, code);
			ResultSet result = preparedStatement.executeQuery();
			return result.next() ? "ok" : LogInfo.CODE_NOT_VALID;
		} catch (SQLException e) {
		}
		return LogInfo.EXEPTION;
	}

	public String UpdateCode(String code) {
		PreparedStatement preparedStatement = preparedStatement(OtherQueries.DELETE_CODE);
		try {
			preparedStatement.setString(1, code);
			int result = preparedStatement.executeUpdate();
			return result > 0 ? "ok" : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
		}
		return LogInfo.EXEPTION;
	}

}
