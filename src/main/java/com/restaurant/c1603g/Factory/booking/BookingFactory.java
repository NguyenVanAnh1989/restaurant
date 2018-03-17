package com.restaurant.c1603g.Factory.booking;

import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.booking.BookingDAO;
import com.restaurant.c1603g.Entity.booking.Booking;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class BookingFactory implements CrudEntity<Booking>{

	@Override
	public Booking getEntity(String id) {
		return new BookingDAO().getEntityById(id);
	}

	@Override
	public List<Booking> getManyEntityByName(String name) {
		return new BookingDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(Booking booking) {
		DeclareId declare = new CommonDAO().getIdOfEntity("BK");
		booking.setId(declare.toString());
		String info = new BookingDAO().insertEntity(booking);
		if(info.equals(LogInfo.SUCCESS_FULL)) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return info;
		}else {
			return info;
		}		

	}

	@Override
	public String updateEntity(Booking booking) {
		return new BookingDAO().updateEntity(booking);
	}

	@Override
	public String deleteEntity(String id) {
		return null;
	}

}
