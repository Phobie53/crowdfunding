package dao.impl;


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
}