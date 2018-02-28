package com.restaurant.c1603g.Constant;

public class ManageQueries {
	
	// SQL for Receptionist

	public static final String GET_RECEPTIONIST = "SELECT * FROM tblReceptionist WHERE id = ?";

	public static final String GET_RECEPTIONIST_BY_NAME = "SELECT * FROM tblReceptionist WHERE name LIKE ?";

	public static final String INSERT_RECEPTIONIST = "INSERT INTO tblReceptionist VALUES (?,?,?,?)";

	public static final String UPDATE_RECEPTIONIST = "UPDATE tblReceptionist SET name =? , phone =? ,activated =? WHERE id = ?";

	public static final String DELETE_RECEPTIONIST = "UPDATE tblReceptionist SET activated = 0 WHERE id = ?";

	// SQL for Addmin

	public static final String GET_ADDMIN = "SELECT * FROM tblAddmin WHERE id = ?";

	public static final String GET_ADDMIN_BY_NAME = "SELECT * FROM tblAddmin WHERE userName LIKE ?";

	public static final String INSERT_ADDMIN = "INSERT INTO tblAddmin VALUES (?,?,?,?,?)";

	public static final String UPDATE_ADDMIN = "UPDATE tblAddmin SET userName = ? , password = ? ,permission = ?, activated = ? WHERE id = ?";

	public static final String DELETE_ADDMIN = "UPDATE tblAddmin SET activated = 0 WHERE id = ?";

}
