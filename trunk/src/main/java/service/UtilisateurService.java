package service;


import model.Utilisateur;



public interface UtilisateurService {

	/**
	 * Sauvergade utilisateur (persistance)
	 * @param utilisateur
	 * @return bool
	 */
	public boolean sauvegarderUtilisateur(Utilisateur utilisateur);

	/**
	 * Get utilisateur par son id
	 * @param id
	 * @return utilisateur
	 */
	public Utilisateur findById(int id);
	
	/**
	 * Methode qui valide la connexion d'un utilisateur
	 * @param email
	 * @param password
	 * @return utilisateur
	 */
	public Utilisateur connexion(String email, String password);
}