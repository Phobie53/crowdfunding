package service;

import java.util.List;

import model.Categorie;



public interface CategorieService {
	
	public List<Categorie> listeCategorie();
	
	public Categorie findById(int id);
	
}