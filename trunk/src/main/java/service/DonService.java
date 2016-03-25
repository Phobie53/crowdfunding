package service;

import java.util.List;

import model.Don;



public interface DonService {

	/**
	 *  Methode qui permet la persistance de l'objet Don
	 * @param don
	 * @return
	 */
	public boolean saveDon(Don don);
	
	/**
	 * Methode qui permet de retourner la liste des Dons par rapport a un utilisateur
	 * @param utilisateurId
	 * @return
	 */
	public List<Don> getMesDons(int utilisateurId);

	/**
	 * Methode qui retourne le nombre de don total
	 * @return
	 */
	public int getCount();
	
	/**
	 * Methode qui retourne le montant de don total
	 * @return
	 */
	public int getMontantTotal();
}