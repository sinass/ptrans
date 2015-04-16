package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nac_breed database table.
 * 
 */
@Entity
@Table(name="nac_breed")
@NamedQuery(name="NacBreed.findAll", query="SELECT n FROM NacBreed n")
public class NacBreed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional one-to-one association to Breed
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Breed breed;

	//bi-directional many-to-one association to NacMorpho
	@ManyToOne
	@JoinColumn(name="nac_morpho_id", nullable=false)
	private NacMorpho nacMorpho;

	public NacBreed() {
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

	public NacMorpho getNacMorpho() {
		return this.nacMorpho;
	}

	public void setNacMorpho(NacMorpho nacMorpho) {
		this.nacMorpho = nacMorpho;
	}

}