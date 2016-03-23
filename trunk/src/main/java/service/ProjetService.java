package service;

import java.util.List;

import model.Projet;



public interface ProjetService {
	
	/**
	 * Sauvegarde un nouveau projet
	 * @param projet 
	 */
	public void saveProjet(Projet projet);
	public void modifieProjet (Projet projet);
	/**
	 * Cette methode retourne la liste des dernieres projets
	 * @param nombre => nombre de projet à retourner
	 * @return list de projet
	 */
	public List<Projet> getDerniereProjet(int nombre);
	
	public List<Projet> getMesProjets(int utilisateurId);
	
	/**
	 * Cette methode realise une recherche sur les différents projets de la BDD
	 * @param recherche
	 * @param categorie
	 * @return
	 */
	public List<Projet> recherche(String recherche, int categorie);
	
	/**
	 * Retourne un projet par rapport a son id
	 * @param id
	 * @return Projet (objet)
	 */
	public Projet findById(int id);
}