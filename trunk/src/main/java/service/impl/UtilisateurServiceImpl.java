package service.impl;


import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UtilisateurDAO;
import model.Utilisateur;
import service.UtilisateurService;


@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	public boolean sauvegarderUtilisateur(Utilisateur utilisateur) {
		boolean res = false;
		
		if (utilisateur != null) {
			utilisateur.setDatecreation(new Date());
			utilisateur.setPassword(DigestUtils.sha1Hex(utilisateur.getPassword()));
			res = utilisateurDAO.save(utilisateur);
		}
		
		return res;
	}
	

	public Utilisateur findById(int id){
		return utilisateurDAO.find((long) id);
	}
	

	public Utilisateur connexion(String email, String password) {
		password = DigestUtils.sha1Hex(password);
		return utilisateurDAO.findByEmailPassword(email, password);
	}

}