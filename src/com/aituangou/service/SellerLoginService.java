package com.aituangou.service;

import java.util.List;
import java.util.Map;

import com.aituangou.dao.impl.ISellerDAO;
import com.aituangou.po.Seller;
import com.aituangou.service.impl.ISellerLoginService;
import com.opensymphony.xwork2.ActionContext;

public class SellerLoginService implements ISellerLoginService {
	private ISellerDAO sellerDAO = null;
	private Map<String, Object> request, session;

	public ISellerDAO getSellerDAO() {
		return sellerDAO;
	}


	public void setSellerDAO(ISellerDAO sellerDAO) {
		this.sellerDAO = sellerDAO;
	}



	public boolean sellerLogin(Seller seller){
		ActionContext ctx = ActionContext.getContext();
		session=(Map<String, Object>) ctx.getSession();
        String id = seller.getId();
        String password = seller.getPassword();
        String hql = "from Seller as user where id='" + id + "' and password='" + password + "'";
        List list = sellerDAO.findByHql(hql);
        if (list.isEmpty()){
            session.put("loginError","fail");
            return false;
        } else{
            seller = (Seller) list.get(0);
            //System.out.println("sellerLogin"+seller.getShop().getShopid());
            session.put("loginSeller", seller);
            return true;
        }
    }
}
