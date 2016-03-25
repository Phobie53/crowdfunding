package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Categorie;


public interface CategorieDAO extends GenericDAO<Categorie, Long> {
	
	/**
	 * Retourne la categorie par rapport a l'id
	 * @param id
	 * @return Categorie
	 */
	public Categorie findById(int id);
}