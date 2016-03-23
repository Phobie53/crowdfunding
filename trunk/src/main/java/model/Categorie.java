package model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {

private static final long serialVersionUID = 1606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "categorieId")
	private Long categorieId;
	
	@Column(name = "type")
	private String type;
	

	@OneToMany(mappedBy="categorie")
    private List<Projet> projets;

	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	public Long getCategorieId() {
		return categorieId;
	}


	public void setCategorieId(Long categorieId) {
		this.categorieId = categorieId;
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
