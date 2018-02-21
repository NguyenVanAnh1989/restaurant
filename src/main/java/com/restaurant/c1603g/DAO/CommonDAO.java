package com.restaurant.c1603g.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.other.DeclareId;

public class CommonDAO extends SqlConnectDAO{
	
	public DeclareId getIdOfEntity(String nameId) {
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.GET_ID_FOR_ENTITY);
			preparedStatement.setString(1,nameId);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				DeclareId declareId = new DeclareId();
				declareId.setNameId(result.getString(1));
				declareId.setValue(result.getInt(2));
				return declareId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	
	public void updateIdOfEntity(String nameId,int value) {
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.UPDATE_ID_FOR_ENTITY);
			preparedStatement.setInt(1,value+1);
			preparedStatement.setString(2,nameId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
}
