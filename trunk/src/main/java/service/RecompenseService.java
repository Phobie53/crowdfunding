package service;


import model.Projet;
import model.Recompense;



public interface RecompenseService {
	
	/**
	 * Methode qui permet la persistance de l'objet Recompense
	 * @param recompense
	 * @return
	 */
	public boolean save(Recompense recompense);

	/**
	 * Methode qui permet de supprimer les recompenses par rapport à un projet
	 * @param projet
	 * @return
	 */
	public boolean deleteByProjet(Projet projet);
}