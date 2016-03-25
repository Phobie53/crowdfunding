package dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import model.Commentaire;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.CommentaireDAO;


@Repository
@Transactional
public class CommentaireDAOImpl extends GenericDAOImpl<Commentaire, Long> implements CommentaireDAO {

	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
	 
	 @SuppressWarnings("unchecked")
	public List<Commentaire> getMesCommentaires(int utilisateurId){
				
		 List<Commentaire> mesCommentaires = null;
			Query query = this.getSession().createQuery("from Commentaire c where c.utilisateur.utilisateurId=:id")
					.setLong("id", utilisateurId);
			mesCommentaires = (List<Commentaire>) query.list();
			return mesCommentaires;
		}
}