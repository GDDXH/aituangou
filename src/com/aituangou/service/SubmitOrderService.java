package com.aituangou.service;

import com.aituangou.dao.impl.IOrderListDAO;
import com.aituangou.po.Cart;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;
import com.aituangou.service.impl.ISubmitOrderService;


public class SubmitOrderService implements ISubmitOrderService{
	private IOrderListDAO orderListDAO = null;
	
	public IOrderListDAO getOrderListDAO() {
		return orderListDAO;
	}

	public void setOrderListDAO(IOrderListDAO orderListDAO) {
		this.orderListDAO = orderListDAO;
	}

	public void addOrder(OrderList orderList) {
		orderListDAO.save(orderList);
	}

	public Goods findGoodById(int gid) {
		String hql="from Goods as goods where goods.id="+gid;
		return (Goods) orderListDAO.findByHql(hql).get(0);
	}

	public void updateGood(Goods good) {
		orderListDAO.updateGood(good);
	}

	public void deleteCart(Cart cart) {
		orderListDAO.deleteCart(cart);
	}

	
	public void addGroup(Groups groups) {
		orderListDAO.addGroup(groups);
	}

	@Override
	public void updateOrderRecstateByOid(int oid1, String recstate) {
		orderListDAO.updateOrderRecstateByOid(oid1,recstate);
	}

	@Override
	public void deleteGroup(Groups groups) {
		orderListDAO.deleteGroup(groups);
	}
}
