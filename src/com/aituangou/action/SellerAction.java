package com.aituangou.action;

import java.util.List;
import java.util.Map;

import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.SellerService;
import com.aituangou.service.impl.ISellerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SellerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List sellers;
	private Seller seller;
	private Shop shop;
	private ISellerService sellerService = null;
	ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();
	public List getSellers() {
		return sellers;
	}
	public void setSellers(List sellers) {
		this.sellers = sellers;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public ISellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(ISellerService sellerService) {
		this.sellerService = sellerService;
	}
	public ActionContext getContext() {
		return context;
	}
	public void setContext(ActionContext context) {
		this.context = context;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String findSeller(){
		sellers = sellerService.getSellers();
		System.out.println("Seller Action findSellers!"); 
		return "success";
	}
	public String findSellerDetails(){
		seller = sellerService.getSellerDetails(seller);
		return "success";
	}
	public String addSeller(){
		if(sellerService.save(seller))
			return "success";
		return "fail";
	}
	public String updSeller(){
		if(sellerService.update(seller))
			return "success";
		return "fail";
	}
	public String delSeller(){
		sellerService.delete(seller);
		return "success";
	}
	
	public String getSellersDetails(){
		if(sellerService.getSellersDetails().isEmpty())
			return "fail";
		return "success";
	}
    public void validateAddSeller(){
        String id = seller.getId();
        String password = seller.getPassword();
        if(id == null || id.equals("")){
        	session.put("loginError","id");
        }
        if(password == null || password.equals("")){
            session.put("loginError","password");
        }
        sellers = sellerService.getSellers();
    }
}
