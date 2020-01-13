package com.aituangou.action;

import com.aituangou.po.Buyer;
import com.aituangou.service.LoginService;
import com.aituangou.service.impl.ILoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class BuyerLoginAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Buyer loginUser;
	private ILoginService loginService = null;
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map<String, Object>)context.getSession();

    public Buyer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Buyer loginUser){
        this.loginUser = loginUser;
    }
    
   
	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String login(){
        try{
            loginUser = (Buyer) loginService.login(loginUser).get(0);
        }catch (Exception e){
            e.printStackTrace();
            session.put("loginError","fail");
            return "fail";
        }
        session.put("loginUser",loginUser);
        return "success";
    }
    public String exit(){
        session.put("loginUser",null);
        return "exit";
    }

    public void validateLogin(){
        String id = loginUser.getId();
        String password = loginUser.getPassword();
        if(id == null || id.equals("")){
            session.put("loginError","id");
            this.addActionError("id");
        }else if(password == null || password.equals("")){
            session.put("loginError","password");
            this.addActionError("password");
        }
    }
}
