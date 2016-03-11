package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
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
	
	public String mesProjets() {
		logger.info("CHARGEMENT PAGE MES PROJETS");
		return SUCCESS;
	}
	
	public String afficherFormCreation() {
		logger.info("CHARGEMENT PAGE FORMULAIRE CREATION");
		return SUCCESS;
	}
	
	public String afficherFormModification() {
		logger.info("CHARGEMENT PAGE FORMULAIRE MODIFICATION" );
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		
		final String idProjetString = request.getParameter("idProjet");
		if (idProjetString != null) {
			final Long idProjet = Long.parseLong(idProjetString);
			if (idProjet != null) {
				logger.info("id : " + idProjet );
			}
		}
		return SUCCESS;
	}
	
	public String listeProjets() {
		logger.info("CHARGEMENT PAGE LISTE PROJET");
		return SUCCESS;
	}
}
