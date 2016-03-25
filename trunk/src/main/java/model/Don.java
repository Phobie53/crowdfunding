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
@Table(name = "Don")
public class Don implements Serializable{
	
private static final long serialVersionUID = 16065999461991L;
	
	@Id
	@GeneratedValue
	@Column(name = "donId")
	private Long donId;
	
	@Column(name = "montant")
	private int montant;

	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="utilisateurId")	 
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="projetId")	 
	private Projet projet;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Long getDonId() {
		return donId;
	}

	public void setDonId(Long donId) {
		this.donId = donId;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateFr() {
		Format formatter = new SimpleDateFormat("dd/MM/yy");
		String dateFr = formatter.format(date);
		return dateFr;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
