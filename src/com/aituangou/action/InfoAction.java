package com.aituangou.action;

import com.aituangou.po.Buyer;
import com.aituangou.service.InfoService;
import com.aituangou.service.RegisterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class InfoAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer loginUser;
	private InfoService infoService = null;
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = (Map)context.getSession();

    public void setLoginUser(Buyer loginUser) {
        this.loginUser = loginUser;
    }

    public Buyer getLoginUser() {
        return loginUser;
    }

    public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public String update(){
        Buyer temp = (Buyer)session.get("loginUser");
        int flag = 0;
        if((temp.getName()==null || !temp.getName().equals(loginUser.getName())) && loginUser.getName()!= null){
            temp.setName(loginUser.getName());
            flag = 1;
        }
        if((temp.getTelephone()==null || !temp.getTelephone().equals(loginUser.getTelephone())) && loginUser.getName()!=null){
            temp.setTelephone(loginUser.getTelephone());
            flag = 1;
        }
        if((temp.getAddress()==null || !temp.getAddress().equals(loginUser.getAddress())) && loginUser.getAddress()!=null)
        {
        	temp.setAddress(loginUser.getAddress());
        	 flag = 1;
        }
        if(flag == 1){
            try{
                infoService.update(temp);
            }catch (Exception e){
                e.printStackTrace();
                session.put("updateError","fail");
                return "fail";
            }finally {
                flag = 0;
            }
            session.put("loginUser",temp);
            session.put("updateError","success");
            return "success";
        }
        session.put("updateError","no");
        return "no";
    }
}
