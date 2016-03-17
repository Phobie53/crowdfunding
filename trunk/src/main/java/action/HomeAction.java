package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

import model.Projet;
import service.ProjetService;

@Controller
public class HomeAction extends ActionSupport {

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(HomeAction.class);
 
	
	@Autowired
	private ProjetService projetService;
	private List<Projet> lesProjets = new ArrayList<Projet>();
	
	
	public String afficher() {
		logger.info("CHARGEMENT PAGE HOME");
		lesProjets = projetService.getDerniereProjet(3);
		
		return SUCCESS;
	}
	
	public List<Projet> getLesProjets() {
		return lesProjets;
	}

	public void setLesProjets(List<Projet> lesProjets) {
		this.lesProjets = lesProjets;
	}
}