package com.aituangou.service;

import com.aituangou.dao.BaseDAO;

import java.util.List;

public class SearchService {
	private BaseDAO baseDAO = null;
	
    public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public List search(String name,String sort){
        String hql;
        if(sort==null){
            hql = "from Goods where name like '%"+name+"%'";
        }else if(sort.equals("main")){
            hql = "from Goods where name like '%"+name+"%'";
        }else if(sort.equals("sale")){
            hql = "from Goods where name like '%"+name+"%' order by sales desc,id";
        }else if(sort.equals("price")){
            hql = "from Goods where name like '%"+name+"%' order by price,id";
        }else if(sort.equals("comment")){
            hql = "from Goods where name like '%"+name+"%' order by score desc,id";
        }else {
            hql = "from Goods where name like '%"+name+"%'";
        }
        
        List list = baseDAO.find(hql);
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
}
