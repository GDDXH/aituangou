package com.aituangou.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.aituangou.dao.AdminDAO;
import com.aituangou.dao.impl.IAdminDAO;
import com.aituangou.po.Admin;
import com.aituangou.service.impl.IAdminService;
import com.opensymphony.xwork2.ActionContext;

public class AdminService implements IAdminService{
	private List admins = new ArrayList();
	private AdminDAO adminDAO = null;
	private Map<String, Object> request, session;
	public AdminService(){ 
		System.out.println("create AdminService"); 
	}
	public void setAdminDAO(AdminDAO adminDAO) { 
		this.adminDAO = adminDAO; 
	} 
	@SuppressWarnings("unchecked")
	public List getAdmins() { 
		String hql = "from Admin";	
		List list = adminDAO.find(hql);
		admins = list;
		ActionContext ctx = ActionContext.getContext();
		session=(Map<String, Object>) ctx.getSession();
		request=(Map<String, Object>) ctx.get("request"); 
		session.put("admins",list);
		request.put("admins", list); 
		return list;
	}
	public void update(Admin admin) {
		adminDAO.update(admin);
	}
	public boolean save(Admin admin) { 
		ActionContext ctx = ActionContext.getContext();
		request=(Map<String, Object>) ctx.get("request"); 
		if(adminDAO.save(admin)){
			request.put("tip", "添加管理员成功!");
			admins=getAdmins();
			request.put("admins", admins);
			return true;
		}
		request.put("tip", "添加管理员失败!");
		admins=getAdmins();
		request.put("admins", admins);
		return false;
	}
	@SuppressWarnings("unchecked")
	public void delete(Admin admin){
		ActionContext ctx = ActionContext.getContext();
		request=(Map<String, Object>) ctx.get("request"); 
		admin = (Admin) adminDAO.findById(admin.getAid());
		adminDAO.delete(admin);
		admins=getAdmins();
		request.put("admins", admins);
		request.put("tip", "删除成功!");
	}
}
