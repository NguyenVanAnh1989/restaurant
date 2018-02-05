package com.restaurant.c1603g.Constant;

public class SqlQueries {

	public static final String INSERT_TYPE_FOOD = "INSERT INTO tblTypeFood VALUES (?,?,?,?,?)";
	public static final String SEARCH_TYPE_FOOD = "SELECT * FROM tblTypeFood WHERE id = ?";
	public static final String SEARCH_TYPE_FOOD_BY_NAME = "SELECT * FROM tblTypeFood WHERE name LIKE ?";
	public static final String UPDATE_TYPE_FOOD = "UPDATE tblTypeFood SET name = ? ,description = ? ,unit = ? "
			+ ", activated = ? WHERE id = ?";
	public static final String DELETE_TYPE_FOOD = "DELETE FROM tblTypeFood WHERE id = ?";
	
}
