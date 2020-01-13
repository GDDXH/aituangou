package com.aituangou.service.impl;

import java.util.List;

import com.aituangou.po.Admin;

public interface IAdminService {
	public List getAdmins();
	public void update(Admin admin);
	public void delete(Admin admin);
	public boolean save(Admin admin);
}
