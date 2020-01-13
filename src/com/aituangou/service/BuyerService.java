package com.aituangou.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aituangou.dao.BuyerDAO;
import com.aituangou.po.Buyer;
import com.aituangou.service.impl.IBuyerService;
import com.opensymphony.xwork2.ActionContext;

public class BuyerService implements IBuyerService {
	private List buyers = new ArrayList();
	private BuyerDAO buyerDAO = null;
	private Map<String, Object> request, session;
	public BuyerService(){
		System.out.println("create BuyerService"); 
	}
	
	public BuyerDAO getBuyerDAO() {
		return buyerDAO;
	}

	public void setBuyerDAO(BuyerDAO buyerDAO) {
		this.buyerDAO = buyerDAO;
	}

	public List getBuyers() {
		String hql = "from Buyer";
		List list = buyerDAO.find(hql);
		buyers = list;
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		request.put("buyers", buyers); 
		if(list==null)
			System.out.println("buyers list is null"); 
		return list;
	}
	public Buyer getBuyerDetails(Buyer buyer){
		buyer = (Buyer) buyerDAO.findById(buyer.getId()).get(0);
		ActionContext ctx = ActionContext.getContext();
		session=(Map) ctx.getSession(); 
		request=(Map) ctx.get("request"); 
		request.put("buyerDetails", buyer); 
		return buyer;
	}
	public boolean update(Buyer buyer) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request");
		
		if(buyerDAO.update(buyer)){
			request.put("tip", "更改会员信息成功!");
			buyer = getBuyerDetails(buyer);
			request.put("buyerDetails", buyer);
			request.put("upinfor","success");
			return true;
		}
		request.put("tip", "更改会员信息失败!");
		request.put("buyerDetails", buyer);		
		request.put("upinfor","fail");
		return false;
		
	}
	public void delete(Buyer buyer) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		buyer = (Buyer) buyerDAO.findById(buyer.getId()).get(0);
		buyerDAO.delete(buyer);
		buyers=getBuyers();
		request.put("buyers", buyers);
		request.put("tip", "删除成功!");
		request.put("delinfor","success");
	}
	public boolean save(Buyer buyer) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		if(buyerDAO.save(buyer)){
			request.put("tip", "添加会员成功!");
			buyers = getBuyers();
			request.put("buyers", buyers);
			request.put("addinfor","success");
			return true;
		}
		request.put("tip", "添加会员失败!");
		buyers = getBuyers();
		request.put("buyers", buyers);
		request.put("addinfor","fail");
		return false;
	}

}
