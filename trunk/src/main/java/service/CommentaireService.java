package service;

import java.util.List;

import model.Commentaire;



public interface CommentaireService {

	/**
	 * Methode qui permet la persistance de l'objet Commentaire
	 * @param commentaire
	 * @return
	 */
	public boolean saveCommentaire(Commentaire commentaire);
	
	/**
	 * Methode qui permet de retourner la liste des commentaires par rapport a un utilisateur
	 * @param utilisateurId
	 * @return
	 */
	public List<Commentaire> getMesCommentaires(int utilisateurId);
	
}