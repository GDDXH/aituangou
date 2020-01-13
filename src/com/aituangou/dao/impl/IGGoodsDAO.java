package com.aituangou.dao.impl;

import com.aituangou.po.GGoods;

import java.util.List;

public interface IGGoodsDAO extends IBaseDAO {
    public List findGGoodById(int id);
    public void update(GGoods instance);
	public boolean save(GGoods ggoods);
}
