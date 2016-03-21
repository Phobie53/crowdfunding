package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Recompense")
public class Recompense implements Serializable {

	private static final long serialVersionUID = 160659994617526L;
	
	@Id
	@GeneratedValue
	@Column(name = "recompenseId")
	private Long recompenseId;

	@Column(name = "description")
	private String description;

	@Column(name = "montant")
	private Integer montant;

	@ManyToOne
	@JoinColumn(name = "projetId")
	private Projet projet;

	public Long getRecompenseId() {
		return recompenseId;
	}

	public void setRecompenseId(Long recompenseId) {
		this.recompenseId = recompenseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
