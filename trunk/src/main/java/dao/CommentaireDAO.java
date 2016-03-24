package dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Commentaire;
import model.Don;


public interface CommentaireDAO extends GenericDAO<Commentaire, Long> {

	public List<Commentaire> getMesCommentaires(int utilisateurId);
}