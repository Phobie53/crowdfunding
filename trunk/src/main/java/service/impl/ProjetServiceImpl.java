package service.impl;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CategorieDAO;
import dao.ProjetDAO;
import model.Projet;
import java.util.List;
import service.ProjetService;


@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
	private ProjetDAO projetDAO;
	
	public void saveProjet(Projet projet) {
		if (projet != null) {
			projetDAO.save();
		}
	}
	
	public List<Projet> getDerniereProjet(int nombre){
		return projetDAO.getDerniereProjet(nombre);
	}

}