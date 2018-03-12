package com.restaurant.c1603g.DAO.food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.FoodQueries;
import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.food.Food;

public class FoodDAO extends SqlConnectDAO implements RepositoryDAO<Food>{

	@Override
	public Food getEntityById(String id) {
		PreparedStatement preparedStatement;
		Food food;
		try {
			preparedStatement = preparedStatement(FoodQueries.SEARCH_FOOD);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				food = new Food();
				food.setId(result.getString(1));
				food.setType_food_id(result.getString(2));
				food.setName(result.getString(3));
				food.setImage(result.getString(4));
				food.setDescription(result.getString(5));
				food.setPrice(result.getFloat(6));
				food.setActivated(result.getInt(7));
				food.setDiscount(result.getInt(8));
				return food;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> getManyEntityByName(String name) {
		List<Food> listFood = new ArrayList<>();
		PreparedStatement preparedStatement;
		Food food;
		try {
			preparedStatement = preparedStatement(FoodQueries.SEARCH_ALL_FOOD);
			preparedStatement.setString(1,"%"+name+"%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				food = new Food();
				food.setId(result.getString(1));
				food.setType_food_id(result.getString(2));
				food.setName(result.getString(3));
				food.setImage(result.getString(4));
				food.setDescription(result.getString(5));
				food.setPrice(result.getFloat(6));
				food.setActivated(result.getInt(7));
				food.setDiscount(result.getInt(8));
				listFood.add(food);
			}
			return listFood;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateEntity(Food food) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(FoodQueries.UPDATE_FOOD);
			preparedStatement.setString(1,food.getType_food_id());
			preparedStatement.setString(2,food.getName());
			preparedStatement.setString(3,food.getImage());
			preparedStatement.setString(4,food.getDescription());
			preparedStatement.setFloat(5,(float)food.getPrice());
			preparedStatement.setInt(6,1);
			preparedStatement.setInt(7,food.getDiscount());
			preparedStatement.setString(8,food.getId());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String deleteEntity(String id) {
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(FoodQueries.DELETE_FOOD);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
		
	}

	@Override
	public String insertEntity(Food food) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(FoodQueries.INSERT_FOOD);
			preparedStatement.setString(1,food.getId());
			preparedStatement.setString(2,food.getType_food_id());
			preparedStatement.setString(3,food.getName());
			preparedStatement.setString(4,food.getImage());
			preparedStatement.setString(5,food.getDescription());
			preparedStatement.setFloat(6,(float)food.getPrice());
			preparedStatement.setInt(7,1);
			preparedStatement.setFloat(8,food.getDiscount());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}
	
}
