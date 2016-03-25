package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Projet;
import model.Recompense;


public interface RecompenseDAO extends GenericDAO<Recompense, Long> {

	/**
	 * Supprime les recompense par rapport a un projet
	 * @param projet
	 * @return
	 */
	public boolean deleteByProjet(Projet projet);
}