package com.aituangou.action;

import java.util.List;
import java.util.Map;


import com.aituangou.po.Buyer;
import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;
import com.aituangou.service.GroupsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GroupsAction extends ActionSupport {
	private OrderList order;
	private Groups group;
	private List<Groups> groups; 
	private static final long serialVersionUID = 1L;
	private GroupsService groupsService = null;

    
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}

    public GroupsService getGroupsService() {
		return groupsService;
	}
    
	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}
	
	public OrderList getOrder() {
		return order;
	}
	
	public void setOrder(OrderList order) {
		this.order = order;
	}
	
	public List<Groups> getGroups() {
		return groups;
	}
	
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	
	public String addGroup() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>)context.getSession();
		order.setNum(1);
		order.setRecstate("未付款");
		order.setShipstate("未发货");
		GGoods ggood = groupsService.findGGoodById(order.getGid());
		order.setPrice(ggood.getGprice());
		order.setSumPrice(order.getPrice()*order.getNum());
		session.put("submitOrderGood",groupsService.findGoodById(ggood.getId()));
		session.put("submitOrder", order);
		session.put("ifGroupBuy", 1);
		session.put("group", group);
    	return "success";
    }

    public String joinGroup() {
    	ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>)context.getSession();
		int oid = groupsService.findMaxOrderId()+1;
		order.setOid(oid);
		order.setNum(1);
		order.setRecstate("未付款");
		order.setShipstate("未发货");
		GGoods ggood = groupsService.findGGoodById(order.getGid());
		order.setPrice(ggood.getGprice());
		order.setSumPrice(order.getPrice()*order.getNum());
		group = groupsService.findGroup(group.getGroupId());
		session.put("submitOrderGood",groupsService.findGoodById(ggood.getId()));
		session.put("submitOrder", order);
		session.put("ifGroupBuy", 2);
		session.put("group", group);
    	return "success";
    }
}
