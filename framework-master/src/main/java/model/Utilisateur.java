package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Utilisateur")

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1710234886606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "UtilisateurId")
	private Long UtilisateurId;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "datecreation")
	private Date datecreation;
	
	@Column(name = "derniereconnecxion")
	private Date derniéreconnexion;

	public Long getUtilisateurId() {
		return UtilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		UtilisateurId = utilisateurId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Date getDerniéreconnexion() {
		return derniéreconnexion;
	}

	public void setDerniéreconnexion(Date derniéreconnexion) {
		this.derniéreconnexion = derniéreconnexion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
