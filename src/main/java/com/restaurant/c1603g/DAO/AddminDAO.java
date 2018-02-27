package com.restaurant.c1603g.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.Constant.ManageQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.manage.Addmin;

public class AddminDAO extends SqlConnectDAO implements RepositoryDAO<Addmin> {

	@Override
	public Addmin getEntityById(String id) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.GET_ADDMIN);
		Addmin addmin = null;
		try {
			preparedStatement.setString(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				addmin = new Addmin();
				addmin.setId(result.getString(1));
				addmin.setUserName(result.getString(2));
				addmin.setPassword(result.getString(3));
				addmin.setPermission(result.getString(4));
				addmin.setActivated(result.getInt(5));
				return addmin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addmin;
	}

	@Override
	public List<Addmin> getManyEntityByName(String name) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.GET_ADDMIN_BY_NAME);
		try {
			preparedStatement.setString(1, "%" + name + "%");
			return getAddmins(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String insertEntity(Addmin addmin) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.INSERT_ADDMIN);
		try {
			preparedStatement.setString(1, addmin.getId());
			preparedStatement.setString(2, addmin.getUserName());
			preparedStatement.setString(3, addmin.getPassword());
			preparedStatement.setString(4, addmin.getPermission());
			preparedStatement.setInt(5, addmin.getActivated());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String updateEntity(Addmin addmin) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.UPDATE_ADDMIN);
		try {
			preparedStatement.setString(1, addmin.getUserName());
			preparedStatement.setString(2, addmin.getPassword());
			preparedStatement.setString(3, addmin.getPermission());
			preparedStatement.setInt(4, addmin.getActivated());
			preparedStatement.setString(5, addmin.getId());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.DELETE_ADDMIN);
		try {
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	public List<Addmin> getAddmins(PreparedStatement preparedStatement) {
		List<Addmin> listAddmin = new ArrayList<>();
		try {
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Addmin addmin = new Addmin();
				addmin.setId(result.getString(1));
				addmin.setUserName(result.getString(2));
				addmin.setPassword(result.getString(3));
				addmin.setPermission(result.getString(4));
				addmin.setActivated(result.getInt(5));
				listAddmin.add(addmin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listAddmin;
	}

}
