package com.restaurant.c1603g.Constant;

public class BookingQueries {
	
	public static final String INSERT_BOOKING = "INSERT INTO tblBooking VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_BOOKING = "UPDATE tblBooking SET "
			+ "customer_name =? , customer_phone =? ,customer_email =? ,customer_number =? , table_id =? "
			+ " , service_id =? ,date_book =? ,status = ? WHERE id =?";
	public static final String DELETE_BOOKING = "UPDATE tblBooking SET activated =0 WHERE id = ?";
	public static final String GET_BOOKING_BY_ID = "SELECT * FROM tblBooking WHERE id =?";
	public static final String GET_BOOKING_BY_NAME = "SELECT * FROM tblBooking WHERE customer_name LIKE ?";
	
}
