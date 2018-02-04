package com.restaurant.c1603g.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.restaurant.c1603g.Config.SqlConfiguration;
import com.restaurant.c1603g.Entity.TypeFood;

public class TypeFoodDao {
	public boolean insert(TypeFood typefood) {
		Connection connection=new SqlConfiguration().getConnection();
		PreparedStatement prepareState;
		int finish = 0;
		try {
			prepareState = connection.prepareStatement("INSERT INTO tblTypeFood VALUES (?,?,?,?,?)");			
			prepareState.setString(1,typefood.getId());
			prepareState.setString(2,typefood.getName());
			prepareState.setString(3, typefood.getDescription());
			prepareState.setString(4, typefood.getUnit());
			prepareState.setInt(5,typefood.getActive());
			finish = prepareState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return finish > 0;
	}
}
