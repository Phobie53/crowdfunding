package action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class UtilisateurAction extends ActionSupport {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(UtilisateurAction.class);
 
	public String connexion() {
		logger.info("CHARGEMENT PAGE CONNEXION");
		return SUCCESS;
	}
	
	public String inscription() {
		logger.info("CHARGEMENT PAGE INSCRIPTION");
		return SUCCESS;
	}
}
