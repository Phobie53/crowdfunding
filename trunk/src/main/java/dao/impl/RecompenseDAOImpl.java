package dao.impl;

import javax.transaction.Transactional;

import model.Projet;
import model.Recompense;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.RecompenseDAO;

@Repository
@Transactional
public class RecompenseDAOImpl extends GenericDAOImpl<Recompense, Long> implements RecompenseDAO {

	
	public boolean deleteByProjet(Projet projet) {
		try{

			Query query = this.getSession().createQuery("delete Recompense r where r.projet.projetId=:id").setLong("id", projet.getProjetId());
			query.executeUpdate();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}