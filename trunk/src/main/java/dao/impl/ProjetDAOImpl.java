package dao.impl;


import javax.transaction.Transactional;

import model.Projet;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.ProjetDAO;


@Repository
@Transactional
public class ProjetDAOImpl extends GenericDAOImpl<Projet, Long> implements ProjetDAO {

	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
}