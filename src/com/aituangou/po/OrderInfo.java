package com.aituangou.po;

public class OrderInfo {
    private Goods goods;
    private Buyer buyer;
    private OrderList orderList;

    public OrderInfo(Goods goods, Buyer buyer, OrderList orderList) {
        this.goods = goods;
        this.buyer = buyer;
        this.orderList = orderList;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrder(OrderList orderList) {
        this.orderList = orderList;
    }
}
