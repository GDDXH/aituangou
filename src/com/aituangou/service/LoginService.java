package com.aituangou.service;


import com.aituangou.dao.AdminDAO;
import com.aituangou.dao.BuyerDAO;
import com.aituangou.dao.SellerDAO;
import com.aituangou.dao.impl.IAdminDAO;
import com.aituangou.dao.impl.IBuyerDAO;
import com.aituangou.dao.impl.ISellerDAO;
import com.aituangou.po.Admin;
import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;
import com.aituangou.service.impl.ILoginService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class LoginService implements ILoginService{
	private IBuyerDAO buyerDAO = null;
	private IAdminDAO adminDAO = null;
	private Map<String, Object> request, session;
    

	public IBuyerDAO getBuyerDAO() {
		return buyerDAO;
	}

	public void setBuyerDAO(IBuyerDAO buyerDAO) {
		this.buyerDAO = buyerDAO;
	}

	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}



	public List login(Buyer loginUser){
        String id = loginUser.getId();
        String password = loginUser.getPassword();
        String hql = "from Buyer where bid='" +id+ "' and bpasw='" + password +"'";
        List list = buyerDAO.find(hql);
        if(list.isEmpty())
            return null;
        else
            return list;
    }
	 public boolean login(Admin loginUser){
			ActionContext ctx= ActionContext.getContext(); 
			session=(Map) ctx.getSession(); 
			request=(Map) ctx.get("request"); 
			String aid = loginUser.getAid();
			String apasw = loginUser.getApasw();
			String hql = "from Admin as admin where aid='" + aid + "' and apasw='" + apasw + "'"; 
			List list = adminDAO.find(hql);
			//dao.getSession().close(); 
			if (list.isEmpty()) 
				return false;
			else{ 
				request.put("tip", "��¼�ɹ���"); 
				loginUser=(Admin)list.get(0); 
				session.put("loginUser", loginUser); 
				return true;
			} 
	 }


	 
}
