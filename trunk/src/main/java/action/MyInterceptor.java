package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import model.Utilisateur;
 
public class MyInterceptor implements Interceptor{

        //called during interceptor destruction
	public void destroy() {
		System.out.println("CustomInterceptor destroy() is called...");
	}

	//called during interceptor initialization
	public void init() {
		System.out.println("CustomInterceptor init() is called...");
	}

	//put interceptor code here
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("inside auth interceptor");
        
        Map session = invocation.getInvocationContext().getSession();
        
        System.out.println(session);
		
		String result = invocation.invoke();
		
		System.out.println("CustomInterceptor, after invocation.invoke()...");
		
		return result;
	}
		
}