package action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PageAction extends ActionSupport {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(PageAction.class);
 
	public String apropos() {
		logger.info("CHARGEMENT PAGE A PROPOS");
		return SUCCESS;
	}
	
	public String contact() {
		logger.info("CHARGEMENT PAGE CONTACT");
		return SUCCESS;
	}
	public String inscription() {
		logger.info("CHARGEMENT PAGE INSCRIPTION");
		return SUCCESS;
	}
}
