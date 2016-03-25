package dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Commentaire;


public interface CommentaireDAO extends GenericDAO<Commentaire, Long> {

	/**
	 * Retourne la liste des commentaires par rapport à un utilisateur
	 * @param utilisateurId
	 * @return liste commentaire
	 */
	public List<Commentaire> getMesCommentaires(int utilisateurId);
}