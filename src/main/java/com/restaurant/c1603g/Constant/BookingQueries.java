package com.restaurant.c1603g.Constant;

public class BookingQueries {

	public static final String INSERT_BOOKING = "INSERT INTO tblBooking VALUES (?,?,?,?,?,?,?,?)";

	public static final String UPDATE_BOOKING = "UPDATE tblBooking SET "
			+ "customer_name =? , customer_phone =? ,customer_email =? ,customer_number =? , table_id =? "
			+ " , service_id =? ,date_book =? ,status = ? WHERE id =?";

	public static final String DELETE_BOOKING = "UPDATE tblBooking SET activated =0 WHERE id = ?";

	public static final String GET_BOOKING_BY_ID = "SELECT * FROM tblBooking WHERE id =?";

	public static final String GET_BOOKING_BY_NAME = "SELECT * FROM tblBooking WHERE customer_name LIKE ?";

	// SQL for support Booking

	public static final String GET_ALL_TABLE = "SELECT tblTable.id,tblTable.name,tblTable.type_table_id,tblTypeTable.type_seat FROM tblTable,tblTypeTable "
			+ "WHERE tblTable.type_table_id = tblTypeTable.id AND tblTable.activated=1 ORDER BY tblTypeTable.type_seat ASC";

	public static final String GET_TABLE_VALID = "SELECT tblTable.id FROM tblTable WHERE tblTable.id NOT IN "
			+ "(SELECT tblBooking.table_id FROM tblBooking WHERE " + "DATEDIFF(hour ,tblBooking.date_book,?) > -4 AND "
			+ "DATEDIFF(hour , tblBooking.date_book,?) < 4)";
}
