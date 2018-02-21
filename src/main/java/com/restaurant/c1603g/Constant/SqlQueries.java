package com.restaurant.c1603g.Constant;

public class SqlQueries {

	// SQL For TypeFood Entity
	public static final String INSERT_TYPE_FOOD = "INSERT INTO tblTypeFood VALUES (?,?,?,?,?)";

	public static final String SEARCH_TYPE_FOOD = "SELECT * FROM tblTypeFood WHERE id = ?";

	public static final String SEARCH_TYPE_FOOD_BY_NAME = "SELECT * FROM tblTypeFood WHERE name LIKE ?";

	public static final String UPDATE_TYPE_FOOD = "UPDATE tblTypeFood SET name = ? ,description = ? ,unit = ? "
			+ ", activated = ? WHERE id = ?";

	public static final String DELETE_TYPE_FOOD = "UPDATE tblTypeFood SET activated = 0 WHERE id = ?";

	// SQL for Food Entity
	public static final String SEARCH_FOOD = "SELECT * FROM tblFood WHERE id = ?";

	public static final String SEARCH_ALL_FOOD = "SELECT * FROM tblFood WHERE name LIKE ?";

	public static final String INSERT_FOOD = "INSERT INTO tblFood VALUES (?,?,?,?,?,?,?)";

	public static final String UPDATE_FOOD = "UPDATE tblFood SET type_food_id=?,name=? ,image=?,description=? ,price=?,activated=? WHERE id= ?";

	public static final String DELETE_FOOD = "UPDATE tblFood SET activated = 0 WHERE id = ?";

	// SQL for Table entity

	public static final String GET_TABLE = "SELECT * FROM tblTable WHERE id = ?";

	public static final String GET_TABLE_BY_TYPE_SEAT = "  SELECT * FROM tblTable WHERE type_table_id = (SELECT id FROM tblTypeTable WHERE type_seat LIKE ?)";

	public static final String INSERT_TABLE = "INSERT INTO tblTable VALUES (?,?,?)";

	public static final String UPDATE_TABLE = "UPDATE tblTable SET type_table_id = ?, activated =?  WHERE id = ?";

	public static final String DELETE_TABLE = "UPDATE tblTable SET activated = 0 WHERE id = ?";

	// SQL for Type table entity
	public static final String GET_TYPE_TABLE = "SELECT * FROM tblTypeTable WHERE id = ?";

	public static final String GET_TYPE_TABLE_BY_NAME = "SELECT * FROM tblTypeTable WHERE type_seat LIKE ?";

	public static final String INSERT_TYPE_TABLE = "INSERT INTO tblTypeTable VALUES (?,?,?,?,?,?)";

	public static final String UPDATE_TYPE_TABLE = "UPDATE tblTypeTable SET type_seat =? , type_room =? ,description =? ,activated =? ,price =? WHERE id = ?";

	public static final String DELETE_TYPE_TABLE = "UPDATE tblTypeTable SET activated = 0 WHERE id = ?";

	// SQL for Service
	public static final String GET_SERVICE = "SELECT * FROM tblService WHERE id = ?";

	public static final String GET_SERVICE_BY_NAME = "SELECT * FROM tblService WHERE name LIKE ?";

	public static final String INSERT_SERVICE = "INSERT INTO tblService VALUES (?,?,?,?,?,?)";

	public static final String UPDATE_SERVICE = "UPDATE tblService SET name =? , description =? ,discount =? ,image =? ,activated =? WHERE id = ?";

	public static final String DELETE_SERVICE = "UPDATE tblService SET activated = 0 WHERE id = ?";

	// SQL for Receptionist 
	
	public static final String GET_RECEPTIONIST = "SELECT * FROM tblReceptionist WHERE id = ?";

	public static final String GET_RECEPTIONIST_BY_NAME = "SELECT * FROM tblReceptionist WHERE name LIKE ?";

	public static final String INSERT_RECEPTIONIST = "INSERT INTO tblReceptionist VALUES (?,?,?,?)";

	public static final String UPDATE_RECEPTIONIST = "UPDATE tblReceptionist SET name =? , phone =? ,activated =? WHERE id = ?";

	public static final String DELETE_RECEPTIONIST = "UPDATE tblReceptionist SET activated = 0 WHERE id = ?";
	
	/* tblSaveId is table of SaveId you can change by you type table */
	public static final String GET_ID_FOR_ENTITY = "SELECT * FROM tblSaveId WHERE nameId = ?";

	public static final String UPDATE_ID_FOR_ENTITY = "UPDATE tblSaveId SET value = ? WHERE nameId = ?";

}
