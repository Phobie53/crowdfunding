package service.impl;


import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DonDAO;
import dao.UtilisateurDAO;
import model.Don;
import model.Utilisateur;
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

}