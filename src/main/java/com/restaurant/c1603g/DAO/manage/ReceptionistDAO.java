package com.restaurant.c1603g.DAO.manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Responsitory.ResponsitoryDAO;
import com.restaurant.c1603g.DAO.Responsitory.SqlConnectDAO;
import com.restaurant.c1603g.Entity.manage.Receptionist;

public class ReceptionistDAO extends SqlConnectDAO implements ResponsitoryDAO<Receptionist> {

	@Override
	public Receptionist getEntityById(String id) {
		PreparedStatement preparedStatement;
		Receptionist receptionist = null;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_RECEPTIONIST);
			preparedStatement.setString(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				receptionist = new Receptionist();
				receptionist.setId(result.getString(1));
				receptionist.setName(result.getString(2));
				receptionist.setPhone(result.getString(3));
				receptionist.setActivated(result.getInt(4));
				return receptionist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return receptionist;
	}

	@Override
	public List<Receptionist> getManyEntityByName(String name) {
		PreparedStatement preparedStatement;
		List<Receptionist> listReceptionist = null;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_RECEPTIONIST_BY_NAME);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet result = preparedStatement.executeQuery();
			listReceptionist = new ArrayList<>();
			if (result.next()) {
				Receptionist receptionist = new Receptionist();
				receptionist.setId(result.getString(1));
				receptionist.setName(result.getString(2));
				receptionist.setPhone(result.getString(3));
				receptionist.setActivated(result.getInt(4));
				listReceptionist.add(receptionist);
			}
			return listReceptionist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listReceptionist;
	}

	@Override
	public String insertEntity(Receptionist receptionist) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.INSERT_RECEPTIONIST);
			preparedStatement.setString(1, receptionist.getId());
			preparedStatement.setString(2, receptionist.getName());
			preparedStatement.setString(3, receptionist.getPhone());
			preparedStatement.setInt(4, receptionist.getActivated());
			return preparedStatement.executeUpdate() > 0 ? "Success Full" : null;
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String updateEntity(Receptionist receptionist) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_RECEPTIONIST);
			preparedStatement.setString(1, receptionist.getName());
			preparedStatement.setString(2, receptionist.getPhone());
			preparedStatement.setInt(3, receptionist.getActivated());
			preparedStatement.setString(4, receptionist.getId());
			return preparedStatement.executeUpdate() > 0 ? "Success Full Update" : "Not success Full";
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return "Exception Sql";
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.DELETE_RECEPTIONIST);
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate() > 0 ? "Success Full Delete" : "Not success Full";
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return "Exception Sql";
	}

}
