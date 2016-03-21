package dao.impl;


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
}