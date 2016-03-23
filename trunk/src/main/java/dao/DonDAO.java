package dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Don;


public interface DonDAO extends GenericDAO<Don, Long> {
	
	public List<Don> getMesDons(int utilisateurId);


	public int getCount();

	public int getMontantTotal();
	
}