package com.aituangou.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aituangou.dao.SellerDAO;
import com.aituangou.dao.ShopDAO;
import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.impl.ISellerService;
import com.opensymphony.xwork2.ActionContext;

public class SellerService implements ISellerService {
	private List sellers = new ArrayList();
	private SellerDAO sellerDAO = null;
	private ShopDAO shopDAO = null;
	private Map<String, Object> request, session;
	public SellerService(){
		System.out.println("create SellerService"); 
	}
	public void setSellerDAO(SellerDAO sellerDAO){
		this.sellerDAO = sellerDAO;
	}
	public void setShopDAO(ShopDAO shopDAO){
		this.shopDAO = shopDAO;
	}
	public List getSellers() {
		String hql = "from Seller";
		List list = sellerDAO.find(hql);
		sellers = list;
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		request.put("sellers", sellers); 
		if(list==null)
			System.out.println("sellers list is null"); 
		return list;
	}
	public Seller getSellerDetails(Seller transientInstance) {
		transientInstance = (Seller) sellerDAO.findById(transientInstance.getId()).get(0);
		transientInstance.setShop((Shop)shopDAO.findById(transientInstance.getShop().getShopid()).get(0));
		ActionContext ctx = ActionContext.getContext();
		session=(Map) ctx.getSession(); 
		request=(Map) ctx.get("request"); 
		request.put("sellerDetails", transientInstance); 
		return transientInstance;
	}
	

	
	public List<Seller> getSellersDetails() {
		List sellers=getSellers();
		List<Seller> sellersDetails=new ArrayList<Seller>(); 
		for(int i=0;i<sellers.size();i++)
		{
			Seller transientInstance=(Seller) sellers.get(i);
		transientInstance = (Seller) sellerDAO.findById(transientInstance.getId()).get(0);
		transientInstance.setShop((Shop)shopDAO.findById(transientInstance.getShop().getShopid()).get(0));
		sellersDetails.add(transientInstance);
		}
		ActionContext ctx = ActionContext.getContext();
		session=(Map) ctx.getSession(); 
		request=(Map) ctx.get("request"); 
		request.put("sellersDetails", sellersDetails); 
		return sellersDetails;
		
	}

	public boolean update(Seller transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		if(sellerDAO.update(transientInstance)){//&&shopDAO.update(transientInstance.getShop())){
			request.put("tip", "����������Ϣ�ɹ�!");
			transientInstance = getSellerDetails(transientInstance);
			request.put("sellerDetails", transientInstance);
			request.put("upinfor", "success");
			return true;
		}
		request.put("upinfor", "fail");
		request.put("tip", "����������Ϣʧ��!");
		request.put("sellerDetails", transientInstance);
		return false;
	}

	public void delete(Seller transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		transientInstance = (Seller) sellerDAO.findById(transientInstance.getId()).get(0);
		sellerDAO.delete(transientInstance);
		sellers = getSellers();
		request.put("sellers", sellers);
		request.put("delinfor", "success");
		request.put("tip", "ɾ���ɹ�!");
	}

	public boolean save(Seller transientInstance) {
		ActionContext ctx = ActionContext.getContext();
		request=(Map) ctx.get("request"); 
		if(sellerDAO.save(transientInstance)){
			request.put("tip", "������ҳɹ�!");
			sellers = getSellers();
			request.put("sellers", sellers);
			request.put("addinfor", "success");
			return true;
		}
		request.put("tip", "�������ʧ��!");
		sellers = getSellers();
		request.put("addinfor", "fail");
		request.put("sellers", sellers);
		return false;
	}

}
