package com.restaurant.c1603g.DAO.other;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Responsitory.ResponsitoryDAO;
import com.restaurant.c1603g.DAO.Responsitory.SqlConnectDAO;
import com.restaurant.c1603g.Entity.other.EntityService;

public class ServiceDAO extends SqlConnectDAO implements ResponsitoryDAO<EntityService>{

	@Override
	public EntityService getEntityById(String id) {
		PreparedStatement preparedStatement;
		EntityService entity = null;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_SERVICE);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				entity = new EntityService();
				entity.setId(result.getString(1));
				entity.setName(result.getString(2));
				entity.setDescription(result.getString(3));
				entity.setDiscount(result.getInt(4));
				entity.setImage(result.getString(5));
				entity.setActivated(result.getInt(6));
				return entity;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return entity;
	}

	@Override
	public List<EntityService> getManyEntityByName(String name) {
		PreparedStatement preparedStatement;
		List<EntityService> listService = new ArrayList<EntityService>();
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_SERVICE_BY_NAME);
			preparedStatement.setString(1,"%"+name+"%");
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				EntityService entity = new EntityService();
				entity.setId(result.getString(1));
				entity.setName(result.getString(2));
				entity.setDescription(result.getString(3));
				entity.setDiscount(result.getInt(4));
				entity.setImage(result.getString(5));
				entity.setActivated(result.getInt(6));
				listService.add(entity);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return listService;
	}

	@Override
	public String insertEntity(EntityService service) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.INSERT_SERVICE);
			preparedStatement.setString(1,service.getId());
			preparedStatement.setString(2,service.getName());
			preparedStatement.setString(3,service.getDescription());
			preparedStatement.setInt(4,service.getDiscount());
			preparedStatement.setString(5,service.getImage());
			preparedStatement.setInt(6, service.getActivated());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : null;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String updateEntity(EntityService service) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_SERVICE);		
			preparedStatement.setString(1,service.getName());
			preparedStatement.setString(2,service.getDescription());
			preparedStatement.setInt(3,service.getDiscount());
			preparedStatement.setString(4,service.getImage());
			preparedStatement.setInt(5, service.getActivated());
			preparedStatement.setString(6,service.getId());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : "Not success full Id not allow";
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.DELETE_SERVICE);		
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? "DELETE SuccessFull" : "Not success full Id not allow";
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return "Exception";
	}

}
