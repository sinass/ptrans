package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String lof;

	private String name;

	private Integer sexe;

	private String signes;

	private String tatouage;

	//bi-directional many-to-one association to AnimalFile
	@OneToMany(mappedBy="animal")
	private List<AnimalFile> animalFiles;

	//bi-directional many-to-one association to OwnerHasAnimal
	@OneToMany(mappedBy="animal")
	private List<OwnerHasAnimal> ownerHasAnimals;

	public Animal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLof() {
		return this.lof;
	}

	public void setLof(String lof) {
		this.lof = lof;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSexe() {
		return this.sexe;
	}

	public void setSexe(Integer sexe) {
		this.sexe = sexe;
	}

	public String getSignes() {
		return this.signes;
	}

	public void setSignes(String signes) {
		this.signes = signes;
	}

	public String getTatouage() {
		return this.tatouage;
	}

	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}

	public List<AnimalFile> getAnimalFiles() {
		return this.animalFiles;
	}

	public void setAnimalFiles(List<AnimalFile> animalFiles) {
		this.animalFiles = animalFiles;
	}

	public AnimalFile addAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().add(animalFile);
		animalFile.setAnimal(this);

		return animalFile;
	}

	public AnimalFile removeAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().remove(animalFile);
		animalFile.setAnimal(null);

		return animalFile;
	}

	public List<OwnerHasAnimal> getOwnerHasAnimals() {
		return this.ownerHasAnimals;
	}

	public void setOwnerHasAnimals(List<OwnerHasAnimal> ownerHasAnimals) {
		this.ownerHasAnimals = ownerHasAnimals;
	}

	public OwnerHasAnimal addOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().add(ownerHasAnimal);
		ownerHasAnimal.setAnimal(this);

		return ownerHasAnimal;
	}

	public OwnerHasAnimal removeOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().remove(ownerHasAnimal);
		ownerHasAnimal.setAnimal(null);

		return ownerHasAnimal;
	}

}