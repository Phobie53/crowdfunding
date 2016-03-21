package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recompense")
public class Recompense implements Serializable{
	
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

private static final long serialVersionUID = 1710234886606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "recompenseId")
	private Long recompenseId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "montant")
	private Integer montant;
	
	
	
}
