package dao.impl;


import java.util.List;

import javax.transaction.Transactional;

import model.Don;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import dao.DonDAO;

@Repository
@Transactional
public class DonDAOImpl extends GenericDAOImpl<Don, Long> implements DonDAO {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public int getCount() {
		return ((Long)this.getSession().createQuery("select count(*) from Don").uniqueResult()).intValue();
	}

	public int getMontantTotal() {
		return ((Long)this.getSession().createQuery("select COALESCE(SUM(montant), 0) from Don d").uniqueResult()).intValue();
	}	

	@SuppressWarnings("unchecked")
	public List<Don> getMesDons(int utilisateurId){
			
		List<Don> mesDons = null;
		Query query = this.getSession().createQuery("from Don d where d.utilisateur.utilisateurId=:id")
				.setLong("id", utilisateurId);
		mesDons = (List<Don>) query.list();
		return mesDons;
	}
}