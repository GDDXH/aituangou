package com.aituangou.interceptors;
import java.util.Map; 
import com.opensymphony.xwork2.Action; 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionInvocation; 
import com.opensymphony.xwork2.interceptor.AbstractInterceptor; 

public class AuthorityInterceptor extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception { 
		System.out.println("Authority Interceptor executed!"); 
		ActionContext ctx = invocation.getInvocationContext(); 
		Map session = ctx.getSession(); 
		if(session.get("loginUser")!=null){ 
			return invocation.invoke(); 
		} 
		else{ 
			ctx.put("tip", "����û�е�¼���������û����������¼ϵͳ"); 
			/* ctx.getApplication().put("", "");//application������ 
			 * ctx.getSession().put("", "");//session������ 
			 * ctx.put("", ""); //request������ */ 
			return Action.LOGIN; 
		} 
	}
}
