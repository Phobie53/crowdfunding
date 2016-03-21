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
public class RechercheAction extends ActionSupport {

	private static final long serialVersionUID = 123025773L;

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(RechercheAction.class);
	
	private List<Projet> projets = new ArrayList<Projet>();
	
	private String recherche = "";
	private int categorie 	 = 0;
	

	@Autowired
	private ProjetService projetService;
	
	public String recherche() {
		logger.info("CHARGEMENT PAGE DETAIL PROJET");
		//Objet request
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		//On recupere les valeurs GET
		String idCategorie = request.getParameter("categorie");
		if (idCategorie != null) {
			categorie = Integer.parseInt(idCategorie);
		}
		String textRecherche = request.getParameter("recherche");
		if (textRecherche != null) {
			recherche = textRecherche;
		}
		
		//On realise la recherche
		projets = projetService.recherche(recherche, categorie);
		return SUCCESS;
	}
	

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	public String getRecherche() {
		return recherche;
	}


	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}


	public int getCategorie() {
		return categorie;
	}


	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
}
