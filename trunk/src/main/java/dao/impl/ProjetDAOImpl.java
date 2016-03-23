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

	public Projet findById(int id) {
		Projet projet = null;
		Query query = this.getSession().createQuery("from Projet p where p.projetId=:id").setInteger("id", id);
		projet = (Projet) query.uniqueResult();

		return projet;
	}

	@SuppressWarnings("unchecked")
	public List<Projet> getDerniereProjet(int nombre) {
		List<Projet> listeProjet = null;
		Query query = this.getSession().createQuery("from Projet ORDER BY id DESC").setFirstResult(0)
				.setMaxResults(nombre);
		listeProjet = (List<Projet>) query.list();

		return listeProjet;
	}
	
	public List<Projet> getMesProjets(int utilisateurId){
		
		List<Projet> mesProjet = null;
		Query query = this.getSession().createQuery("from Projet p where p.utilisateur.utilisateurId=:id")
				.setLong("id", utilisateurId);
		mesProjet = (List<Projet>) query.list();
		return mesProjet;
	}

	public int nbElement(){
		int nb = ((Long)this.getSession().createQuery("select count(*) from Projet").uniqueResult()).intValue();
		return nb;
	}

	public List<Projet> recherche(String recherche, Categorie categorie) {
		List<Projet> listeProjet = null;
		String sql = "from Projet p where ";
		if (categorie != null || recherche != "") {
			if (categorie != null) {
				sql += " p.categorie.categorieId = :cat AND";
			}
			if (recherche != "") {
				sql += " LOWER(p.nom) like LOWER(:recherche) AND";
			}
		}
		sql += " p.statut = 1 ";
		logger.info(sql);
		Query query = this.getSession().createQuery(sql);
		if (categorie != null || recherche != "") {
			if (categorie != null) {
				query.setLong("cat", categorie.getCategorieId());
			}
			if (recherche != "") {
				query.setString("recherche", "%" + recherche + "%");
			}
		}
		listeProjet = (List<Projet>) query.list();
		
		return listeProjet;
	}
	
	public int getNbObjectifAtteint(){
		int nb = ((Long)this.getSession().createQuery("select count(*) from Projet p WHERE p.objectif <= (select SUM(d.montant) from Don d WHERE d.projet.projetId = p.projetId)")
				.uniqueResult()).intValue();
		return nb;
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}