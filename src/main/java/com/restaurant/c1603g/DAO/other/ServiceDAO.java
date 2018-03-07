package com.restaurant.c1603g.DAO.other;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.Constant.OtherQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.other.EntityService;

public class ServiceDAO extends SqlConnectDAO implements RepositoryDAO<EntityService>{

	@Override
	public EntityService getEntityById(String id) {
		PreparedStatement preparedStatement;
		EntityService entity = null;
		try {
			preparedStatement = preparedStatement(OtherQueries.GET_SERVICE);
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
			preparedStatement = preparedStatement(OtherQueries.GET_SERVICE_BY_NAME);
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
			preparedStatement = preparedStatement(OtherQueries.INSERT_SERVICE);
			preparedStatement.setString(1,service.getId());
			preparedStatement.setString(2,service.getName());
			preparedStatement.setString(3,service.getDescription());
			preparedStatement.setInt(4,service.getDiscount());
			preparedStatement.setString(5,service.getImage());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String updateEntity(EntityService service) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(OtherQueries.UPDATE_SERVICE);		
			preparedStatement.setString(1,service.getName());
			preparedStatement.setString(2,service.getDescription());
			preparedStatement.setInt(3,service.getDiscount());
			preparedStatement.setString(4,service.getImage());
			preparedStatement.setInt(5, 1);
			preparedStatement.setString(6,service.getId());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(OtherQueries.DELETE_SERVICE);		
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

}
