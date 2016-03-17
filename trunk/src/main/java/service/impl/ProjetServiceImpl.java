package service.impl;


import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import action.ProjetAction;
import dao.CategorieDAO;
import dao.ProjetDAO;
import dao.impl.ProjetDAOImpl;
import model.Categorie;
import model.Projet;
import java.util.List;
import service.ProjetService;


@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {

	private static final Logger logger = Logger.getLogger(ProjetServiceImpl.class);
	
	@Autowired
	private ProjetDAO projetDAO;

	@Autowired
	private CategorieDAO categorieDAO;
	
	public void saveProjet(Projet projet) {
		if (projet != null) {
			projetDAO.save(projet);
		}
	}
	
	public List<Projet> getDerniereProjet(int nombre){
		return projetDAO.getDerniereProjet(nombre);
	}
	
	public List<Projet> recherche(String recherche, int categorie){
		Categorie cat = categorieDAO.find((long) categorie);
		return projetDAO.recherche(recherche, cat);
	}
	
	public Projet findById(int id){
		return projetDAO.find((long) id);
	}

}