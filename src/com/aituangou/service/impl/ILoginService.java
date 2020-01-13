package com.aituangou.service.impl;

import java.util.List;

import com.aituangou.po.Admin;
import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;

public interface ILoginService {
	public boolean login(Admin transientInstance);
	public List login(Buyer loginUser);

}
