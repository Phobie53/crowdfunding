package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDAO;
import model.Utilisateur;
import service.UtilisateurService;

@Controller
public class UtilisateurAction extends ActionSupport {
	
	private Utilisateur utilisateur;

	@Autowired
	private UtilisateurService utilisateurService;

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(UtilisateurAction.class);
	
	public String connexion() {
		logger.info("CHARGEMENT PAGE CONNEXION");
		return SUCCESS;
	}
	
	public String deconnexion() {
		logger.info("CHARGEMENT PAGE DECONNEXION");
		return SUCCESS;
	}
	
	public String inscription() {
		logger.info("CHARGEMENT PAGE INSCRIPTION");
		return SUCCESS;
	}
	
	public String validerInscription() {
		logger.info("VALIDATION INSCRIPTION");
		
		utilisateurService.sauvegarderUtilisateur(utilisateur);
		
		return SUCCESS;
	}
	
	public String monCompte() {
		logger.info("CHARGEMENT PAGE MON COMPTE");
		return SUCCESS;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setCustomerService(final UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
}
