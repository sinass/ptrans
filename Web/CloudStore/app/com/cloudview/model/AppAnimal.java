package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_animal database table.
 * 
 */
@Entity
@Table(name="app_animal")
@NamedQuery(name="AppAnimal.findAll", query="SELECT a FROM AppAnimal a")
public class AppAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String birthday;

	private String lof;

	private String name;

	private Integer sex;

	private String signes;

	private String tatouage;

	//bi-directional many-to-one association to AppAnimalFile
	@OneToMany(mappedBy="appAnimal")
	private List<AppAnimalFile> appAnimalFiles;

	//bi-directional one-to-one association to AppOwnerHasAnimal
	@OneToOne(mappedBy="appAnimal")
	private AppOwnerHasAnimal appOwnerHasAnimal;

	public AppOwnerHasAnimal getAppOwnerHasAnimal() {
		return appOwnerHasAnimal;
	}

	public void setAppOwnerHasAnimal(AppOwnerHasAnimal appOwnerHasAnimal) {
		this.appOwnerHasAnimal = appOwnerHasAnimal;
	}

	public AppAnimal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
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

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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

	public List<AppAnimalFile> getAppAnimalFiles() {
		return this.appAnimalFiles;
	}

	public void setAppAnimalFiles(List<AppAnimalFile> appAnimalFiles) {
		this.appAnimalFiles = appAnimalFiles;
	}

	public AppAnimalFile addAppAnimalFile(AppAnimalFile appAnimalFile) {
		getAppAnimalFiles().add(appAnimalFile);
		appAnimalFile.setAppAnimal(this);

		return appAnimalFile;
	}

	public AppAnimalFile removeAppAnimalFile(AppAnimalFile appAnimalFile) {
		getAppAnimalFiles().remove(appAnimalFile);
		appAnimalFile.setAppAnimal(null);

		return appAnimalFile;
	}

}