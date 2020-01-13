package com.aituangou.action;

import java.util.List;
import java.util.Map;

import com.aituangou.po.Buyer;
import com.aituangou.service.BuyerService;
import com.aituangou.service.impl.IBuyerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyerAction extends ActionSupport{
	private List buyers;
	private Buyer buyer;
	private IBuyerService buyerService = null;
	ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();
    
	public List getBuyers() {
		return buyers;
	}
	public void setBuyers(List buyers) {
		this.buyers = buyers;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	
	public IBuyerService getBuyerService() {
		return buyerService;
	}
	public void setBuyerService(IBuyerService buyerService) {
		this.buyerService = buyerService;
	}
	public String findBuyer(){
		buyers = buyerService.getBuyers();
		System.out.println("Buyer Action findBuyers!"); 
		return "success";
	}
	public String findBuyerDetails(){
		buyer = buyerService.getBuyerDetails(buyer);
		return "success";
	}
	public String addBuyer(){
		if(buyerService.save(buyer))
			return "success";
		return "fail";
	}
	public String updBuyer(){
		if(buyerService.update(buyer))
			return "success";
		return "fail";
	}
	public String delBuyer(){
		buyerService.delete(buyer);
		return "success";
	}
    public void validateAddBuyer(){
        String id = buyer.getId();
        String password = buyer.getPassword();
        if(id == null || id.equals("")){
        	session.put("loginError","id");
        }
        if(password == null || password.equals("")){
            session.put("loginError","password");
        }
        buyers = buyerService.getBuyers();
    }
}
