package com.restaurant.c1603g.Factory.booking;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.booking.BillDAO;
import com.restaurant.c1603g.Entity.booking.Bill;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class BillFactory implements CrudEntity<Bill> {

	@Override
	public Bill getEntity(String id) {
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
		DeclareId declare = new CommonDAO().getIdOfEntity("BI");
		bill.setId(declare.toString());
		String info = new BillDAO().insertEntity(bill);
		if(!info.equals("Exception") && info != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Successfull Done Ok";
		}else {
			return "Not Done Now Exception call";
		}
		
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
