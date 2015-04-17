package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_morpho database table.
 * 
 */
@Entity
@Table(name="cat_morpho")
@NamedQuery(name="CatMorpho.findAll", query="SELECT c FROM CatMorpho c")
public class CatMorpho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=10)
	private String body;

	@Column(length=10)
	private String frame;

	private Integer fur;

	//bi-directional many-to-one association to CatBreed
	@OneToMany(mappedBy="catMorpho")
	private List<CatBreed> catBreeds;

	//bi-directional many-to-one association to CatGroup
	@ManyToOne
	@JoinColumn(name="cat_group_id", nullable=false)
	private CatGroup catGroup;

	public CatMorpho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public Integer getFur() {
		return this.fur;
	}

	public void setFur(Integer fur) {
		this.fur = fur;
	}

	public List<CatBreed> getCatBreeds() {
		return this.catBreeds;
	}

	public void setCatBreeds(List<CatBreed> catBreeds) {
		this.catBreeds = catBreeds;
	}

	public CatBreed addCatBreed(CatBreed catBreed) {
		getCatBreeds().add(catBreed);
		catBreed.setCatMorpho(this);

		return catBreed;
	}

	public CatBreed removeCatBreed(CatBreed catBreed) {
		getCatBreeds().remove(catBreed);
		catBreed.setCatMorpho(null);

		return catBreed;
	}

	public CatGroup getCatGroup() {
		return this.catGroup;
	}

	public void setCatGroup(CatGroup catGroup) {
		this.catGroup = catGroup;
	}

}