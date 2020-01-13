package com.aituangou.action;

import java.util.Map;

import com.aituangou.po.Seller;
import com.aituangou.service.impl.ISellerLoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SellerLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ISellerLoginService sellerLoginService = null;
    private Seller seller;



	public ISellerLoginService getSellerLoginService() {
		return sellerLoginService;
	}

	public void setSellerLoginService(ISellerLoginService sellerLoginService) {
		this.sellerLoginService = sellerLoginService;
	}

	public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String sellerLogin(){
        if(sellerLoginService.sellerLogin(seller)){
            return "success";
        }else {
            return "fail";
        }
    }

    public void validateSellerLogin(){
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        String id = seller.getId();
        String password = seller.getPassword();
        if(id == null || id.equals("")){
            session.put("loginError","id");
            this.addActionError("id");
        }else if(password == null || password.equals("")){
            session.put("loginError","password");
            this.addActionError("password");
        }
    }
}
