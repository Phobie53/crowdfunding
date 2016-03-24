package service;

import java.util.List;

import model.Commentaire;
import model.Don;



public interface CommentaireService {

	public boolean saveCommentaire(Commentaire commentaire);
	
	public List<Commentaire> getMesCommentaires(int utilisateurId);
}