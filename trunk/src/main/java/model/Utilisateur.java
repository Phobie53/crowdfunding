package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 160659994621016L;
	
	@Id
	@GeneratedValue
	@Column(name = "utilisateurId")
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
	
	@Column(name = "dateCreation")
	private Date dateCreation;

	 @OneToMany(mappedBy="utilisateur")
	    private List<Projet> projet;
	 
	 @OneToMany(mappedBy="utilisateur")
	    private List<Don> don;
	 
	 @OneToMany(mappedBy="utilisateur")
	    private List<Commentaire> commentaires;
	 
	public List<Projet> getProjet() {
		return projet;
	}

	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}

	public List<Don> getDon() {
		return don;
	}

	public void setDon(List<Don> don) {
		this.don = don;
	}

	public List<Commentaire> getCommentaire() {
		return commentaires;
	}

	public void setCommentaire(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
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
		return dateCreation;
	}

	public void setDatecreation(Date datecreation) {
		this.dateCreation = datecreation;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
