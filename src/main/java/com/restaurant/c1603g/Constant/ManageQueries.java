package com.restaurant.c1603g.Constant;

public class ManageQueries {
	
	// SQL for Receptionist

	public static final String GET_RECEPTIONIST = "SELECT * FROM tblReceptionist WHERE id = ?";

	public static final String GET_RECEPTIONIST_BY_NAME = "SELECT * FROM tblReceptionist WHERE name LIKE ?";

	public static final String INSERT_RECEPTIONIST = "INSERT INTO tblReceptionist VALUES (?,?,?,?)";

	public static final String UPDATE_RECEPTIONIST = "UPDATE tblReceptionist SET name =? , phone =? ,activated =? WHERE id = ?";

	public static final String DELETE_RECEPTIONIST = "UPDATE tblReceptionist SET activated = 0 WHERE id = ?";

	// SQL for Addmin

	public static final String GET_ADMIN = "SELECT * FROM tblAdmin WHERE id = ?";

	public static final String GET_ADMIN_BY_NAME = "SELECT * FROM tblAdmin WHERE userName LIKE ?";
	
	public static final String CHECK_EXIT_ADMIN = "SELECT * FROM tblAdmin WHERE userName = ?";
	
	public static final String CHECK_ADMIN_ACOUNT = "SELECT * FROM tblAdmin WHERE userName = ? AND password = ?";

	public static final String INSERT_ADMIN = "INSERT INTO tblAdmin VALUES (?,?,?,?,?)";

	public static final String UPDATE_ADMIN = "UPDATE tblddmin SET userName = ? , password = ? ,permission = ?, activated = ? WHERE id = ?";

	public static final String DELETE_ADMIN = "UPDATE tblAdmin SET activated = 0 WHERE id = ?";

}
