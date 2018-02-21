package com.restaurant.c1603g.Constant;

public class OtherQueries {
	// SQL for Service
	public static final String GET_SERVICE = "SELECT * FROM tblService WHERE id = ?";

	public static final String GET_SERVICE_BY_NAME = "SELECT * FROM tblService WHERE name LIKE ?";

	public static final String INSERT_SERVICE = "INSERT INTO tblService VALUES (?,?,?,?,?,?)";

	public static final String UPDATE_SERVICE = "UPDATE tblService SET name =? , description =? ,discount =? ,image =? ,activated =? WHERE id = ?";

	public static final String DELETE_SERVICE = "UPDATE tblService SET activated = 0 WHERE id = ?";
}
