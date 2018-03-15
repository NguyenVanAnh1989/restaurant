package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restaurant.c1603g.Constant.BookingQueries;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;

public class SupportBookingDAO extends SqlConnectDAO {

	public List<String> getIdTableByType(String typeSeat) {
		List<String> tableId = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(BookingQueries.GET_TABLE_BY_TYPE);
			preparedStatement.setString(1, "%" + typeSeat + "%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				tableId.add(result.getString(1));
				System.out.println(result.getString(1));
			}
			return tableId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, List<String>> getIdTableInBooking(String typeSeat) {
		Map<String, List<String>> mapTable = new HashMap<>();
		List<String> tbaleId = new ArrayList<>();
		List<String> dateBook = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(BookingQueries.GET_DATE_TABLE_IN_BOOKING);
			preparedStatement.setString(1, "%" + typeSeat + "%");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				tbaleId.add(result.getString(1));
				dateBook.add(result.getString(2));
			}
			for (int i = 0; i < tbaleId.size(); i++) {
				mapTable.put(tbaleId.get(i),new ArrayList<>());
			}
			for (int i = 0; i < tbaleId.size(); i++) {
				mapTable.get(tbaleId.get(i)).add(dateBook.get(i));
			}
			return mapTable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapTable;
	}

}
