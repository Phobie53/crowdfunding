package dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import model.Don;


public interface DonDAO extends GenericDAO<Don, Long> {


	public int getCount();

	public int getMontantTotal();
	
}