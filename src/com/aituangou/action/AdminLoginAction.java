package com.aituangou.action;

import java.util.Map;

import com.aituangou.po.Admin;
import com.aituangou.service.LoginService;
import com.aituangou.service.impl.ILoginService;
import com.opensymphony.xwork2.ActionContext;

public class AdminLoginAction {
	private Admin loginUser;
	private ILoginService loginService = null;

    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();

    public Admin getLoginUser() {
        return loginUser;
    }
	public void setLoginUser(Admin loginUser){
        this.loginUser = loginUser;
    }
   
	
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	public String login(){
		if (loginService.login(loginUser))
			return "success";
		else
			return "fail";
    }
    public String exit(){
        session.put("loginUser",null);
        return "exit";
    }
    public void validateLogin(){
        String id = loginUser.getAid();
        String password = loginUser.getApasw();
        if(id == null || id.equals("")){
            session.put("loginError","id"); 
        }
        if(password == null || password.equals("")){
            session.put("loginError","password");   
        }
    }
}
