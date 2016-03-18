package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Categorie;
import model.Projet;
import java.util.List;


public interface ProjetDAO extends GenericDAO<Projet, Long> {

	public List<Projet> getDerniereProjet(int nombre);
	
	public Projet findById(int id);
	
	public List<Projet> recherche(String recherche, Categorie categorie);
	
}