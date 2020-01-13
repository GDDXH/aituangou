package com.aituangou.action;

import java.security.acl.Group;
import java.util.Map;

import com.aituangou.po.Cart;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;
import com.aituangou.service.impl.ISubmitOrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;





public class SubmitOrderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderList order;
	private Cart cart;
	private ISubmitOrderService submitOrderService=null;
	public OrderList getOrder() {
		return order;
	}

	public void setOrder(OrderList order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ISubmitOrderService getSubmitOrderService() {
		return submitOrderService;
	}

	public void setSubmitOrderService(ISubmitOrderService submitOrderService) {
		this.submitOrderService = submitOrderService;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String buyNow() {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
		order.setSumPrice(order.getPrice()*order.getNum());
		order.setRecstate("未付款");
		order.setShipstate("未发货");
		Goods good = submitOrderService.findGoodById(order.getGid());
		session.put("submitOrderGood",good);
		session.put("submitOrder", order);
		return "success";
	}
	
	public String settlement() {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        //System.out.println("cart.getCid():"+cart.getCid());
		//System.out.println("order.getBid():"+order.getBid());
		//System.out.println("order.getShopid():"+order.getShopid());
		//System.out.println("order.getPrice():"+order.getPrice());
		//System.out.println("order.getNum():"+order.getNum());
		order.setSumPrice(order.getPrice()*order.getNum());
		order.setRecstate("未付款");
		order.setShipstate("未发货");
		Goods good = submitOrderService.findGoodById(order.getGid());
		submitOrderService.deleteCart(cart);
		session.put("submitOrderGood",good);
		session.put("submitOrder", order);
		return "success";
	}
	
	public String submitOrder()
	{
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        OrderList order = (OrderList)session.get("submitOrder");
        if(session.get("ifGroupBuy")!=null&&(int)session.get("ifGroupBuy")==1)
        {
        	if((Groups)session.get("group")!=null)
        	{
            	submitOrderService.addGroup((Groups)session.get("group"));
            	order.setRecstate("已付款但团人数不足");
            	session.put("ifGroupBuy",0);
            	session.remove("group");
        	}
        	else
        	{
        		return "fail";
        	}

        }
        else if(session.get("ifGroupBuy")!=null&&(int)session.get("ifGroupBuy")==2)
        {
        	if((Groups)session.get("group")!=null)
        	{
        		Groups group = (Groups)session.get("group");
        		String recstate = "已付款且团人数满足";
        		submitOrderService.updateOrderRecstateByOid(group.getOid1(),recstate);
            	submitOrderService.deleteGroup(((Groups)session.get("group")));
            	
            	order.setRecstate("已付款且团人数满足");
            	session.put("ifGroupBuy",0);
            	session.remove("group");
        	}
        	else
        	{
        		return "fail";
        	}
        }
        else {
        	order.setRecstate("已付款");
		}
        	
		Goods good = (Goods) session.get("submitOrderGood");
		if(good.getNum()-order.getNum() < 0)
			return "fail";
		good.setNum(good.getNum()-order.getNum());
		good.setSales(good.getSales()+order.getNum());
		submitOrderService.addOrder(order);
		submitOrderService.updateGood(good);
		return "success";
	}
}
