package com.aituangou.service;

import com.aituangou.dao.impl.IOrderListDAO;
import com.aituangou.po.OrderList;
import com.aituangou.service.impl.IPayService;

public class PayService implements IPayService {
	private IOrderListDAO orderListDAO = null;

	public IOrderListDAO getOrderListDAO() {
		return orderListDAO;
	}

	public void setOrderListDAO(IOrderListDAO orderListDAO) {
		this.orderListDAO = orderListDAO;
	}
	
	public void updateOrder(OrderList orderList)
	{
		orderListDAO.update(orderList);
	}
}
