package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veterinary database table.
 * 
 */
@Entity
@NamedQuery(name="Veterinary.findAll", query="SELECT v FROM Veterinary v")
public class Veterinary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String code;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String mail;

	private String status;

	//bi-directional many-to-one association to AnimalFile
	@OneToMany(mappedBy="veterinary")
	private List<AnimalFile> animalFiles;

	//bi-directional many-to-one association to Desouscription
	@OneToMany(mappedBy="veterinary")
	private List<Desouscription> desouscriptions;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="veterinary1")
	private List<Diagnosi> diagnosis1;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="veterinary2")
	private List<Diagnosi> diagnosis2;

	//bi-directional many-to-one association to Examination
	@OneToMany(mappedBy="veterinary")
	private List<Examination> examinations;

	//bi-directional many-to-one association to Souscription
	@OneToMany(mappedBy="veterinary")
	private List<Souscription> souscriptions;

	//bi-directional many-to-one association to Bucket
	@ManyToOne
	private Bucket bucket;

	//bi-directional many-to-one association to Surgery
	@ManyToOne
	private Surgery surgery;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Veterinary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AnimalFile> getAnimalFiles() {
		return this.animalFiles;
	}

	public void setAnimalFiles(List<AnimalFile> animalFiles) {
		this.animalFiles = animalFiles;
	}

	public AnimalFile addAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().add(animalFile);
		animalFile.setVeterinary(this);

		return animalFile;
	}

	public AnimalFile removeAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().remove(animalFile);
		animalFile.setVeterinary(null);

		return animalFile;
	}

	public List<Desouscription> getDesouscriptions() {
		return this.desouscriptions;
	}

	public void setDesouscriptions(List<Desouscription> desouscriptions) {
		this.desouscriptions = desouscriptions;
	}

	public Desouscription addDesouscription(Desouscription desouscription) {
		getDesouscriptions().add(desouscription);
		desouscription.setVeterinary(this);

		return desouscription;
	}

	public Desouscription removeDesouscription(Desouscription desouscription) {
		getDesouscriptions().remove(desouscription);
		desouscription.setVeterinary(null);

		return desouscription;
	}

	public List<Diagnosi> getDiagnosis1() {
		return this.diagnosis1;
	}

	public void setDiagnosis1(List<Diagnosi> diagnosis1) {
		this.diagnosis1 = diagnosis1;
	}

	public Diagnosi addDiagnosis1(Diagnosi diagnosis1) {
		getDiagnosis1().add(diagnosis1);
		diagnosis1.setVeterinary1(this);

		return diagnosis1;
	}

	public Diagnosi removeDiagnosis1(Diagnosi diagnosis1) {
		getDiagnosis1().remove(diagnosis1);
		diagnosis1.setVeterinary1(null);

		return diagnosis1;
	}

	public List<Diagnosi> getDiagnosis2() {
		return this.diagnosis2;
	}

	public void setDiagnosis2(List<Diagnosi> diagnosis2) {
		this.diagnosis2 = diagnosis2;
	}

	public Diagnosi addDiagnosis2(Diagnosi diagnosis2) {
		getDiagnosis2().add(diagnosis2);
		diagnosis2.setVeterinary2(this);

		return diagnosis2;
	}

	public Diagnosi removeDiagnosis2(Diagnosi diagnosis2) {
		getDiagnosis2().remove(diagnosis2);
		diagnosis2.setVeterinary2(null);

		return diagnosis2;
	}

	public List<Examination> getExaminations() {
		return this.examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public Examination addExamination(Examination examination) {
		getExaminations().add(examination);
		examination.setVeterinary(this);

		return examination;
	}

	public Examination removeExamination(Examination examination) {
		getExaminations().remove(examination);
		examination.setVeterinary(null);

		return examination;
	}

	public List<Souscription> getSouscriptions() {
		return this.souscriptions;
	}

	public void setSouscriptions(List<Souscription> souscriptions) {
		this.souscriptions = souscriptions;
	}

	public Souscription addSouscription(Souscription souscription) {
		getSouscriptions().add(souscription);
		souscription.setVeterinary(this);

		return souscription;
	}

	public Souscription removeSouscription(Souscription souscription) {
		getSouscriptions().remove(souscription);
		souscription.setVeterinary(null);

		return souscription;
	}

	public Bucket getBucket() {
		return this.bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public Surgery getSurgery() {
		return this.surgery;
	}

	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}