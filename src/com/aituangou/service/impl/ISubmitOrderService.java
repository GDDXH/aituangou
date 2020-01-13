package com.aituangou.service.impl;

import com.aituangou.po.Cart;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;

public interface ISubmitOrderService {
	public void addOrder(OrderList orderList);

	public Goods findGoodById(int gid);

	public void updateGood(Goods good);

	public void deleteCart(Cart cart);

	public void addGroup(Groups groups);

	public void updateOrderRecstateByOid(int oid1, String recstate);

	public void deleteGroup(Groups groups);
}
