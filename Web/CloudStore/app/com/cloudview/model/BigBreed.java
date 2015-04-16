package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the big_breed database table.
 * 
 */
@Entity
@Table(name="big_breed")
@NamedQuery(name="BigBreed.findAll", query="SELECT b FROM BigBreed b")
public class BigBreed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to BigMorpho
	@ManyToOne
	@JoinColumn(name="big_morpho_id", nullable=false)
	private BigMorpho bigMorpho;

	//bi-directional one-to-one association to Breed
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Breed breed;

	public BigBreed() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigMorpho getBigMorpho() {
		return this.bigMorpho;
	}

	public void setBigMorpho(BigMorpho bigMorpho) {
		this.bigMorpho = bigMorpho;
	}

	public Breed getBreed() {
		return this.breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

}