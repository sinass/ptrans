package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dog_morpho database table.
 * 
 */
@Entity
@Table(name="dog_morpho")
@NamedQuery(name="DogMorpho.findAll", query="SELECT d FROM DogMorpho d")
public class DogMorpho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=10)
	private String ear;

	private Integer fur;

	private Integer height;

	private Integer muscular;

	@Column(length=10)
	private String paw;

	@Column(length=10)
	private String tail;

	//bi-directional many-to-one association to DogBreed
	@OneToMany(mappedBy="dogMorpho")
	private List<DogBreed> dogBreeds;

	//bi-directional many-to-one association to DogGroup
	@ManyToOne
	@JoinColumn(name="dog_group_id", nullable=false)
	private DogGroup dogGroup;

	public DogMorpho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEar() {
		return this.ear;
	}

	public void setEar(String ear) {
		this.ear = ear;
	}

	public Integer getFur() {
		return this.fur;
	}

	public void setFur(Integer fur) {
		this.fur = fur;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMuscular() {
		return this.muscular;
	}

	public void setMuscular(Integer muscular) {
		this.muscular = muscular;
	}

	public String getPaw() {
		return this.paw;
	}

	public void setPaw(String paw) {
		this.paw = paw;
	}

	public String getTail() {
		return this.tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public List<DogBreed> getDogBreeds() {
		return this.dogBreeds;
	}

	public void setDogBreeds(List<DogBreed> dogBreeds) {
		this.dogBreeds = dogBreeds;
	}

	public DogBreed addDogBreed(DogBreed dogBreed) {
		getDogBreeds().add(dogBreed);
		dogBreed.setDogMorpho(this);

		return dogBreed;
	}

	public DogBreed removeDogBreed(DogBreed dogBreed) {
		getDogBreeds().remove(dogBreed);
		dogBreed.setDogMorpho(null);

		return dogBreed;
	}

	public DogGroup getDogGroup() {
		return this.dogGroup;
	}

	public void setDogGroup(DogGroup dogGroup) {
		this.dogGroup = dogGroup;
	}

}