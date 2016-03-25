package model;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Commentaire")
public class Commentaire implements Serializable {
	
	private static final long serialVersionUID = 1606595499946L;
	
	@Id
	@GeneratedValue
	@Column(name = "ComId")
	private Long comId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name="utilisateurId")	 
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="projetId")	 
	private Projet projet;
	
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateFr() {
		Format formatter = new SimpleDateFormat("dd/MM/yy");
		String dateFr = formatter.format(date);
		return dateFr;
	}

}
