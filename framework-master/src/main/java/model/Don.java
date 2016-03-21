package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Don")
public class Don implements Serializable{
	
private static final long serialVersionUID = 1710234886606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "donId")
	private Long donId;
	
	@Column(name = "montant")
	private String montant;

	public Long getDonId() {
		return donId;
	}

	public void setDonId(Long donId) {
		this.donId = donId;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "date")
	private Date date;

}
