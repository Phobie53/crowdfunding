package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 160659994621016L;
	
	@Id
	@GeneratedValue
	@Column(name = "UtilisateurId")
	private Long utilisateurId;
	
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
	private Date derniereconnexion;
	


	 @OneToMany(mappedBy="utilisateur")
	    private Set<Projet> projet;
	 
	 @OneToMany(mappedBy="utilisateur")
	    private Set<Don> don;
	 
	 @OneToMany(mappedBy="utilisateur")
	    private Set<Commentaire> commentaire;
	 
	public Set<Projet> getProjet() {
		return projet;
	}

	public void setProjet(Set<Projet> projet) {
		this.projet = projet;
	}

	public Set<Don> getDon() {
		return don;
	}

	public void setDon(Set<Don> don) {
		this.don = don;
	}

	public Set<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Set<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		utilisateurId = utilisateurId;
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

	public Date getDerniereconnexion() {
		return derniereconnexion;
	}

	public void setDerniereconnexion(Date derniereconnexion) {
		this.derniereconnexion = derniereconnexion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
