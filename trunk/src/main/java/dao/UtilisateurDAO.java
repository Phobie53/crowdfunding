package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Utilisateur;


public interface UtilisateurDAO extends GenericDAO<Utilisateur, Long> {
	
	/**
	 * Verification du couple EMAIL/PASSWORD
	 * @param email
	 * @param password
	 * @return
	 */
	public Utilisateur findByEmailPassword(String email, String password);

}