package com.aituangou.service;

import com.aituangou.dao.impl.IOrderListDAO;
import com.aituangou.po.*;
import com.aituangou.service.impl.IOrderService;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderService implements IOrderService {
    private Map<String, Object> session;
    private IOrderListDAO orderListDAO = null;

    public void setOrderListDAO(IOrderListDAO orderListDAO) {
        this.orderListDAO = orderListDAO;
    }

    public void getAllOrderInfo(){
        ActionContext context = ActionContext.getContext();
        session = (Map<String, Object>) context.getSession();
        Seller seller = (Seller) session.get("loginSeller");
        String hql = "from Goods g,Buyer b,OrderList o " +
                "where g.id=o.gid " +
                "and o.bid=b.id " +
                "and o.shopid="+seller.getShop().getShopid();
        List list = orderListDAO.findByHql(hql);
        Iterator iterator = list.iterator();
        List<OrderInfo> orderInfo = new ArrayList<OrderInfo>();
        while(iterator.hasNext()){
            Object object[] = (Object[])iterator.next();
            OrderInfo info = new OrderInfo((Goods) object[0],(Buyer) object[1],(OrderList) object[2]);
            orderInfo.add(info);
        }
        session.put("orderInfo",orderInfo);
    }

    public void getShipDetail(int oid){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        String hql = "from Goods g,Buyer b,OrderList o " +
                "where g.id=o.gid " +
                "and o.bid=b.id " +
                "and o.oid="+oid;
        List list = orderListDAO.findByHql(hql);
        Iterator iterator = list.iterator();
        OrderInfo shipDetail=null;
        while(iterator.hasNext()){
            Object object[] = (Object[])iterator.next();
            shipDetail= new OrderInfo((Goods) object[0],(Buyer) object[1],(OrderList) object[2]);
        }
        session.put("shipDetail",shipDetail);
    }

    public boolean ship(int shipid){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        OrderInfo shipDetail = (OrderInfo)session.get("shipDetail");
        OrderList orderList = shipDetail.getOrderList();
        orderList.setShipstate("已发货");
        try{
            orderListDAO.update(orderList);
            shipDetail.setOrder(orderList);
            session.put("shipDetail",shipDetail);
            session.put("shipMeg","success");
            return true;
        }catch (Exception e) {
            session.put("shipMeg", "fail");
            return false;
        }
    }
}
