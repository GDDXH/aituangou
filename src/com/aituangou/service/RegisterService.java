package com.aituangou.service;

import com.aituangou.dao.BuyerDAO;
import com.aituangou.dao.impl.ISellerDAO;
import com.aituangou.dao.impl.IShopDAO;
import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.impl.IRegisterService;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class RegisterService implements IRegisterService {
    private Map<String, Object> session;
    private ISellerDAO sellerDAO = null;
    private IShopDAO shopDAO = null;
	private BuyerDAO buyerDAO = null;
	
    public BuyerDAO getBuyerDAO() {
		return buyerDAO;
	}

	public void setBuyerDAO(BuyerDAO buyerDAO) {
		this.buyerDAO = buyerDAO;
	}
	
    public void setSellerDAO(ISellerDAO sellerDAO) {
        this.sellerDAO = sellerDAO;
    }

    public void setShopDAO(IShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }
    
	public void register(Buyer registerUser){
    	buyerDAO.save(registerUser);
    }


    public boolean register(Seller registerUser){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        Shop shop = createShop();
        registerUser.setShop(shop);
        try{
            sellerDAO.save(registerUser);
            session.put("loginSeller",registerUser);
            return true;
        }catch (Exception e) {
            session.put("registerError", "fail");
            return false;
        }
    }

    private Shop createShop(){
        Shop shop = new Shop();
        try{
            shop = shopDAO.createShop(shop);
            return shop;
        }catch (Exception e){
            return null;
        }
    }
}
