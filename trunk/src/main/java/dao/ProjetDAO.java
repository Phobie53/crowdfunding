package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Categorie;
import model.Projet;
import java.util.List;


public interface ProjetDAO extends GenericDAO<Projet, Long> {

	/**
	 * Retourne la liste des derniers projets par rapport au parametre (nombre)
	 * @param nombre
	 * @return
	 */
	public List<Projet> getDerniereProjet(int nombre);
	
	/**
	 * Retourne un projet par rapport à un ID
	 * @param id
	 * @return
	 */
	public Projet findById(int id);
	
	/**
	 * Retourne le nombre de projet total
	 * @return
	 */
	public int nbElement();
	
	/**
	 * Retourne le nombre de projet ayant atteint objectif
	 * @return
	 */
	public int getNbObjectifAtteint();
	
	/**
	 * Module de recherche
	 * @param recherche => terme de recherche
	 * @param categorie => categorie rechercher
	 * @return
	 */
	public List<Projet> recherche(String recherche, Categorie categorie);
	
	/**
	 * Retourne la liste des projets par rapport a un utilisateur
	 * @param utilisateurId
	 * @return
	 */
	public List<Projet> getMesProjets(int utilisateurId);
	
}