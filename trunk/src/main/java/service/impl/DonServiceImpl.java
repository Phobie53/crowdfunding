package service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DonDAO;
import model.Don;
import service.DonService;


@Service
@Transactional
public class DonServiceImpl implements DonService {


	@Autowired
	private DonDAO donDAO;

	public boolean saveDon(Don don) {
		boolean res = false;
		
		if (don != null) {
			res = donDAO.save(don);
		}
		
		return res;
	}
	
	public List<Don> getMesDons(int utilisateurId){
		return donDAO.getMesDons(utilisateurId);
	}
	
	
	public int getCount() {
		return donDAO.getCount();
	}
	
	public int getMontantTotal() {
		return donDAO.getMontantTotal();
	}
}