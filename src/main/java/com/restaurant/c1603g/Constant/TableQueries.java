package com.restaurant.c1603g.Constant;

public class TableQueries {

	// SQL for Table entity
	public static final String GET_TABLE = "SELECT * FROM tblTable WHERE id = ?";

	public static final String GET_TABLE_BY_TYPE_SEAT = "SELECT tblTable.id,tblTable.name,tblTable.type_table_id,tblTable.activated"
			+ "	FROM tblTable INNER JOIN tblTypeTable ON (tblTypeTable.id = tblTable.type_table_id AND tblTypeTable.type_seat LIKE ?)";

	public static final String INSERT_TABLE = "INSERT INTO tblTable VALUES (?,?,?,?)";

	public static final String UPDATE_TABLE = "UPDATE tblTable SET name=?, type_table_id = ?, activated =?  WHERE id = ?";

	public static final String DELETE_TABLE = "UPDATE tblTable SET activated = 0 WHERE id = ?";

	// SQL for Type table entity
	public static final String GET_TYPE_TABLE = "SELECT * FROM tblTypeTable WHERE id = ?";

	public static final String GET_TYPE_TABLE_BY_NAME = "SELECT * FROM tblTypeTable WHERE type_seat LIKE ?";

	public static final String INSERT_TYPE_TABLE = "INSERT INTO tblTypeTable VALUES (?,?,?,?,?,?)";

	public static final String UPDATE_TYPE_TABLE = "UPDATE tblTypeTable SET type_seat =? , type_room =? ,description =? ,activated =? ,price =? WHERE id = ?";

	public static final String DELETE_TYPE_TABLE = "UPDATE tblTypeTable SET activated = 0 WHERE id = ?";

}
