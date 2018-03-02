package com.restaurant.c1603g.Factory;

import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.AdminDAO;
import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.other.OtherDao;
import com.restaurant.c1603g.Entity.manage.Admin;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class AdminFactory implements CrudEntity<Admin> {

	@Override
	public Admin getEntity(String id) {
		return new AdminDAO().getEntityById(id);
	}

	@Override
	public List<Admin> getManyEntityByName(String name) {
		return new AdminDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(Admin admin) {
		DeclareId declare = new CommonDAO().getIdOfEntity("AM");
		admin.setId(declare.toString());
		String codevalid = new OtherDao().checkCode(admin.getCode());
		if (!codevalid.equals("ok")) {
			return codevalid;
		}
		String info = new AdminDAO().insertEntity(admin);
		if (info == LogInfo.EXEPTION || info == null) {
			return LogInfo.EXEPTION;
		} else {
			new CommonDAO().updateIdOfEntity(declare.getNameId(), declare.getValue());
			return info;
		}
	}

	@Override
	public String updateEntity(Admin admin) {
		return new AdminDAO().updateEntity(admin);
	}

	@Override
	public String deleteEntity(String id) {
		return new AdminDAO().deleteEntity(id);
	}

	public String checkAdmin(Admin admin) {
		return new AdminDAO().checkAdminAcount(admin);
	}

}
