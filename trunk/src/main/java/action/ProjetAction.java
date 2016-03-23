package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.File;  
import java.util.concurrent.TimeUnit;

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
import model.Utilisateur;
import service.CategorieService;
import service.CommentaireService;
import service.DonService;
import service.ProjetService;
import service.UtilisateurService;

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

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private CommentaireService commentaireService;

	@Autowired
	private ProjetService projetService;

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private DonService donService;

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

		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecté
			return ERROR_SESSION;
		}
		
		mesProjets = projetService.getMesProjets(1);
		return SUCCESS;
	}

	public String afficherFormCreation() {
		logger.info("CHARGEMENT PAGE FORMULAIRE CREATION");
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecté
			return ERROR_SESSION;
		}
		categorieTypes = categorieService.listeCategorie();
		
		projet = new Projet();
		return SUCCESS;
	}

	public String afficherFormModification() {
		logger.info("CHARGEMENT PAGE FORMULAIRE MODIFICATION");
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecté
			return ERROR_SESSION;
		}

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		final String idProjetString = request.getParameter("idProjet");
		if (idProjetString != null) {
			logger.info("id : " + idProjetString);
		}
		return SUCCESS;
	}

	public String saveProjet() {
		if ((Utilisateur) session.get("user") == null) { // Si l'utilisateur n'est pas connecté
			return ERROR_SESSION;
		}
		
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/").concat("upload/");
		logger.info("eeeeeeeeeeeiiiiiiiii" + filePath);
		
		if (projet != null) {
			//logger.info(">>>>>>>>>>>>>>" + categorie);
			logger.info(">>>>>>>>>>>>>>" + projet.getCategorie());
			projet.setUtilisateur(utilisateurService.findById(1));
			//projet.setCategorie(categorieService.findById(1));
			try{

				File file = new File(filePath, imageFileName);// Create file name  same as original
		        FileUtils.copyFile(image, file); // Just copy temp file content tos this file		
		        projet.setImage(filePath+imageFileName);
				}catch(Exception e)
				{
					e.printStackTrace();
		            addActionError(e.getMessage());
		            return INPUT;
		 
				}
			projetService.saveProjet(projet);
			
		}
				//logger.info(">>>>>>eeeeeeeeeee>>>>>>>>" );

		return SUCCESS;
	}

	public String faireDon() {
		logger.info("CHARGEMENT PAGE FAIRE DON");
		if (session.get("user") == null) { // Si l'utilisateur n'est pas connecté
			return ERROR_SESSION;
		}
		return SUCCESS;
	}

	public String saveDon() {
		logger.info("CHARGEMENT PAGE SAVE DON");
		if (idProjet != 0 && montant > 0) {
			Projet projet = projetService.findById(idProjet);
			if (projet != null) {
				Don newDon = new Don();
				newDon.setDate(new Date());
				newDon.setMontant(montant);
				newDon.setProjet(projet);
				newDon.setUtilisateur(utilisateurService.findById(1));
				donService.saveDon(newDon);
				url = "projet?id="+projet.getProjetId();
				return SUCCESS;
			}
		}
		return ERROR;
	}

	public String saveCommentaire() {
		logger.info("CHARGEMENT PAGE SAVE COMMENTAIRE");
		if (idProjet != 0 && commentaire != null) {
			Projet projet = projetService.findById(idProjet);
			if (projet != null) {
				Commentaire newCommentaire = new Commentaire();
				newCommentaire.setDate(new Date());
				newCommentaire.setDescription(commentaire);
				newCommentaire.setProjet(projet);
				newCommentaire.setUtilisateur(utilisateurService.findById(1));
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
			long diffInMillies = (new Date()).getTime() - projet.getDateFinCampagne().getTime();
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
}
