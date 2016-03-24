package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import model.Commentaire;
import model.Don;
import model.Projet;
import model.Utilisateur;
import service.CommentaireService;
import service.DonService;
import service.ProjetService;
import service.UtilisateurService;

@Controller
public class UtilisateurAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private Utilisateur utilisateur;

	private String mailConnexion;
	private String passwordConnexion;
	private Don don;
	private List<Don> mesDons = new ArrayList<Don>();
	private List<Commentaire> mesCommentaires = new ArrayList<Commentaire>();
	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private DonService donService;
	
	@Autowired
	private CommentaireService commentaireService;

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";
	private static final String ERROR_SESSION = "error_session";
	private static final String INPUT = "input";

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
		if ((Utilisateur) session.get("user") != null) { // Si l'utilisateur est connecte
			return ERROR_SESSION;
		}
		
		return SUCCESS;
	}
	
	public String mesDons() {
		logger.info("CHARGEMENT PAGE MES DONS");

		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		} else {
			utilisateur = (Utilisateur) session.get("user");
			mesDons = donService.getMesDons(utilisateur.getUtilisateurId().intValue());
			return SUCCESS;
		}
	}
	public String mesCommentaires() {
		logger.info("CHARGEMENT PAGE MES COMMENTAIRES");

		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		} else {
			utilisateur = (Utilisateur) session.get("user");
			mesCommentaires = commentaireService.getMesCommentaires(utilisateur.getUtilisateurId().intValue());
			return SUCCESS;
		}
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
	
	public String afficherProfil() {
		logger.info("CHARGEMENT PAGE MON PROFIL");
		// Objet request
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		// On recupere les valeurs GET
		String id = request.getParameter("id");
		if (id != null) {
			utilisateur = utilisateurService.findById(Integer.parseInt(id));
		}

		if (utilisateur == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	
	public String validerInscription() {
		logger.info("VALIDATION INSCRIPTION");
		boolean isInscriptionReussie = false;
		
		if (verificationFormulaire() == true) {
			utilisateur.setImage("image/avatar/avatar1.png");
			isInscriptionReussie = utilisateurService.sauvegarderUtilisateur(utilisateur);
			session.put("user", utilisateur); // Ajouter utilisateur a la session
		} else {
			logger.info("--- INSCRIPTION => RETURN INPUT");
			return INPUT;
		}
		
		if (isInscriptionReussie) {
			logger.info("INSCRIPTION REUSSIE");
			return SUCCESS;
		} else {
			logger.info("INSCRIPTION ERROR");
			return ERROR;
		}
	}
	
	public boolean verificationFormulaire() {		
		logger.info("VERIFICATION FORMULAIRE");
		Pattern pNom = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Pattern pMail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		boolean nom 	 = false;
		boolean prenom 	 = false;
		boolean mail 	 = false;
		boolean password = false;
		
		// ---------------------- NOM ---------------------- //
		if (utilisateur.getNom().length() < 3) nom = true;
		if (utilisateur.getNom().length() > 15) nom = true;
		Matcher m = pNom.matcher(utilisateur.getNom());
		if (m.find()) nom = true; // Il y a un caractere special
		
		// ---------------------- PRENOM ---------------------- //
		if (utilisateur.getPrenom().length() < 3) prenom = true;
		if (utilisateur.getPrenom().length() > 15) prenom = true;
		m = pNom.matcher(utilisateur.getPrenom());
		if (m.find()) prenom = true; // Il y a un caractere special
		
		// ---------------------- MAIL ---------------------- //
		m = pMail.matcher(utilisateur.getEmail());
		if (!m.find()) mail = true; // Il y a un caractere special
		
		// ---------------------- PASSWORD ---------------------- //
		if (utilisateur.getPassword().length() < 8) password = true;
		if (utilisateur.getPassword().length() > 20) password = true;
		
		if (nom == true) {
			logger.info("Nom incorrect");
			addFieldError("utilisateur.nom", "Nom obligatoire.");
		}
		if (prenom == true) {
			logger.info("prenom incorrect");
			addFieldError("utilisateur.nom", "PrÃ©nom obligatoire.");
		} 
		if (mail == true) {
			logger.info("mail incorrect");
			addFieldError("utilisateur.nom", "Email obligatoire.");
		}
		if (password == true) {
			logger.info("password incorrect");
			addFieldError("utilisateur.nom", "Mot de passe obligatoire.");
		}
		
		if(nom || prenom || mail || password ){
			return false;
		}
		else{
			return true;
		}
	}
	
	public String monCompte() {
		logger.info("CHARGEMENT PAGE MON COMPTE");

		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connectÃ©
			return ERROR_SESSION;
		}
		
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

	public Don getDon() {
		return don;
	}

	public void setDon(Don don) {
		this.don = don;
	}

	public List<Don> getMesDons() {
		return mesDons;
	}

	public void setMesDons(List<Don> mesDons) {
		this.mesDons = mesDons;
	}

	public List<Commentaire> getMesCommentaires() {
		return mesCommentaires;
	}

	public void setMesCommentaires(List<Commentaire> mesCommentaires) {
		this.mesCommentaires = mesCommentaires;
	}
	
	
}
