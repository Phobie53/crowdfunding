package action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ProjetAction extends ActionSupport {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(ProjetAction.class);
 
	public String detailProjet() {
		logger.info("CHARGEMENT PAGE DETAIL PROJET");
		return SUCCESS;
	}
	
	public String listeProjets() {
		logger.info("CHARGEMENT PAGE LISTE PROJET");
		return SUCCESS;
	}
}
