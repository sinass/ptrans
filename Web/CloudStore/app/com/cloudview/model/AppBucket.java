package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_bucket database table.
 * 
 */
@Entity
@Table(name="app_bucket")
@NamedQuery(name="AppBucket.findAll", query="SELECT a FROM AppBucket a")
public class AppBucket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to AppVeterinary
	@OneToMany(mappedBy="appBucket")
	private List<AppVeterinary> appVeterinaries;

	public AppBucket() {
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

	public List<AppVeterinary> getAppVeterinaries() {
		return this.appVeterinaries;
	}

	public void setAppVeterinaries(List<AppVeterinary> appVeterinaries) {
		this.appVeterinaries = appVeterinaries;
	}

	public AppVeterinary addAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().add(appVeterinary);
		appVeterinary.setAppBucket(this);

		return appVeterinary;
	}

	public AppVeterinary removeAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().remove(appVeterinary);
		appVeterinary.setAppBucket(null);

		return appVeterinary;
	}

}