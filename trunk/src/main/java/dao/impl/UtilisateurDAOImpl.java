package dao.impl;


import javax.transaction.Transactional;

import model.Utilisateur;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.UtilisateurDAO;


@Repository
@Transactional
public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur, Long> implements UtilisateurDAO {

	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
}