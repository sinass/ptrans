package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dog_group database table.
 * 
 */
@Entity
@Table(name="dog_group")
@NamedQuery(name="DogGroup.findAll", query="SELECT d FROM DogGroup d")
public class DogGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to DogMorpho
	@OneToMany(mappedBy="dogGroup")
	private List<DogMorpho> dogMorphos;

	public DogGroup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<DogMorpho> getDogMorphos() {
		return this.dogMorphos;
	}

	public void setDogMorphos(List<DogMorpho> dogMorphos) {
		this.dogMorphos = dogMorphos;
	}

	public DogMorpho addDogMorpho(DogMorpho dogMorpho) {
		getDogMorphos().add(dogMorpho);
		dogMorpho.setDogGroup(this);

		return dogMorpho;
	}

	public DogMorpho removeDogMorpho(DogMorpho dogMorpho) {
		getDogMorphos().remove(dogMorpho);
		dogMorpho.setDogGroup(null);

		return dogMorpho;
	}

}