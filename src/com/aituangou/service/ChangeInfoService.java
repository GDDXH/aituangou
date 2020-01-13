package com.aituangou.service;

import com.aituangou.dao.impl.ISellerDAO;
import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.impl.IChangeInfoService;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class ChangeInfoService implements IChangeInfoService {
    private Map<String, Object> session;
    private ISellerDAO sellerDAO = null;

    public void setSellerDAO(ISellerDAO sellerDAO) {
        this.sellerDAO = sellerDAO;
    }

    public boolean changeInfo(Seller loginUser, Shop shop){
        ActionContext context = ActionContext.getContext();
        session = (Map) context.getSession();
        Seller seller = loginUser;
        seller.setName(loginUser.getName());
        seller.setTelephone(loginUser.getTelephone());
        Shop shop1 = seller.getShop();
        shop1.setName(shop.getName());
        seller.setShop(shop1);
        try{
            sellerDAO.update(seller);
            session.put("loginSeller",seller);
            session.put("changeInfo","success");
            return true;
        }catch (Exception e){
            session.put("changeInfo","fail");
            return false;
        }
    }

    public boolean changePass(String password){
        ActionContext context = ActionContext.getContext();
        session = (Map<String, Object>) context.getSession();
        Seller seller = (Seller) session.get("loginSeller");
        seller.setPassword(password);
        try{
            sellerDAO.update(seller);
            session.put("loginSeller",seller);
            session.put("changePass","success");
            return true;
        }catch (Exception e) {
            session.put("changePass", "fail");
            return false;
        }
    }
}
