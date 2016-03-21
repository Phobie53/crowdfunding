package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Categorie;
import model.Projet;


public interface CategorieDAO extends GenericDAO<Categorie, Long> {
	public Categorie findById(int id);
}