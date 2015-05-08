package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_animal_file database table.
 * 
 */
@Entity
@Table(name="app_animal_file")
@NamedQuery(name="AppAnimalFile.findAll", query="SELECT a FROM AppAnimalFile a")
public class AppAnimalFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to AppAnimal
	@ManyToOne
	@JoinColumn(name="animal_id")
	private AppAnimal appAnimal;

	//bi-directional many-to-one association to AppVeterinary
	@ManyToOne
	@JoinColumn(name="veterinary_id")
	private AppVeterinary appVeterinary;

	//bi-directional many-to-one association to AppStudy
	@OneToMany(mappedBy="appAnimalFile")
	private List<AppStudy> appStudies;

	public AppAnimalFile() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppAnimal getAppAnimal() {
		return this.appAnimal;
	}

	public void setAppAnimal(AppAnimal appAnimal) {
		this.appAnimal = appAnimal;
	}

	public AppVeterinary getAppVeterinary() {
		return this.appVeterinary;
	}

	public void setAppVeterinary(AppVeterinary appVeterinary) {
		this.appVeterinary = appVeterinary;
	}

	public List<AppStudy> getAppStudies() {
		return this.appStudies;
	}

	public void setAppStudies(List<AppStudy> appStudies) {
		this.appStudies = appStudies;
	}

	public AppStudy addAppStudy(AppStudy appStudy) {
		getAppStudies().add(appStudy);
		appStudy.setAppAnimalFile(this);

		return appStudy;
	}

	public AppStudy removeAppStudy(AppStudy appStudy) {
		getAppStudies().remove(appStudy);
		appStudy.setAppAnimalFile(null);

		return appStudy;
	}

}