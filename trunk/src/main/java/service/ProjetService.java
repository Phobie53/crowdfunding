package service;

import java.util.List;

import model.Projet;



public interface ProjetService {
	
	/**
	 * Sauvegarde un nouveau projet
	 * @param projet 
	 */
	public void saveProjet(Projet projet);
	
	/**
	 * Cette methode retourne la liste des dernieres projets
	 * @param nombre => nombre de projet à retourner
	 * @return list de projet
	 */
	public List<Projet> getDerniereProjet(int nombre);
	
}