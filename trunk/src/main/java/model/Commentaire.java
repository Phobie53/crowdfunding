package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commentaire")
public class Commentaire implements Serializable {
	
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

private static final long serialVersionUID = 1710234886606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "ComId")
	private Long comId;
	
	@Column(name = "description")
	private String description;


}
