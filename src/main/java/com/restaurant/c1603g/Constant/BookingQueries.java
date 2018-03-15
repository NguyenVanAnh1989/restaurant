package com.restaurant.c1603g.Constant;

public class BookingQueries {

	public static final String INSERT_BOOKING = "INSERT INTO tblBooking VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_BOOKING = "UPDATE tblBooking SET "
			+ "customer_name =? , customer_phone =? ,customer_email =? ,customer_number =? , table_id =? "
			+ " , service_id =? ,date_book =? ,status = ? WHERE id =?";
	public static final String DELETE_BOOKING = "UPDATE tblBooking SET activated =0 WHERE id = ?";
	public static final String GET_BOOKING_BY_ID = "SELECT * FROM tblBooking WHERE id =?";
	public static final String GET_BOOKING_BY_NAME = "SELECT * FROM tblBooking WHERE customer_name LIKE ?";

	// SQL for support Booking

	public static final String GET_TABLE_BY_TYPE = "SELECT tblTable.id AS tbl_id FROM tblTable INNER JOIN tblTypeTable "
			+ "ON tblTable.type_table_id = tblTypeTable.id AND type_seat LIKE ?";

	public static final String GET_DATE_TABLE_IN_BOOKING = "SELECT tblBooking.table_id,tblBooking.date_book FROM "
			+ "tblBooking INNER JOIN (" + GET_TABLE_BY_TYPE + ") AS _table "
			+ "ON tblBooking.table_id = _table.tbl_id";

}
