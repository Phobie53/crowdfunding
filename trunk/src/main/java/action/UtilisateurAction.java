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
public class UtilisateurAction extends ActionSupport implements SessionAware {

	Map<String, Object> session;
	private Utilisateur utilisateur;

	private String mailConnexion;
	private String passwordConnexion;
	
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
		if (session.get("user") != null) 
			session.remove("user");
		return SUCCESS;
	}
	
	public String inscription() {
		logger.info("CHARGEMENT PAGE INSCRIPTION");
		return SUCCESS;
	}
	
	public String validerConnexion() {
		Utilisateur user = utilisateurService.Connexion(mailConnexion, passwordConnexion);
		if (user == null) {
			return ERROR;
		} else {
			session.put("user", user);
			return SUCCESS;
		}
	}
	
	public String validerInscription() {
		logger.info("VALIDATION INSCRIPTION");
		boolean isInscriptionReussie = false;
		
		if (verificationFormulaire() == null) {
			isInscriptionReussie = utilisateurService.sauvegarderUtilisateur(utilisateur);
			// Ajouter utilisateur à la session
			session.put("user", utilisateur);
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
		
		if (isInscriptionReussie) {
			logger.info("INSCRIPTION REUSSIE");
			return SUCCESS;
		} else {
			logger.info("INSCRIPTION ERROR");
			return ERROR;
		}
	}
	
	public String verificationFormulaire() {		
		logger.info("VERIFICATION FORMULAIRE");
		Pattern pNom = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Pattern pMail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		// ---------------------- NOM ---------------------- //
		if (utilisateur.getNom().length() < 3) return "nom";
		if (utilisateur.getNom().length() > 15) return "nom";
		Matcher m = pNom.matcher(utilisateur.getNom());
		if (m.find()) return "nom"; // Il y a un caract�re sp�cial
		
		// ---------------------- PRENOM ---------------------- //
		if (utilisateur.getPrenom().length() < 3) return "prenom";
		if (utilisateur.getPrenom().length() > 15) return "prenom";
		m = pNom.matcher(utilisateur.getPrenom());
		if (m.find()) return "prenom"; // Il y a un caract�re sp�cial
		
		// ---------------------- MAIL ---------------------- //
		m = pMail.matcher(utilisateur.getEmail());
		if (!m.find()) return "mail"; // Il y a un caract�re sp�cial
		
		// ---------------------- PASSWORD ---------------------- //
		if (utilisateur.getPassword().length() < 8) return "password";
		if (utilisateur.getPassword().length() > 20) return "password";
		
		return null;
	}
	
	public String monCompte() {
		logger.info("CHARGEMENT PAGE MON COMPTE");
		utilisateur = (Utilisateur) session.get("user");
		utilisateur.setPassword("");
		return SUCCESS;
	}
	
	public String modifierUtilisateur() {
		logger.info("MODIFIER UTILISATEUR");
		if (utilisateur.getPassword() != null && utilisateur.getPassword().length() > 3) {
			utilisateurService.sauvegarderUtilisateur(utilisateur);
			logger.info("MODIFIER UTILISATEUR SUCCESS");
			return SUCCESS;
		} else {
			logger.info("MODIFIER UTILISATEUR ERROR");
			return ERROR;
		}
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
	public String getMailConnexion() {
		return mailConnexion;
	}

	public void setMailConnexion(String mailConnexion) {
		this.mailConnexion = mailConnexion;
	}

	public String getPasswordConnexion() {
		return passwordConnexion;
	}

	public void setPasswordConnexion(String passwordConnexion) {
		this.passwordConnexion = passwordConnexion;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
