package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.BookingQueries;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.table.Table;

public class SupportBookingDAO extends SqlConnectDAO {

	public List<Table> getAllTable() {
		List<Table> listTable= new ArrayList<>();
		try {
			Statement statement = getConnection().createStatement();
			ResultSet result = statement.executeQuery(BookingQueries.GET_ALL_TABLE);
			while (result.next()) {
				Table table = new Table();
				table.setId(result.getString(1));
				table.setType_table_id(result.getString(3));
				table.setName(result.getString(2)+"#"+result.getString(4));
				table.setActivated(1);
				listTable.add(table);
			}
			return listTable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getIdTableInBooking(String date) {
		List<String> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(BookingQueries.GET_TABLE_VALID);
			preparedStatement.setString(1,date);
			preparedStatement.setString(2,date);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				list.add(result.getString(1));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
