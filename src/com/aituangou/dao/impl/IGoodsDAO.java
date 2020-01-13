package com.aituangou.dao.impl;

import com.aituangou.po.Goods;
import com.aituangou.po.Shop;

import java.util.List;

public interface IGoodsDAO extends IBaseDAO {
	public List find(String hql);
    public List findByShop(Shop instance);
    public List findById(Integer gid);
    public List findGoodById(int id);
    public boolean update(Goods instance);
    public int getMaxId();
	public void delete(Goods transientInstance);
	public boolean save(Goods good);
}
