package dao.impl;


import javax.transaction.Transactional;

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

	
	 @Autowired
     @Override
     public void setSessionFactory(SessionFactory sessionFactory) {
             super.setSessionFactory(sessionFactory);
     }
}