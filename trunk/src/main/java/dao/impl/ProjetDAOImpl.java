package dao.impl;


import javax.transaction.Transactional;

import model.Projet;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.ProjetDAO;


@Repository
@Transactional
public class ProjetDAOImpl extends GenericDAOImpl<Projet, Long> implements ProjetDAO {

	@SuppressWarnings("unchecked")
	public List<Projet> getDerniereProjet(int nombre){
		List<Projet> listeProjet = null;
		Query query = this.getSession().createQuery(
				"from Projet ORDER BY id DESC")
				.setFirstResult(0)
				.setMaxResults(nombre);
		listeProjet = (List<Projet>) query.list();
		
		return listeProjet;
	}
	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
}