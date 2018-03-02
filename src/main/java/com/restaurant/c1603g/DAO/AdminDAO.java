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
import com.restaurant.c1603g.DAO.other.OtherDao;
import com.restaurant.c1603g.Entity.manage.Admin;

public class AdminDAO extends SqlConnectDAO implements RepositoryDAO<Admin> {

	@Override
	public Admin getEntityById(String id) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.GET_ADMIN);
		Admin addmin = null;
		try {
			preparedStatement.setString(1, id);
			return getAdmin(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addmin;
	}

	@Override
	public List<Admin> getManyEntityByName(String name) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.GET_ADMIN_BY_NAME);
		try {
			preparedStatement.setString(1, "%" + name + "%");
			return getAdmins(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String insertEntity(Admin addmin) {
		String info = checkExitAdmin(addmin.getUserName());
		if (!info.equals("ok")) {
			return info;
		} else {
			PreparedStatement preparedStatement = preparedStatement(ManageQueries.INSERT_ADMIN);
			try {
				preparedStatement.setString(1, addmin.getId());
				preparedStatement.setString(2, addmin.getUserName());
				preparedStatement.setString(3, addmin.getPassword());
				preparedStatement.setString(4, addmin.getPermission());
				preparedStatement.setInt(5, addmin.getActivated());
				if (preparedStatement.executeUpdate() > 0) {
					new OtherDao().UpdateCode(addmin.getCode());
					return LogInfo.SUCCESS_FULL;
				}
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return LogInfo.EXEPTION;
		}
	}

	@Override
	public String updateEntity(Admin admin) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.UPDATE_ADMIN);
		try {
			preparedStatement.setString(1, admin.getUserName());
			preparedStatement.setString(2, admin.getPassword());
			preparedStatement.setString(3, admin.getPermission());
			preparedStatement.setInt(4, admin.getActivated());
			preparedStatement.setString(5, admin.getId());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement = preparedStatement(ManageQueries.DELETE_ADMIN);
		try {
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	public List<Admin> getAdmins(PreparedStatement preparedStatement) {
		List<Admin> listAddmin = new ArrayList<>();
		try {
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Admin addmin = new Admin();
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

	public Admin getAdmin(PreparedStatement preparedStatement) {
		ResultSet result;
		Admin addmin = null;
		try {
			result = preparedStatement.executeQuery();
			if (result.next()) {
				addmin = new Admin();
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

	public String checkExitAdmin(String userName) {
		PreparedStatement prepare = preparedStatement(ManageQueries.CHECK_EXIT_ADMIN);
		try {
			prepare.setString(1, userName);
			ResultSet result = prepare.executeQuery();
			return result.next() ? LogInfo.USER_EXIT : "ok";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXEPTION;
	}

	public String checkAdminAcount(Admin admin) {
		PreparedStatement prepare = preparedStatement(ManageQueries.CHECK_ADMIN_ACOUNT);
		try {
			prepare.setString(1, admin.getUserName());
			prepare.setString(2, admin.getPassword());
			ResultSet result = prepare.executeQuery();
			return result.next() ? LogInfo.SUCCESS_FULL : LogInfo.FAIL_LOGIN;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXEPTION;
	}

}
