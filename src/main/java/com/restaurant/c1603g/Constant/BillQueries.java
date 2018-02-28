package com.restaurant.c1603g.Constant;

public class BillQueries {
	public static final String INSERT_BILL = "INSERT INTO tblBill VALUES (?,?,?,?,?,?)";
	public static final String UPDATE_BILL = "UPDATE tblBill SET  WHERE id = ?";
	public static final String GET_BILL_BY_ID = "SELECT * FROM tblBill WHERE id =?";
	public static final String GET_BILL_BY_NAME = "SELECT * FROM tblBill WHERE customer_name LIKE ?";

}
