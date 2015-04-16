package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_breed database table.
 * 
 */
@Entity
@Table(name="cat_breed")
@NamedQuery(name="CatBreed.findAll", query="SELECT c FROM CatBreed c")
public class CatBreed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional one-to-one association to Breed
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Breed breed;

	//bi-directional many-to-one association to CatMorpho
	@ManyToOne
	@JoinColumn(name="cat_morpho_id", nullable=false)
	private CatMorpho catMorpho;

	public CatBreed() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Breed getBreed() {
		return this.breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public CatMorpho getCatMorpho() {
		return this.catMorpho;
	}

	public void setCatMorpho(CatMorpho catMorpho) {
		this.catMorpho = catMorpho;
	}

}