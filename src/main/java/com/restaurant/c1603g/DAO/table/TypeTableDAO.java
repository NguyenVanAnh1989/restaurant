package com.restaurant.c1603g.DAO.table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.SqlQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.table.TypeTable;

public class TypeTableDAO extends SqlConnectDAO implements RepositoryDAO<TypeTable> {

	@Override
	public TypeTable getEntityById(String id) {
		PreparedStatement preparedStatement;
		TypeTable typeTable;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_TYPE_TABLE);
			preparedStatement.setString(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				typeTable = new TypeTable();
				typeTable.setId(result.getString(1));
				typeTable.setType_seat(result.getString(2));
				typeTable.setType_room(result.getString(3));
				typeTable.setDescription(result.getString(4));
				typeTable.setActivated(result.getInt(5));
				typeTable.setPrice(result.getFloat(6));
				return typeTable;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TypeTable> getManyEntityByName(String name) {
		List<TypeTable> listTypeTable = new ArrayList<>();
		PreparedStatement preparedStatement;
		TypeTable typeTable;
		try {
			preparedStatement = preparedStatement(SqlQueries.GET_TYPE_TABLE_BY_NAME);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				typeTable = new TypeTable();
				typeTable.setId(result.getString(1));
				typeTable.setType_seat(result.getString(2));
				typeTable.setType_room(result.getString(3));
				typeTable.setDescription(result.getString(4));
				typeTable.setActivated(result.getInt(5));
				typeTable.setPrice(result.getFloat(6));
				listTypeTable.add(typeTable);
			}
			return listTypeTable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String insertEntity(TypeTable typeTable) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.INSERT_TYPE_TABLE);
			preparedStatement.setString(1, typeTable.getId());
			preparedStatement.setString(2, typeTable.getType_seat());
			preparedStatement.setString(3, typeTable.getType_room());
			preparedStatement.setString(4, typeTable.getDescription());
			preparedStatement.setInt(5, typeTable.getActivated());
			preparedStatement.setFloat(6, (float) typeTable.getPrice());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Your query have false some where";
	}

	@Override
	public String updateEntity(TypeTable typeTable) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.UPDATE_TYPE_TABLE);
			preparedStatement.setString(1, typeTable.getType_seat());
			preparedStatement.setString(2, typeTable.getType_room());
			preparedStatement.setString(3, typeTable.getDescription());
			preparedStatement.setInt(4, typeTable.getActivated());
			preparedStatement.setFloat(5, (float) typeTable.getPrice());
			preparedStatement.setString(6, typeTable.getId());
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : "Notsuccess Full Id Not found";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Your query have false some where";
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = preparedStatement(SqlQueries.DELETE_TYPE_TABLE);
			preparedStatement.setString(1,id);
			return preparedStatement.executeUpdate() > 0 ? "SuccessFull" : "Notsuccess Full Id Not found";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Your query have false some where";
	}

}
