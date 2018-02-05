package com.restaurant.c1603g.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Config.SqlConfiguration;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Constant.SqlQueries;

public class TypeFoodDao {
	
	public Connection getConnection() {
		return new SqlConfiguration().getConnection();
	}
	
	public PreparedStatement preparedStatement(String sql) {
		try {
			return getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insert(TypeFood typefood) {
		try {
			PreparedStatement prepareState = preparedStatement(SqlQueries.INSERT_TYPE_FOOD);			
			prepareState.setString(1,typefood.getId());
			prepareState.setString(2,typefood.getName());
			prepareState.setString(3, typefood.getDescription());
			prepareState.setString(4, typefood.getUnit());
			prepareState.setInt(5,typefood.getActive());
			return prepareState.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public TypeFood getTypeFoodById(String id) {
		
		PreparedStatement preparedStatement;
		TypeFood typeFood;
		try {
			preparedStatement = preparedStatement(SqlQueries.SEARCH_TYPE_FOOD);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				typeFood = new TypeFood();
				typeFood.setId(result.getString(1));
				typeFood.setName(result.getString(2));
				typeFood.setDescription(result.getString(3));
				typeFood.setUnit(result.getString(4));
				typeFood.setActive(result.getInt(5));
				return typeFood;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	public List<TypeFood> getTypeFoodByName(String name) {
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
				typeFood.setActive(result.getInt(5));
				listTypeFood.add(typeFood);

			}
			return listTypeFood;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateTypeFood(TypeFood typeFood) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_TYPE_FOOD);
			preparedStatement.setString(1,typeFood.getName());
			preparedStatement.setString(2, typeFood.getDescription());
			preparedStatement.setString(3, typeFood.getUnit());
			preparedStatement.setInt(4,typeFood.getActive());
			preparedStatement.setString(5,typeFood.getId());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteTypeFood(String id) {
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.DELETE_TYPE_FOOD);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
}
