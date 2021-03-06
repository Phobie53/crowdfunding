package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Categorie;
import model.Commentaire;
import model.Don;
import model.Projet;
import model.Recompense;
import model.Utilisateur;
import service.CategorieService;
import service.CommentaireService;
import service.DonService;
import service.ProjetService;
import service.RecompenseService;

@Controller
public class ProjetAction extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String ERROR_SESSION = "error_session";

	private static final Logger logger = Logger.getLogger(ProjetAction.class);

	private Map<String, Object> session;
	private Projet projet;
	private List<Categorie> categorieTypes = new ArrayList<Categorie>();
	private List<Projet> mesProjets = new ArrayList<Projet>();
	private int idProjet;
	private int montant;
	private String commentaire;
	private String url;
	private Categorie categorie;
	
	 private File image;  
	 private String imageFileName;  
	 private String imageContentType; 
	 private String filePath;
	 private HttpServletRequest servletRequest;
	 
	 private int categorieId;
	 private String dateField;

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private CommentaireService commentaireService;

	@Autowired
	private ProjetService projetService;

	@Autowired
	private DonService donService;
	
	@Autowired
	private RecompenseService recompenseService;

	public String detailProjet() {
		logger.info("CHARGEMENT PAGE DETAIL PROJET");

		// Objet request
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		// On recupere les valeurs GET
		String id = request.getParameter("id");
		if (id != null) {
			projet = projetService.findById(Integer.parseInt(id));
			commentaire = "";
		}

		if (projet == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	public String mesProjets() {
		logger.info("CHARGEMENT PAGE MES PROJETS");

		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		Utilisateur user = (Utilisateur) session.get("user");
		mesProjets = projetService.getMesProjets(user.getUtilisateurId().intValue());
		return SUCCESS;
	}

	public String afficherFormCreation() {
		logger.info("CHARGEMENT PAGE FORMULAIRE CREATION");
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		categorieTypes = categorieService.listeCategorie();
		
		projet 		= new Projet();
		image 		= null;
		dateField 	= null;
		return SUCCESS;
	}

	public String afficherFormModification() {
		logger.info("CHARGEMENT PAGE FORMULAIRE MODIFICATION");
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		final String idProjetString = request.getParameter("id");
		if (idProjetString != null) {
			projet = projetService.findById(Integer.parseInt(idProjetString));
			logger.info("id : " + idProjetString);
			

			if(projet != null){
				categorieTypes = categorieService.listeCategorie();
				//Gestion de la date
				Format formatter = new SimpleDateFormat("dd/MM/yy");
				dateField 		 = formatter.format(projet.getDateFinCampagne());
				image			 = null;
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public String saveProjet() {
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		
		if(idProjet > 0){
			logger.info("ID : projet => " + idProjet);
			projet.setProjetId((long) idProjet);
		}
		
		//Gestion de la date
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(dateField);
			logger.info("*****************Date:" + date.toString());
			projet.setDateFinCampagne(date);

		} catch (ParseException e) {
			logger.error("ERROR", e);
			logger.info("ERROR");
		}
				
		//Verifier le formulaire		
		if (!verificationFormulaire()) {
			return INPUT;
		}
		
		projet.setUtilisateur((Utilisateur) session.get("user"));
		projet.setCategorie(categorieService.findById(categorieId));
		projet.setStatut(1);
		
		//Gestion de l'image
		if (image != null) {
			try {
				String fileURL = servletRequest.getSession().getServletContext().getRealPath("/").concat("upload/");
				File file = new File(fileURL, imageFileName);
				FileUtils.copyFile(image, file);
				projet.setImage("/crowdfunding/upload/" + imageFileName);
			} catch (Exception e) {
				logger.error("ERROR", e);
				return INPUT;
			}
		}
		
		//Gestion recompense
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Map<String, String[]> params = request.getParameterMap();
		
	
		
		//Save projet
		projetService.saveProjet(projet);

		//Suppression des recompenses pour gerer le plus facilement les comflits
		recompenseService.deleteByProjet(projet);
		
		//NEW RECOMPENSE
		String pattern = "(recompense_montant_)([0-9]+)";
		Pattern r = Pattern.compile(pattern);
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();

			// On test la key
			Matcher m = r.matcher(key);
			if (m.find()) {
				if (request.getParameter("recompense_description_" + m.group(2)) != null) {
					Recompense rr = new Recompense();
					rr.setDescription(request.getParameter("recompense_description_" + m.group(2)));
					rr.setMontant(Integer.parseInt(request.getParameter("recompense_montant_" + m.group(2))));
					rr.setProjet(projet);
					recompenseService.save(rr);
				}
			}
		}
		

		return SUCCESS;
	}

	public boolean verificationFormulaire() {		
		logger.info("VERIFICATION FORMULAIRE PROJET");
	
		boolean nom 	 = false;
		boolean date	 = false;
		boolean objectif = false;
		
		if (projet.getNom() == null) nom = true;
		if (projet.getDateFinCampagne() == null) date = true;
		if (projet.getObjectif() == null) objectif = true;
			
		if (nom) {
			logger.info("Nom vide");
			addFieldError("projet.nom", "Nom obligatoire.");
		}
		if (date) {
			logger.info("date vide");
			addFieldError("projet.dateFinCampagne", "date obligatoire.");
		} 
		if (objectif) {
			logger.info("pas de valeur objectif");
			addFieldError("projet.objectif", "Objectif obligatoire.");
		}
		if(nom || date || objectif){
			return false;
		}
		else{
			return true;
		}
	}
	public String faireDon() {
		logger.info("CHARGEMENT PAGE FAIRE DON");
		if (session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		return SUCCESS;
	}

	public String saveDon() {
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		Utilisateur user = (Utilisateur) session.get("user");
		logger.info("CHARGEMENT PAGE SAVE DON");
		if (idProjet != 0 && montant > 0) {
			Projet leProjet = projetService.findById(idProjet);
			if (leProjet != null) {
				Don newDon = new Don();
				newDon.setDate(new Date());
				newDon.setMontant(montant);
				newDon.setProjet(leProjet);
				newDon.setUtilisateur(user);
				donService.saveDon(newDon);
				url = "projet?id="+projet.getProjetId();
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public String saveCommentaire() {
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecte
			return ERROR_SESSION;
		}
		Utilisateur user = (Utilisateur) session.get("user");
		
		logger.info("CHARGEMENT PAGE SAVE COMMENTAIRE");
		if (idProjet != 0 && commentaire != null) {
			Projet leProjet = projetService.findById(idProjet);
			if (leProjet != null) {
				Commentaire newCommentaire = new Commentaire();
				newCommentaire.setDate(new Date());
				newCommentaire.setDescription(commentaire);
				newCommentaire.setProjet(leProjet);
				newCommentaire.setUtilisateur(user);
				commentaireService.saveCommentaire(newCommentaire);
				url = "projet?id="+projet.getProjetId();
			}
		}
		return SUCCESS;
	}
	
	public List<Categorie> getCategorieTypes() {
		return categorieTypes;
	}

	public void setCategorieTypes(List<Categorie> categorieTypes) {
		this.categorieTypes = categorieTypes;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getDateEcart() {
		if (projet != null) {
			long diffInMillies = projet.getDateFinCampagne().getTime() - (new Date()).getTime();
			int nb = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
			if (nb > 0) {
				return String.valueOf(nb);
			}
		}
		return "Fini";
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getUrl() {
		return url;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Projet> getMesProjets() {
		return mesProjets;
	}

	public void setMesProjets(List<Projet> mesProjets) {
		this.mesProjets = mesProjets;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}	
	
	
}