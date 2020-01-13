package com.aituangou.service;

import com.aituangou.dao.BaseDAO;

import java.util.List;

public class IntroduceService {
	private BaseDAO baseDAO = null;
	
    public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public List search(String hql){
        List list = baseDAO.find(hql);
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }

    public List searchGoods(String id){
        String hql = "from Goods where id='"+id+"'";
        return search(hql);
    }

    public List searchGGoods(String id){
        String hql = "from GGoods where id='"+id+"'";
        return search(hql);
    }
}
