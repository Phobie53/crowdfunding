package service;

import java.util.List;

import model.Categorie;



public interface CategorieService {
	
	/**
	 * Retourne la liste des categorie dans la base de données
	 * @return List<Categorie>
	 */
	public List<Categorie> listeCategorie();
	
	/**
	 * Retourne une categorie par rapport a son ID
	 * @param id
	 * @return
	 */
	public Categorie findById(int id);
	
}