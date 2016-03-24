package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Projet;
import model.Recompense;


public interface RecompenseDAO extends GenericDAO<Recompense, Long> {

	public boolean deleteByProjet(Projet projet);
}