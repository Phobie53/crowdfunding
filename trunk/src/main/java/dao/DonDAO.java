package dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Don;


public interface DonDAO extends GenericDAO<Don, Long> {
	
	/**
	 * Retourne la liste des Dons d'un utilisateur
	 * @param utilisateurId
	 * @return List<Don>
	 */
	public List<Don> getMesDons(int utilisateurId);

	/**
	 * Retourne le nombre de Don 
	 * @return
	 */
	public int getCount();

	/**
	 * Retourne le montant total de Don 
	 * @return
	 */
	public int getMontantTotal();
	
}