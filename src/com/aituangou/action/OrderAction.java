package com.aituangou.action;


import com.aituangou.service.impl.IOrderService;

public class OrderAction {
    private int oid;
    private int shipid;
    private IOrderService orderService = null;

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int getShipid() {
        return shipid;
    }

    public void setShipid(int shipid) {
        this.shipid = shipid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getAllOrderInfo(){
        orderService.getAllOrderInfo();
        return "success";
    }
    public String shipDetail(){
        orderService.getShipDetail(oid);
        return "success";
    }
    public String ship(){
        if(orderService.ship(shipid)){
            return "success";
        }else {
            return "fail";
        }
    }
}
