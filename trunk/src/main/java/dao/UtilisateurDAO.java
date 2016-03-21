package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Utilisateur;


public interface UtilisateurDAO extends GenericDAO<Utilisateur, Long> {
	public Utilisateur findByEmailPassword(String email, String password);

}