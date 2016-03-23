package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Projet")
public class Projet implements Serializable{
	
	private static final long serialVersionUID = 16065999462014L;
	
	@Id
	@GeneratedValue
	@Column(name = "projetId")
	private Long projetId;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name="image", columnDefinition="TEXT")
	private String image;
	
	@Column(name = "presentation", columnDefinition="TEXT")
	private String presentation;
	
	@Column(name = "dateFindeCampagne")
	private Date dateFinCampagne;
	
	@Column(name = "objectif")
	private Integer objectif;
	
	@Column(name = "statut")
	private int statut;
	
	@Column(name = "dateCreation")
	private Date dateCreation;

	@ManyToOne
	@JoinColumn(name="utilisateurId")	 
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="categorieId")	 
	private Categorie categorie;

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.EAGER)  
    private List<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.EAGER) 
	private List<Recompense> recompenses;

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.EAGER) 
    private List<Don> dons;
	

	public Date getDateFinCampagne() {
		return dateFinCampagne;
	}

	public void setDateFinCampagne(Date dateFinCampagne) {
		this.dateFinCampagne = dateFinCampagne;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Don> getDons() {
		return dons;
	}
	
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
		return dateFinCampagne;
	}

	public void setFinCompagne(Date finCompagne) {
		this.dateFinCampagne = finCompagne;
	}

	public Integer getObjectif() {
		return objectif;
	}

	public void setObjectif(Integer objectif) {
		this.objectif = objectif;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
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
	
	public List<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(List<Recompense> recompenses) {
		this.recompenses = recompenses;
	}


}
