package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_veterinary database table.
 * 
 */
@Entity
@Table(name="app_veterinary")
@NamedQuery(name="AppVeterinary.findAll", query="SELECT a FROM AppVeterinary a")
public class AppVeterinary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to AppAnimalFile
	@OneToMany(mappedBy="appVeterinary")
	private List<AppAnimalFile> appAnimalFiles;

	//bi-directional many-to-one association to AppExamination
	@OneToMany(mappedBy="appVeterinary")
	private List<AppExamination> appExaminations;

	//bi-directional many-to-one association to AppResilliation
	@OneToMany(mappedBy="appVeterinary")
	private List<AppResilliation> appResilliations;

	//bi-directional many-to-one association to AppSouscription
	@OneToMany(mappedBy="appVeterinary")
	private List<AppSouscription> appSouscriptions;

	//bi-directional many-to-one association to AppBucket
	@ManyToOne
	@JoinColumn(name="bucket_id")
	private AppBucket appBucket;

	//bi-directional many-to-one association to AppSurgery
	@ManyToOne
	@JoinColumn(name="surgery_id")
	private AppSurgery appSurgery;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUser appUser;

	public AppVeterinary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<AppAnimalFile> getAppAnimalFiles() {
		return this.appAnimalFiles;
	}

	public void setAppAnimalFiles(List<AppAnimalFile> appAnimalFiles) {
		this.appAnimalFiles = appAnimalFiles;
	}

	public AppAnimalFile addAppAnimalFile(AppAnimalFile appAnimalFile) {
		getAppAnimalFiles().add(appAnimalFile);
		appAnimalFile.setAppVeterinary(this);

		return appAnimalFile;
	}

	public AppAnimalFile removeAppAnimalFile(AppAnimalFile appAnimalFile) {
		getAppAnimalFiles().remove(appAnimalFile);
		appAnimalFile.setAppVeterinary(null);

		return appAnimalFile;
	}

	public List<AppExamination> getAppExaminations() {
		return this.appExaminations;
	}

	public void setAppExaminations(List<AppExamination> appExaminations) {
		this.appExaminations = appExaminations;
	}

	public AppExamination addAppExamination(AppExamination appExamination) {
		getAppExaminations().add(appExamination);
		appExamination.setAppVeterinary(this);

		return appExamination;
	}

	public AppExamination removeAppExamination(AppExamination appExamination) {
		getAppExaminations().remove(appExamination);
		appExamination.setAppVeterinary(null);

		return appExamination;
	}

	public List<AppResilliation> getAppResilliations() {
		return this.appResilliations;
	}

	public void setAppResilliations(List<AppResilliation> appResilliations) {
		this.appResilliations = appResilliations;
	}

	public AppResilliation addAppResilliation(AppResilliation appResilliation) {
		getAppResilliations().add(appResilliation);
		appResilliation.setAppVeterinary(this);

		return appResilliation;
	}

	public AppResilliation removeAppResilliation(AppResilliation appResilliation) {
		getAppResilliations().remove(appResilliation);
		appResilliation.setAppVeterinary(null);

		return appResilliation;
	}

	public List<AppSouscription> getAppSouscriptions() {
		return this.appSouscriptions;
	}

	public void setAppSouscriptions(List<AppSouscription> appSouscriptions) {
		this.appSouscriptions = appSouscriptions;
	}

	public AppSouscription addAppSouscription(AppSouscription appSouscription) {
		getAppSouscriptions().add(appSouscription);
		appSouscription.setAppVeterinary(this);

		return appSouscription;
	}

	public AppSouscription removeAppSouscription(AppSouscription appSouscription) {
		getAppSouscriptions().remove(appSouscription);
		appSouscription.setAppVeterinary(null);

		return appSouscription;
	}

	public AppBucket getAppBucket() {
		return this.appBucket;
	}

	public void setAppBucket(AppBucket appBucket) {
		this.appBucket = appBucket;
	}

	public AppSurgery getAppSurgery() {
		return this.appSurgery;
	}

	public void setAppSurgery(AppSurgery appSurgery) {
		this.appSurgery = appSurgery;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}