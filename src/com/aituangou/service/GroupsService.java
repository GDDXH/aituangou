package com.aituangou.service;


import java.util.List;

import com.aituangou.dao.GroupsDAO;
import com.aituangou.po.GGoods;
import com.aituangou.po.Goods;
import com.aituangou.po.Groups;
import com.aituangou.po.OrderList;

public class GroupsService {
	private GroupsDAO groupsDAO = null;
	
	public GroupsDAO getGroupsDAO() {
		return groupsDAO;
	}
	public void setGroupsDAO(GroupsDAO groupsDAO) {
		this.groupsDAO = groupsDAO;
	}
	public void addGroup(Groups group) {
		groupsDAO.save(group);
	}

	@SuppressWarnings("unchecked")
	public List<Groups> findGroups(Groups group) {
		 String hql = "from Groups where goodId="+group.getGoodId() +" and bid1<>'"+group.getBid1()+"'";
	     return groupsDAO.find(hql);
	}
	public void deleteGroup(int groupId) {
		groupsDAO.delete(groupId);
	}
	public void addOrder(OrderList order) {
		groupsDAO.saveOrder(order);
	}
	public GGoods findGGoodById(int gid) {
		return groupsDAO.findGGoodById(gid);
	}
	public Object findGoodById(int id) {
		return groupsDAO.findGoodById(id);
	}
	public Groups findGroup(int groupId) {
		 String hql = "from Groups groups where groups.groupId="+groupId;
		return (Groups) groupsDAO.find(hql).get(0);
	}
	public int findMaxOrderId() {
		return groupsDAO.findMaxOrderId();
	}
}
