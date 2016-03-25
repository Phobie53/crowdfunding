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
	 
	 public Utilisateur findByEmailPassword(String email, String mdp) {
			Utilisateur utilisateur = null;
			Query query = this.getSession().
					createQuery("from Utilisateur u where u.email=:email and u.password=:password").
					setString("email", email).setString("password", mdp);
			utilisateur = (Utilisateur) query.uniqueResult();
			
			return utilisateur;
		}
}