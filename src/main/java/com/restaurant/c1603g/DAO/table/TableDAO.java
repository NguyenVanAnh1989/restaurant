package com.restaurant.c1603g.DAO.table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.table.Table;

public class TableDAO extends SqlConnectDAO implements RepositoryDAO<Table>{

	@Override
	public Table getEntityById(String id) {
		PreparedStatement preparedStatement;
		Table table = null;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_TABLE);
			preparedStatement.setString(1,id);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				table =new Table();
				table.setId(result.getString(1));
				table.setType_table_id(result.getString(2));
				table.setActivated(result.getInt(3));
			}	
			return table;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	@Override
	public List<Table> getManyEntityByName(String typeseat) {
		PreparedStatement preparedStatement;
		List<Table> tableList = new ArrayList<>();
		Table table = null;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_TABLE_BY_TYPE_SEAT);
			preparedStatement.setString(1,"%"+typeseat+"%");
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				table =new Table();
				table.setId(result.getString(1));
				table.setType_table_id(result.getString(2));
				table.setActivated(result.getInt(3));
				tableList.add(table);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}

	@Override
	public String insertEntity(Table table) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.INSERT_TABLE);
			preparedStatement.setString(1, table.getId());
			preparedStatement.setString(2, table.getType_table_id());
			preparedStatement.setInt(3, table.getActivated());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String updateEntity(Table table) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_TABLE);
			preparedStatement.setString(1, table.getType_table_id());
			preparedStatement.setInt(2, table.getActivated());
			preparedStatement.setString(3, table.getId());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.DELETE_TABLE);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull Delete" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

}
