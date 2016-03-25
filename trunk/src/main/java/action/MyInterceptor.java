package action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

 
public class MyInterceptor implements Interceptor{

	private static final Logger logger = Logger.getLogger(MyInterceptor.class);
	
        //called during interceptor destruction
	public void destroy() {
		logger.info("CustomInterceptor destroy() is called...");
	}

	//called during interceptor initialization
	public void init() {
		logger.info("CustomInterceptor init() is called...");
	}

	//put interceptor code here
	public String intercept(ActionInvocation invocation) throws Exception {
		
		logger.info("inside auth interceptor");
        
        Map session = invocation.getInvocationContext().getSession();
        
        logger.info(session);
		
		String result = invocation.invoke();
		
		logger.info("CustomInterceptor, after invocation.invoke()...");
		
		return result;
	}
		
}