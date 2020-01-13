package com.aituangou.action;

import com.aituangou.po.Seller;
import com.aituangou.po.Shop;
import com.aituangou.service.ChangeInfoService;
import com.aituangou.service.impl.IChangeInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ChangeInfoAction extends ActionSupport {
    private Seller loginUser;
    private Shop shop;
    private String oldPass;
    private String password;
    private String repassword;
    private IChangeInfoService changeInfoService = null;

    public void setChangeInfoService(IChangeInfoService changeInfoService) {
        this.changeInfoService = changeInfoService;
    }

    public Seller getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Seller loginUser) {
        this.loginUser = loginUser;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String changeInfo(){
        if(changeInfoService.changeInfo(loginUser,shop)){
            return "success";
        }else {
            return "fail";
        }
    }

    public String changePass(){
        if(changeInfoService.changePass(password)){
            return "success";
        }else {
            return "fail";
        }
    }

    public void validateChangeInfo(){
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        String name = loginUser.getName();
        String telephone = loginUser.getTelephone();
        String shopName = shop.getName();
        if(name == null || name.equals("")){
            session.put("changeInfoError","name");
            this.addActionError("name");
        }else if(telephone == null || telephone.equals("")){
            session.put("changeInfoError","telephone");
            this.addActionError("telephone");
        }else if(shopName == null || shopName.equals("")){
            session.put("changeInfoError","shopName");
            this.addActionError("shopName");
        }
    }

    public void validateChangePass(){
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = (Map<String, Object>)context.getSession();
        String oldPass = this.oldPass;
        String password = this.password;
        String repassword = this.repassword;
        Seller seller = (Seller) session.get("loginSeller");
        if (oldPass == null || oldPass.equals("")){
            session.put("changePassError","oldPass");
            this.addActionError("oldPass");
        }else if(!oldPass.equals(seller.getPassword())){
            session.put("changePassError","oldPassError");
            this.addActionError("oldPassError");
        }else if(password == null || password.equals("")){
            session.put("changePassError","password");
            this.addActionError("password");
        }else if(repassword == null || repassword.equals("")){
            session.put("changePassError","repassword");
            this.addActionError("repassword");
        }else if(!repassword.equals(repassword)){
            session.put("changePassError","not_equal");
            this.addActionError("not_equal");
        }
    }
}
