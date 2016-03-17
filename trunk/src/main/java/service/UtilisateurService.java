package service;

import java.util.List;

import model.Utilisateur;



public interface UtilisateurService {

	public boolean sauvegarderUtilisateur(Utilisateur utilisateur);

	public Utilisateur findById(int id);
}