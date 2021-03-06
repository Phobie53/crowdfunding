package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Projet;
import service.DonService;
import service.ProjetService;

@Controller
public class HomeAction extends ActionSupport {

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(HomeAction.class);
	
	private int nbProjet = 0;
	private int nombreDon = 0;
	private int montantDonTotal = 0;
	private int objectifAtteint = 0;
	
	
	@Autowired
	private ProjetService projetService;
	
	@Autowired
	private DonService donService;
	
	
	private List<Projet> lesProjets = new ArrayList<Projet>();
	
	
	public String afficher() {
		logger.info("CHARGEMENT PAGE HOME");
        Map session = ActionContext.getContext().getSession();
        logger.info("SESSION HOME : " + session);
        
        //nombre de projet total
        nbProjet = projetService.getNbElement();
        
        //montant don total
        montantDonTotal = donService.getMontantTotal();
        
        //nombre de don
        nombreDon = donService.getCount();
        
        //nombre d'objectif atteint
        objectifAtteint = projetService.getNbObjectifAtteint();
        
		
		lesProjets = projetService.getDerniereProjet(3);
		
		return SUCCESS;
	}
	
	public List<Projet> getLesProjets() {
		return lesProjets;
	}

	public void setLesProjets(List<Projet> lesProjets) {
		this.lesProjets = lesProjets;
	}

	public int getNbProjet() {
		return nbProjet;
	}

	public void setNbProjet(int nbProjet) {
		this.nbProjet = nbProjet;
	}

	public int getNombreDon() {
		return nombreDon;
	}

	public void setNombreDon(int nombreDon) {
		this.nombreDon = nombreDon;
	}

	public int getMontantDonTotal() {
		return montantDonTotal;
	}

	public void setMontantDonTotal(int montantDonTotal) {
		this.montantDonTotal = montantDonTotal;
	}

	public int getObjectifAtteint() {
		return objectifAtteint;
	}

	public void setObjectifAtteint(int objectifAtteint) {
		this.objectifAtteint = objectifAtteint;
	}
	
}