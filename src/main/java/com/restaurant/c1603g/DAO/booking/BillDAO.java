package com.restaurant.c1603g.DAO.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		return null;
	}

	public List<Bill> getManyEntityByIdBooking(String id) {
		PreparedStatement preparedStatement = preparedStatement(BillQueries.GET_BILL_BY_ID_BOOKING);
		try {
			preparedStatement.setString(1, id);
		} catch (SQLException e) {
			return null;
		}
		return getlistBill(preparedStatement);
	}

	@Override
	public String insertEntity(Bill bill) {
		PreparedStatement preparedStatement = preparedStatement(BillQueries.INSERT_BILL);
		try {
			preparedStatement.setString(1, bill.getId());
			preparedStatement.setString(2, bill.getFoodId());
			preparedStatement.setInt(3, bill.getQuantity());
			preparedStatement.setFloat(4, (float) bill.getPrice());
			preparedStatement.setString(5, bill.getBookingId());
			preparedStatement.setInt(6, bill.getActivated());
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LogInfo.EXEPTION;
	}

	@Override
	public String updateEntity(Bill e) {
		return null;
	}

	@Override
	public String deleteEntity(String id) {
		PreparedStatement preparedStatement = preparedStatement(BillQueries.DELETE_BILL);
		try {
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate() > 0 ? LogInfo.SUCCESS_FULL : LogInfo.NOT_SUCCESS_FULL;
		} catch (SQLException e) {
			return LogInfo.EXCEPTION_INFO;
		}
	}

	public List<Bill> getlistBill(PreparedStatement prepare) {
		ResultSet result;
		List<Bill> listBill;
		try {
			result = prepare.executeQuery();
			listBill = new ArrayList<>();
			while (result.next()) {
				Bill bill = new Bill();
				bill.setId(result.getString(1));
				bill.setFoodId(result.getString(2));
				bill.setQuantity(result.getInt(3));
				bill.setPrice(result.getFloat(4));
				bill.setBookingId(result.getString(5));
				if (result.getInt(6) == 1) {
					listBill.add(bill);
				}
			}
			return listBill;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
