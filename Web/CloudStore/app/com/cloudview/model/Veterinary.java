package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veterinary database table.
 * 
 */
@Entity
@Table(name="veterinary")
@NamedQuery(name="Veterinary.findAll", query="SELECT v FROM Veterinary v")
public class Veterinary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String code;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(length=45)
	private String mail;

	@Column(length=45)
	private String status;

	@Column(nullable=false)
	private Integer used;

	//bi-directional many-to-one association to AnimalFile
	@OneToMany(mappedBy="veterinary")
	private List<AnimalFile> animalFiles;

	//bi-directional many-to-one association to AppDiagnosi
	@OneToMany(mappedBy="veterinary1")
	private List<AppDiagnosi> appDiagnosis1;

	//bi-directional many-to-one association to AppDiagnosi
	@OneToMany(mappedBy="veterinary2")
	private List<AppDiagnosi> appDiagnosis2;

	//bi-directional many-to-one association to AppSouscription
	@OneToMany(mappedBy="veterinary")
	private List<AppSouscription> appSouscriptions;

	//bi-directional many-to-one association to AppStorage
	@OneToMany(mappedBy="veterinary")
	private List<AppStorage> appStorages;

	//bi-directional many-to-one association to CahierTir
	@OneToMany(mappedBy="veterinary")
	private List<CahierTir> cahierTirs;

	//bi-directional many-to-one association to Examination
	@OneToMany(mappedBy="veterinary")
	private List<Examination> examinations;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private AppUser appUser;

	//bi-directional many-to-one association to Surgery
	@ManyToOne
	@JoinColumn(name="surgery_id", nullable=false)
	private Surgery surgery;

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

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
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

	public List<AppDiagnosi> getAppDiagnosis1() {
		return this.appDiagnosis1;
	}

	public void setAppDiagnosis1(List<AppDiagnosi> appDiagnosis1) {
		this.appDiagnosis1 = appDiagnosis1;
	}

	public AppDiagnosi addAppDiagnosis1(AppDiagnosi appDiagnosis1) {
		getAppDiagnosis1().add(appDiagnosis1);
		appDiagnosis1.setVeterinary1(this);

		return appDiagnosis1;
	}

	public AppDiagnosi removeAppDiagnosis1(AppDiagnosi appDiagnosis1) {
		getAppDiagnosis1().remove(appDiagnosis1);
		appDiagnosis1.setVeterinary1(null);

		return appDiagnosis1;
	}

	public List<AppDiagnosi> getAppDiagnosis2() {
		return this.appDiagnosis2;
	}

	public void setAppDiagnosis2(List<AppDiagnosi> appDiagnosis2) {
		this.appDiagnosis2 = appDiagnosis2;
	}

	public AppDiagnosi addAppDiagnosis2(AppDiagnosi appDiagnosis2) {
		getAppDiagnosis2().add(appDiagnosis2);
		appDiagnosis2.setVeterinary2(this);

		return appDiagnosis2;
	}

	public AppDiagnosi removeAppDiagnosis2(AppDiagnosi appDiagnosis2) {
		getAppDiagnosis2().remove(appDiagnosis2);
		appDiagnosis2.setVeterinary2(null);

		return appDiagnosis2;
	}

	public List<AppSouscription> getAppSouscriptions() {
		return this.appSouscriptions;
	}

	public void setAppSouscriptions(List<AppSouscription> appSouscriptions) {
		this.appSouscriptions = appSouscriptions;
	}

	public AppSouscription addAppSouscription(AppSouscription appSouscription) {
		getAppSouscriptions().add(appSouscription);
		appSouscription.setVeterinary(this);

		return appSouscription;
	}

	public AppSouscription removeAppSouscription(AppSouscription appSouscription) {
		getAppSouscriptions().remove(appSouscription);
		appSouscription.setVeterinary(null);

		return appSouscription;
	}

	public List<AppStorage> getAppStorages() {
		return this.appStorages;
	}

	public void setAppStorages(List<AppStorage> appStorages) {
		this.appStorages = appStorages;
	}

	public AppStorage addAppStorage(AppStorage appStorage) {
		getAppStorages().add(appStorage);
		appStorage.setVeterinary(this);

		return appStorage;
	}

	public AppStorage removeAppStorage(AppStorage appStorage) {
		getAppStorages().remove(appStorage);
		appStorage.setVeterinary(null);

		return appStorage;
	}

	public List<CahierTir> getCahierTirs() {
		return this.cahierTirs;
	}

	public void setCahierTirs(List<CahierTir> cahierTirs) {
		this.cahierTirs = cahierTirs;
	}

	public CahierTir addCahierTir(CahierTir cahierTir) {
		getCahierTirs().add(cahierTir);
		cahierTir.setVeterinary(this);

		return cahierTir;
	}

	public CahierTir removeCahierTir(CahierTir cahierTir) {
		getCahierTirs().remove(cahierTir);
		cahierTir.setVeterinary(null);

		return cahierTir;
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

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Surgery getSurgery() {
		return this.surgery;
	}

	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}

}