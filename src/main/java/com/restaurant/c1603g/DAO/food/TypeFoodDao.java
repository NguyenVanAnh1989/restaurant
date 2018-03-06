package com.restaurant.c1603g.DAO.food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.food.TypeFood;

public class TypeFoodDao extends SqlConnectDAO implements RepositoryDAO<TypeFood>{

	@Override
	public TypeFood getEntityById(String id) {
		PreparedStatement preparedStatement;
		TypeFood typeFood;
		try {
			preparedStatement = preparedStatement(SqlQueries.SEARCH_TYPE_FOOD);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				typeFood = new TypeFood();
				typeFood.setId(result.getString(1));
				typeFood.setName(result.getString(2));
				typeFood.setDescription(result.getString(3));
				typeFood.setUnit(result.getString(4));
				typeFood.setActivated(result.getInt(5));
				return typeFood;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TypeFood> getManyEntityByName(String name) {
		List<TypeFood> listTypeFood=new ArrayList<>();
		PreparedStatement preparedStatement;
		TypeFood typeFood;
		try {
			preparedStatement = preparedStatement(SqlQueries.SEARCH_TYPE_FOOD_BY_NAME);
			preparedStatement.setString(1,"%"+name+"%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				typeFood = new TypeFood();
				typeFood.setId(result.getString(1));
				typeFood.setName(result.getString(2));
				typeFood.setDescription(result.getString(3));
				typeFood.setUnit(result.getString(4));
				typeFood.setActivated(result.getInt(5));
				listTypeFood.add(typeFood);
			}
			return listTypeFood;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateEntity(TypeFood typeFood) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_TYPE_FOOD);
			preparedStatement.setString(1,typeFood.getName());
			preparedStatement.setString(2, typeFood.getDescription());
			preparedStatement.setString(3, typeFood.getUnit());
			preparedStatement.setString(4,typeFood.getId());
			return preparedStatement.executeUpdate() > 0 ?  LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String deleteEntity(String id) {
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.DELETE_TYPE_FOOD);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String insertEntity(TypeFood typefood) {
		try {
			PreparedStatement prepareState = preparedStatement(SqlQueries.INSERT_TYPE_FOOD);			
			prepareState.setString(1,typefood.getId());
			prepareState.setString(2,typefood.getName());
			prepareState.setString(3, typefood.getDescription());
			prepareState.setString(4, typefood.getUnit());
			return prepareState.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;

	}
	
	
	
	
	
	
}
