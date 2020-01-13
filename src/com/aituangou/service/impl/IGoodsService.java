package com.aituangou.service.impl;

import java.util.List;

import com.aituangou.po.GoodCheck;
import com.aituangou.po.Goods;

public interface IGoodsService {
	public List getGoods();
	public Goods getGoodsDetails(Goods transientInstance);
	public boolean update(Goods transientInstance);
	public void delete(Goods transientInstance);
	public boolean save(Goods transientInstance);
	
	public List getGoodcheck();
	public boolean checkPass(GoodCheck transientInstance);
	public boolean unCheckPass(GoodCheck goodcheck);
	
}
