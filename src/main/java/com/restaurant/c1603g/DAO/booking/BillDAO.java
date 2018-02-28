package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.restaurant.c1603g.Constant.BillQueries;
import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.Repository.RepositoryDAO;
import com.restaurant.c1603g.DAO.Repository.SqlConnectDAO;
import com.restaurant.c1603g.Entity.booking.Bill;

public class BillDAO extends SqlConnectDAO implements RepositoryDAO<Bill> {

	@Override
	public Bill getEntityById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> getManyEntityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertEntity(Bill bill) {
		PreparedStatement preparedStatement = preparedStatement(BillQueries.INSERT_BILL);
		try {
			preparedStatement.setString(1, bill.getId());
			preparedStatement.setString(2, bill.getFoodId());
			preparedStatement.setInt(3, bill.getQuantity());
			preparedStatement.setFloat(4, (float)bill.getPrice());
			preparedStatement.setString(5, bill.getBookingId());
			preparedStatement.setInt(6, bill.getActivated());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXCEPTION_INFO;
	}

	@Override
	public String updateEntity(Bill e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEntity(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
