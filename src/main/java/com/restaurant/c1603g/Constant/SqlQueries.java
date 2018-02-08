package com.restaurant.c1603g.Constant;

public class SqlQueries {
	
	//SQL For TypeFood Entity
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
	
	
	
	/*tblSaveId is table of SaveId you can change by you table*/
	public static final String GET_ID_FOR_ENTITY = "SELECT * FROM tblSaveId WHERE nameId = ?"; 
	
	public static final String UPDATE_ID_FOR_ENTITY = "UPDATE tblSaveId SET value = ? WHERE nameId = ?";
	
}
