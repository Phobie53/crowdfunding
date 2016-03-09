package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commentaire")
public class Categorie {

private static final long serialVersionUID = 1710234886606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "catId")
	private Long catId;
	
	@Column(name = "type")
	private String type;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
