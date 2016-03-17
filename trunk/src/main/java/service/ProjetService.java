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
	
	/**
	 * Cette methode realise une recherche sur les différents projets de la BDD
	 * @param recherche
	 * @param categorie
	 * @return
	 */
	public List<Projet> recherche(String recherche, int categorie);
	
}