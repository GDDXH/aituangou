package com.aituangou.action;

import com.aituangou.po.OrderList;
import com.aituangou.service.impl.IPayService;

public class PayAction {
    private int number;
    private OrderList order;
    private IPayService payService=null;
    public int getNumber() {
        return number;
    }

	public OrderList getOrder() {
		return order;
	}

	public void setOrder(OrderList order) {
		this.order = order;
	}

	public void setNumber(int number) {
        this.number = number;
    }

    public IPayService getPayService() {
		return payService;
	}

	public void setPayService(IPayService payService) {
		this.payService = payService;
	}

	public String pay(){
    	order.setRecstate("已付款");
    	payService.updateOrder(order);
        return "success";
    }
}
