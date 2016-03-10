package dao.impl;


import javax.transaction.Transactional;

import model.Categorie;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.CategorieDAO;


@Repository
@Transactional
public class CategorieDAOImpl extends GenericDAOImpl<Categorie, Long> implements CategorieDAO {

	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
}