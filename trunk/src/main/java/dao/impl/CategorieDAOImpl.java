package dao.impl;


import javax.transaction.Transactional;

import model.Categorie;
import model.Projet;

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
	 
	 public Categorie findById(int id) {
			Categorie categorie = null;
			Query query = this.getSession().createQuery("from Categorie c where c.categorieId=:id").setInteger("id", id);
			categorie = (Categorie) query.uniqueResult();

			return categorie;
		}
}