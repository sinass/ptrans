package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="name_de", length=45)
	private String nameDe;

	@Column(name="name_en", length=45)
	private String nameEn;

	@Column(name="name_es", length=45)
	private String nameEs;

	@Column(name="name_fr", length=45)
	private String nameFr;

	@Column(name="name_zh", length=45)
	private String nameZh;

	//bi-directional many-to-one association to BigGroup
	@OneToMany(mappedBy="category")
	private List<BigGroup> bigGroups;

	//bi-directional many-to-one association to CatGroup
	@OneToMany(mappedBy="category")
	private List<CatGroup> catGroups;

	//bi-directional many-to-one association to DogGroup
	@OneToMany(mappedBy="category")
	private List<DogGroup> dogGroups;

	//bi-directional many-to-one association to NacGroup
	@OneToMany(mappedBy="category")
	private List<NacGroup> nacGroups;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameDe() {
		return this.nameDe;
	}

	public void setNameDe(String nameDe) {
		this.nameDe = nameDe;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameEs() {
		return this.nameEs;
	}

	public void setNameEs(String nameEs) {
		this.nameEs = nameEs;
	}

	public String getNameFr() {
		return this.nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public List<BigGroup> getBigGroups() {
		return this.bigGroups;
	}

	public void setBigGroups(List<BigGroup> bigGroups) {
		this.bigGroups = bigGroups;
	}

	public BigGroup addBigGroup(BigGroup bigGroup) {
		getBigGroups().add(bigGroup);
		bigGroup.setCategory(this);

		return bigGroup;
	}

	public BigGroup removeBigGroup(BigGroup bigGroup) {
		getBigGroups().remove(bigGroup);
		bigGroup.setCategory(null);

		return bigGroup;
	}

	public List<CatGroup> getCatGroups() {
		return this.catGroups;
	}

	public void setCatGroups(List<CatGroup> catGroups) {
		this.catGroups = catGroups;
	}

	public CatGroup addCatGroup(CatGroup catGroup) {
		getCatGroups().add(catGroup);
		catGroup.setCategory(this);

		return catGroup;
	}

	public CatGroup removeCatGroup(CatGroup catGroup) {
		getCatGroups().remove(catGroup);
		catGroup.setCategory(null);

		return catGroup;
	}

	public List<DogGroup> getDogGroups() {
		return this.dogGroups;
	}

	public void setDogGroups(List<DogGroup> dogGroups) {
		this.dogGroups = dogGroups;
	}

	public DogGroup addDogGroup(DogGroup dogGroup) {
		getDogGroups().add(dogGroup);
		dogGroup.setCategory(this);

		return dogGroup;
	}

	public DogGroup removeDogGroup(DogGroup dogGroup) {
		getDogGroups().remove(dogGroup);
		dogGroup.setCategory(null);

		return dogGroup;
	}

	public List<NacGroup> getNacGroups() {
		return this.nacGroups;
	}

	public void setNacGroups(List<NacGroup> nacGroups) {
		this.nacGroups = nacGroups;
	}

	public NacGroup addNacGroup(NacGroup nacGroup) {
		getNacGroups().add(nacGroup);
		nacGroup.setCategory(this);

		return nacGroup;
	}

	public NacGroup removeNacGroup(NacGroup nacGroup) {
		getNacGroups().remove(nacGroup);
		nacGroup.setCategory(null);

		return nacGroup;
	}

}