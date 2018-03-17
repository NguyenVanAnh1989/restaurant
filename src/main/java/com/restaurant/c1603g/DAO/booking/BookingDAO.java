package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.BookingQueries;
import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.booking.Booking;

public class BookingDAO extends SqlConnectDAO implements RepositoryDAO<Booking> {

	@Override
	public Booking getEntityById(String id) {
		PreparedStatement preparedStatement = preparedStatement(BookingQueries.GET_BOOKING_BY_ID);
		try {
			preparedStatement.setString(1, id);
			return getBookingFromDB(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Booking> getManyEntityByName(String name) {

		PreparedStatement preparedStatement = preparedStatement(BookingQueries.GET_BOOKING_BY_NAME);
		try {
			preparedStatement.setString(1, "%" + name + "%");
			return getListBookingFromDB(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String insertEntity(Booking booking) {
		PreparedStatement preparedStatement = preparedStatement(BookingQueries.INSERT_BOOKING);
		try {
			preparedStatement.setString(1, booking.getId());
			preparedStatement.setString(2, booking.getCustomer_Name());
			preparedStatement.setString(3, booking.getCustomer_Phone());
			preparedStatement.setString(4, booking.getCustomer_Mail());
			preparedStatement.setString(5, booking.getTable_Id());
			preparedStatement.setString(6, booking.getService_Id());
			preparedStatement.setString(7, booking.getDate_Book());
			preparedStatement.setInt(8,1);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String updateEntity(Booking booking) {
		PreparedStatement preparedStatement = preparedStatement(BookingQueries.UPDATE_BOOKING);
		try {
			preparedStatement.setString(1, booking.getCustomer_Name());
			preparedStatement.setString(2, booking.getCustomer_Phone());
			preparedStatement.setString(3, booking.getCustomer_Mail());
			preparedStatement.setString(4, booking.getTable_Id());
			preparedStatement.setString(5, booking.getService_Id());
			preparedStatement.setString(6, booking.getDate_Book());
			preparedStatement.setInt(7, booking.getActivated());
			preparedStatement.setString(8, booking.getId());
			return preparedStatement.executeUpdate() > 0 ? "Success Full Insert" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String deleteEntity(String id) {
		return null;
	}

	public Booking getBookingFromDB(PreparedStatement preparedStatement) {
		Booking booking = null;
		try {
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				booking = new Booking();
				booking.setId(result.getString(1));
				booking.setCustomer_Name(result.getString(2));
				booking.setCustomer_Phone(result.getString(3));
				booking.setCustomer_Mail(result.getString(4));
				booking.setTable_Id(result.getString(5));
				booking.setService_Id(result.getString(6));
				booking.setDate_Book(result.getString(7));
				booking.setActivated(result.getInt(8));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;
	}

	private List<Booking> getListBookingFromDB(PreparedStatement preparedStatement) {

		List<Booking> listBooking = null;
		try {
			ResultSet result = preparedStatement.executeQuery();
			listBooking = new ArrayList<>();
			if (result.next()) {
				Booking booking = new Booking();
				booking.setId(result.getString(1));
				booking.setCustomer_Name(result.getString(2));
				booking.setCustomer_Phone(result.getString(3));
				booking.setCustomer_Mail(result.getString(4));
				booking.setTable_Id(result.getString(6));
				booking.setService_Id(result.getString(7));
				booking.setDate_Book(result.getString(8));
				booking.setActivated(result.getInt(9));
				listBooking.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBooking;
	}

}
