package com.aituangou.dao.impl;

import com.aituangou.po.GoodCheck;

import java.util.List;

public interface IGoodCheckDAO extends IBaseDAO {
    public int getMaxId();
    public List findById(Integer gid);
    public void save(GoodCheck instance);
    public List findByShopId(int shopid);
    public void delete(GoodCheck goodCheck);
    public List findGoodCheckById(int id);
	public List find(String hql);
	public boolean update(GoodCheck transientInstance);
}
