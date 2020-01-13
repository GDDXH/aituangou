package com.aituangou.dao.impl;

import com.aituangou.po.Cart;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;

import java.util.List;

public interface IOrderListDAO extends IBaseDAO {
    public List findByHql(String hql);
    public void update(OrderList orderList);
	public void save(OrderList orderList);
	public void updateGood(Goods good);
	public void deleteCart(Cart cart);
	public void addGroup(Groups groups);
	public void updateOrderRecstateByOid(int oid1, String recstate);
	public void deleteGroup(Groups groups);
}
