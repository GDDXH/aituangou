package com.aituangou.service.impl;

public interface IOrderService {
    public void getAllOrderInfo();
    public void getShipDetail(int oid);
    public boolean ship(int shipid);
}
