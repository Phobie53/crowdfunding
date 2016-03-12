package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Projet")
public class Projet implements Serializable{
	
	private static final long serialVersionUID = 16065999462014L;
	
	@Id
	@GeneratedValue
	@Column(name = "ProjetId")
	private Long projetId;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "presentation")
	private String presentation;
	
	@Column(name = "DateFindeCompagne")
	private Date finCompagne;
	
	@Column(name = "objectif")
	private Integer objectif;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "Datecréation")
	private Date dateCreation;

	@ManyToOne
	@JoinColumn(name="utilisateurId")	 
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="categorieId")	 
	private Categorie categorie;

	@OneToMany(mappedBy="projet")
    private Set<Commentaire> commentaires;
	
	@OneToOne(mappedBy = "projet")
	private Recompense recompense;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Set<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Set<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public Set<Don> getDon() {
		return don;
	}

	public void setDon(Set<Don> don) {
		this.don = don;
	}

	@OneToMany(mappedBy="projet")
    private Set<Commentaire> commentaire;
	
	@OneToMany(mappedBy="projet")
    private Set<Don> don;
	
	public Long getProjetId() {
		return projetId;
	}

	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public Date getFinCompagne() {
		return finCompagne;
	}

	public void setFinCompagne(Date finCompagne) {
		this.finCompagne = finCompagne;
	}

	public Integer getObjectif() {
		return objectif;
	}

	public void setObjectif(Integer objectif) {
		this.objectif = objectif;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
