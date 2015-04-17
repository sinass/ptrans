package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal_file database table.
 * 
 */
@Entity
@Table(name="animal_file")
@NamedQuery(name="AnimalFile.findAll", query="SELECT a FROM AnimalFile a")
public class AnimalFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="animal_id", nullable=false)
	private Animal animal;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="veterinary_id", nullable=false)
	private Veterinary veterinary;

	//bi-directional many-to-one association to Study
	@OneToMany(mappedBy="animalFile")
	private List<Study> studies;

	public AnimalFile() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

	public List<Study> getStudies() {
		return this.studies;
	}

	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}

	public Study addStudy(Study study) {
		getStudies().add(study);
		study.setAnimalFile(this);

		return study;
	}

	public Study removeStudy(Study study) {
		getStudies().remove(study);
		study.setAnimalFile(null);

		return study;
	}

}