package service.impl;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CategorieDAO;
import dao.ProjetDAO;
import model.Projet;
import service.ProjetService;


@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
	private ProjetDAO projetDao;
	
	public void saveProjet(Projet projet) {
		if (projet != null) {
			projetDao.save();
		}
	}

}