package dao.impl;

import javax.transaction.Transactional;

import model.Categorie;
import model.Projet;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import action.HomeAction;
import dao.ProjetDAO;

@Repository
@Transactional
public class ProjetDAOImpl extends GenericDAOImpl<Projet, Long> implements ProjetDAO {


	private static final Logger logger = Logger.getLogger(ProjetDAOImpl.class);
	
	
	@SuppressWarnings("unchecked")
	public List<Projet> getDerniereProjet(int nombre) {
		List<Projet> listeProjet = null;
		Query query = this.getSession().createQuery("from Projet ORDER BY id DESC").setFirstResult(0)
				.setMaxResults(nombre);
		listeProjet = (List<Projet>) query.list();

		return listeProjet;
	}

	public List<Projet> recherche(String recherche, Categorie categorie){
		List<Projet> listeProjet = null;
		String sql = "from Projet p where ";
		if(categorie != null || recherche != ""){
			if(categorie != null){
				sql += " p.categorie.categorieId = :cat AND";
			}
			if(recherche != ""){
				sql += " LOWER(p.nom) like LOWER(:recherche) AND";
			}
		}
		sql += " p.statut = 1 ";
		logger.info(sql);
		Query query = this.getSession().createQuery(sql);
		if(categorie != null || recherche != ""){
			if(categorie != null){
				query.setLong("cat", categorie.getCategorieId());
			}
			if(recherche != ""){
				query.setString("recherche", "%"+recherche+"%");
			}
		}
		listeProjet = (List<Projet>) query.list();

		return listeProjet;
	}
	
	
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}