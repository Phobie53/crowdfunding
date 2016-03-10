package action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 521602025772L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(HomeAction.class);
 
	public String afficher() {
		logger.info("CHARGEMENT PAGE HOME");
		return SUCCESS;
	}
}
