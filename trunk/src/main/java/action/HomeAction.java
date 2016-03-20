package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Projet;
import model.Utilisateur;
import service.ProjetService;

@Controller
public class HomeAction extends ActionSupport implements RequestAware, SessionAware {
	
	protected Map session;
	protected Map request;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = request;
	}

	private static final String SUCCESS = "success";

	private static final Logger logger = Logger.getLogger(HomeAction.class);
 
	
	@Autowired
	private ProjetService projetService;
	private List<Projet> lesProjets = new ArrayList<Projet>();
	
	
	public String afficher() {
		logger.info("CHARGEMENT PAGE HOME");

		Map<String, Object> outMap = ActionContext.getContext().getSession();
		logger.info(outMap.containsKey("user"));
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