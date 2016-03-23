package service.impl;


import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Categorie;
import service.CategorieService;

import dao.CategorieDAO;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	public List<Categorie> listeCategorie() {
		return categorieDAO.findAll();
	}

	public Categorie findById(int id){
		return categorieDAO.findById(id);
	}


}