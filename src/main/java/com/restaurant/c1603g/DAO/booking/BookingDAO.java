package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.c1603g.Constant.BookingQueries;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.booking.Booking;


public class BookingDAO extends SqlConnectDAO implements RepositoryDAO<Booking> {

	@Override
	public Booking getEntityById(String id) {
		PreparedStatement preparedStatement = preparedStatement(BookingQueries.GET_BOOKING_BY_ID);
		try {
			preparedStatement.setString(1,id);
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
			preparedStatement.setString(1,"%"+name+"%");
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
			preparedStatement.setInt(5, booking.getCustommer_Number());
			preparedStatement.setString(6, booking.getTable_Id());
			preparedStatement.setString(7, booking.getService_Id());
			preparedStatement.setString(8, booking.getReception_Id());
			preparedStatement.setString(9, booking.getDate_Book_Start());
			preparedStatement.setString(10, booking.getDate_Book_End());
			preparedStatement.setFloat(11, (float) booking.getTotal());
			preparedStatement.setString(12, booking.getDate_Pay());
			return preparedStatement.executeUpdate() > 0 ? "Success Full Insert" : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Exception";
	}

	@Override
	public String updateEntity(Booking booking) {
		PreparedStatement preparedStatement = preparedStatement(BookingQueries.UPDATE_BOOKING);
		try {
			preparedStatement.setString(1, booking.getCustomer_Name());
			preparedStatement.setString(2, booking.getCustomer_Phone());
			preparedStatement.setString(3, booking.getCustomer_Mail());
			preparedStatement.setInt(4, booking.getCustommer_Number());
			preparedStatement.setString(5, booking.getTable_Id());
			preparedStatement.setString(6, booking.getService_Id());
			preparedStatement.setString(7, booking.getReception_Id());
			preparedStatement.setString(8, booking.getDate_Book_Start());
			preparedStatement.setString(9, booking.getDate_Book_End());
			preparedStatement.setFloat(10, (float) booking.getTotal());
			preparedStatement.setString(11, booking.getDate_Pay());
			preparedStatement.setString(12, booking.getId());
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
				booking.setCustommer_Number(result.getInt(5));
				booking.setTable_Id(result.getString(6));
				booking.setService_Id(result.getString(7));
				booking.setReception_Id(result.getString(8));
				booking.setDate_Book_Start(result.getString(9));
				booking.setDate_Book_End(result.getString(10));
				booking.setTotal(result.getFloat(11));
				booking.setDate_Pay(result.getString(12));
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
				booking.setCustommer_Number(result.getInt(5));
				booking.setTable_Id(result.getString(6));
				booking.setService_Id(result.getString(7));
				booking.setReception_Id(result.getString(8));
				booking.setDate_Book_Start(result.getString(9));
				booking.setDate_Book_End(result.getString(10));
				booking.setTotal(result.getFloat(11));
				booking.setDate_Pay(result.getString(12));
				listBooking.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBooking;
	}
	
}
