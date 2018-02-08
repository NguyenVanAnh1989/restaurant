package com.restaurant.c1603g.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Responsibility.DAOResponsibility;
import com.restaurant.c1603g.DAO.Responsibility.SqlConnectDAO;
import com.restaurant.c1603g.Entity.food.Food;

public class FoodDAO extends SqlConnectDAO implements DAOResponsibility<Food>{

	@Override
	public Food getEntityById(String id) {
		PreparedStatement preparedStatement;
		Food food;
		try {
			preparedStatement = preparedStatement(SqlQueries.SEARCH_FOOD);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				food = new Food();
				food.setId(result.getString(1));
				food.setType_food(result.getString(2));
				food.setName(result.getString(3));
				food.setImage(result.getString(4));
				food.setDescription(result.getString(5));
				food.setPrice(result.getFloat(6));
				food.setActived(result.getInt(7));
				return food;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> getALlEntityByName(String name) {
		List<Food> listFood = new ArrayList<>();
		PreparedStatement preparedStatement;
		Food food;
		try {
			preparedStatement = preparedStatement(SqlQueries.SEARCH_ALL_FOOD);
			preparedStatement.setString(1,"%"+name+"%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				food = new Food();
				food.setId(result.getString(1));
				food.setType_food(result.getString(2));
				food.setName(result.getString(3));
				food.setImage(result.getString(4));
				food.setDescription(result.getString(5));
				food.setPrice(result.getFloat(6));
				food.setActived(result.getInt(7));
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
			preparedStatement = preparedStatement(SqlQueries.UPDATE_FOOD);
			preparedStatement.setString(1,food.getType_food());
			preparedStatement.setString(2,food.getName());
			preparedStatement.setString(3,food.getImage());
			preparedStatement.setString(4,food.getDescription());
			preparedStatement.setFloat(5,(float)food.getPrice());
			preparedStatement.setInt(6,food.getActived());
			preparedStatement.setString(7,food.getId());
			return preparedStatement.executeUpdate() > 0 ? "Success Full update" : "Data Not available";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Not success Sql not correct";
	}

	@Override
	public String deleteEntity(String id) {
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.DELETE_FOOD);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? "Success full Delete" : "Data Not valid";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "false : Sql not correct See Log inside controler";
		
	}

	@Override
	public String insertEntity(Food food) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.INSERT_FOOD);
			preparedStatement.setString(1,food.getId());
			preparedStatement.setString(2,food.getType_food());
			preparedStatement.setString(3,food.getName());
			preparedStatement.setString(4,food.getImage());
			preparedStatement.setString(5,food.getDescription());
			preparedStatement.setFloat(6,(float)food.getPrice());
			preparedStatement.setInt(7,food.getActived());
			return preparedStatement.executeUpdate() > 0 ? "Success Full update" : "Data Not available";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Not success Sql not correct";
	}
	
}
