package action;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Form;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UtilisateurDAO;
import model.Utilisateur;
import service.UtilisateurService;

@Controller
public class UtilisateurAction extends ActionSupport implements RequestAware, SessionAware {
	
	private Utilisateur utilisateur;
	
	protected Map session;
	protected Map request;

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
		boolean isInscriptionReussie = false;
		
		if (verificationFormulaire() == null) {
			isInscriptionReussie = utilisateurService.sauvegarderUtilisateur(utilisateur);
			
			//On ajoute en session l'objet utilisateur
			Map<String, Object> inMap = new HashMap<String, Object>();
			inMap.put("user", utilisateur);
			ActionContext.getContext().setSession(inMap);
			//Pour récupérer l'objet en session
			//Map<String, Object> outMap = ActionContext.getContext().getSession();
			//logger.info(((Utilisateur) outMap.get("user")).getNom());
		} else {
			if (verificationFormulaire() == "nom") {
				logger.info("Nom incorrect");
			} else if (verificationFormulaire() == "prenom") {
				logger.info("prenom incorrect");
			} else if (verificationFormulaire() == "mail") {
				logger.info("mail incorrect");
			} else if (verificationFormulaire() == "password") {
				logger.info("password incorrect");
			}
		}
		
		if (isInscriptionReussie)
			return SUCCESS;
		else
			return SUCCESS;
	}
	
	public String verificationFormulaire() {		
		logger.info("VERIFICATION FORMULAIRE");
		Pattern pNom = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Pattern pMail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		// ---------------------- NOM ---------------------- //
		if (utilisateur.getNom().length() < 3) return "nom";
		if (utilisateur.getNom().length() > 15) return "nom";
		Matcher m = pNom.matcher(utilisateur.getNom());
		if (m.find()) return "nom"; // Il y a un caractère spécial
		
		// ---------------------- PRENOM ---------------------- //
		if (utilisateur.getPrenom().length() < 3) return "prenom";
		if (utilisateur.getPrenom().length() > 15) return "prenom";
		m = pNom.matcher(utilisateur.getPrenom());
		if (m.find()) return "prenom"; // Il y a un caractère spécial
		
		// ---------------------- MAIL ---------------------- //
		m = pMail.matcher(utilisateur.getEmail());
		if (!m.find()) return "mail"; // Il y a un caractère spécial
		
		// ---------------------- PASSWORD ---------------------- //
		if (utilisateur.getPassword().length() < 8) return "password";
		if (utilisateur.getPassword().length() > 20) return "password";
		
		return null;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = request;
	}
}
