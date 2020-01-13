package com.aituangou.action;

import com.aituangou.po.Buyer;
import com.aituangou.po.Seller;
import com.aituangou.service.impl.IRegisterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class RegisterAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer registerUser;
	private Seller registerSeller;
	private IRegisterService registerService = null;
	
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();

    public void setRegisterUser(Buyer registerUser) {
        this.registerUser = registerUser;
    }

    public Buyer getRegisterUser() {
        return registerUser;
    }

	public Seller getRegisterSeller() {
		return registerSeller;
	}

	public void setRegisterSeller(Seller registerSeller) {
		this.registerSeller = registerSeller;
	}

	public IRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	public String register(){
        try{
            registerService.register(registerUser);
        }catch (Exception e){
            e.printStackTrace();
            session.put("registerError","fail");
            return "fail";
        }
        session.put("loginUser",registerUser);
        return "success";
    }
	
    public void validateRegister(){
        String id = registerUser.getId();
        String password = registerUser.getPassword();
        String repassword = registerUser.getRepassword();
        if(id == null || id.equals("")){
            session.put("registerError","id");
            this.addActionError("id");
        }else if(password == null || password.equals("")){
            session.put("registerError","password");
            this.addActionError("password");
        }else if(!password.equals(repassword)){
            session.put("registerError","repassword");
            this.addActionError("repassword");
        }
    }
    
    public String sellerRegister(){
        if(registerService.register(registerSeller)){
            return "success";
        }else {
            return "fail";
        }
    }
    
    public void validateSellerRegister(){
        String id = registerSeller.getId();
        String password = registerSeller.getPassword();
        String repassword = registerSeller.getRepassword();
        if(id == null || id.equals("")){
            session.put("registerError","id");
            this.addActionError("id");
        }else if(password == null || password.equals("")){
            session.put("registerError","password");
            this.addActionError("password");
        }else if(!password.equals(repassword)){
            session.put("registerError","repassword");
            this.addActionError("repassword");
        }
    }

}
