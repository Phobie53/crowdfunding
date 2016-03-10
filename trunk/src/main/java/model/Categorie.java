package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commentaire")
public class Categorie implements Serializable {

private static final long serialVersionUID = 1606599946L;
	
	@Id
	@GeneratedValue
	@Column(name = "catId")
	private Long catId;
	
	@Column(name = "type")
	private String type;
	
}
