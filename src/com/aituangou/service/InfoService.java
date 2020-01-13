package com.aituangou.service;


import com.aituangou.dao.BaseDAO;
import com.aituangou.po.Buyer;

public class InfoService {
	private BaseDAO baseDAO = null;
	
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public void update(Buyer loginUser) {   
		baseDAO.update(loginUser);
	}
}
