package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Projet")
public class Projet implements Serializable{
	
	private static final long serialVersionUID = 1710234886606599946L;
	
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
