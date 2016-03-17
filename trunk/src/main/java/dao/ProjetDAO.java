package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Projet;
import java.util.List;


public interface ProjetDAO extends GenericDAO<Projet, Long> {

	public List<Projet> getDerniereProjet(int nombre);
	
}