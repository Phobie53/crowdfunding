package action;

import java.util.ArrayList;
import java.util.List;

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

	public String detailProjet() {
		logger.info("CHARGEMENT PAGE DETAIL PROJET");
		// Objet request
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		// On recupere les valeurs GET
		String id = request.getParameter("id");
		if (id != null) {
			projet = projetService.findById(Integer.parseInt(id));
			return SUCCESS;
		}else{
			return ERROR;
		}

	}

	public String mesProjets() {
		logger.info("CHARGEMENT PAGE MES PROJETS");
		return SUCCESS;
	}

	public String afficherFormCreation() {
		logger.info("CHARGEMENT PAGE FORMULAIRE CREATION");
		this.setCategorieTypes(categorieService.listeCategorie());
		return SUCCESS;
	}

	public String afficherFormModification() {
		logger.info("CHARGEMENT PAGE FORMULAIRE MODIFICATION");

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);

		final String idProjetString = request.getParameter("idProjet");
		if (idProjetString != null) {
			final Long idProjet = Long.parseLong(idProjetString);
			if (idProjet != null) {
				logger.info("id : " + idProjet);
			}
		}
		return SUCCESS;
	}

	public String saveProjet() {

		if (projet == null) {
			logger.info("ko");
		} else {
			logger.info(projet.getNom());
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

}
