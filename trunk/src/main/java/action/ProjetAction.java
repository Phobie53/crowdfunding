package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Categorie;
import model.Commentaire;
import model.Don;
import model.Projet;
import service.CategorieService;
import service.CommentaireService;
import service.DonService;
import service.ProjetService;
import service.UtilisateurService;

@Controller
public class ProjetAction extends ActionSupport {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private static final Logger logger = Logger.getLogger(ProjetAction.class);

	private Projet projet;
	private List<Categorie> categorieTypes = new ArrayList<Categorie>();
	private int idProjet;
	private int montant;
	private String commentaire;
	private String url;

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
		return SUCCESS;
	}

	public String afficherFormCreation() {
		logger.info("CHARGEMENT PAGE FORMULAIRE CREATION");
		categorieTypes = categorieService.listeCategorie();
		projet = new Projet();
		return SUCCESS;
	}

	public String afficherFormModification() {
		logger.info("CHARGEMENT PAGE FORMULAIRE MODIFICATION");

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		final String idProjetString = request.getParameter("idProjet");
		if (idProjetString != null) {
			logger.info("id : " + idProjetString);
		}
		return SUCCESS;
	}

	public String saveProjet() {

		if (projet != null) {
			projet.setUtilisateur(utilisateurService.findById(1));
			projetService.saveProjet(projet);
		}

		return SUCCESS;
	}

	public String faireDon() {
		logger.info("CHARGEMENT PAGE FAIRE DON");
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
}
