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
import model.Projet;
import service.CategorieService;
import service.ProjetService;
import service.UtilisateurService;

@Controller
public class ProjetAction extends ActionSupport {

	private static final long serialVersionUID = 123025772L;

	private static final String SUCCESS = "success";
	private static final String ERROR 	= "error";

	private static final Logger logger = Logger.getLogger(ProjetAction.class);

	private Projet projet;

	private List<Categorie> categorieTypes = new ArrayList<Categorie>();

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private ProjetService projetService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	public String detailProjet() {
		logger.info("CHARGEMENT PAGE DETAIL PROJET");
		// Objet request
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		// On recupere les valeurs GET
		String id = request.getParameter("id");
		if (id != null) {
			projet = projetService.findById(Integer.parseInt(id));
		} 
		
		if(projet == null){
			return ERROR;
		}else{
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

	public String getDateEcart(){
		if(projet != null){
			long diffInMillies = (new Date()).getTime() - projet.getDateFinCampagne().getTime();
		    int nb = (int) (diffInMillies / (1000 * 60 * 60 * 24) ) + 1;
		    if(nb > 0){
		    	return String.valueOf(nb);
		    }
		}
		return "Fini";
	}
}
