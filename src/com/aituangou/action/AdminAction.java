package com.aituangou.action;

import java.util.List;

import com.aituangou.po.Admin;
import com.aituangou.service.AdminService;
import com.aituangou.service.impl.IAdminService;

public class AdminAction { 
	private List admins; 
	private Admin admin;
	private IAdminService adminService = null;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List getAdmins() {
		return admins;
	}
	public void setAdmins(List admins) {
		this.admins = admins;
	}
	
	
	public IAdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	public String findAdmin() { 
		admins = adminService.getAdmins(); 
		System.out.println("Admin Action finAdmin!"); 
		return "success"; 
	}
	public String delAdmin(){
		adminService.delete(admin);
		return "success";
	}
	public String addAdmin(){
		if(adminService.save(admin))
			return "success";
		else return "fail";
	}
} 