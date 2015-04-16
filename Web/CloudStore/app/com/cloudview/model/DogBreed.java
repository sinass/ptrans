package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dog_breed database table.
 * 
 */
@Entity
@Table(name="dog_breed")
@NamedQuery(name="DogBreed.findAll", query="SELECT d FROM DogBreed d")
public class DogBreed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional one-to-one association to Breed
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Breed breed;

	//bi-directional many-to-one association to DogMorpho
	@ManyToOne
	@JoinColumn(name="dog_morpho_id", nullable=false)
	private DogMorpho dogMorpho;

	public DogBreed() {
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

	public DogMorpho getDogMorpho() {
		return this.dogMorpho;
	}

	public void setDogMorpho(DogMorpho dogMorpho) {
		this.dogMorpho = dogMorpho;
	}

}