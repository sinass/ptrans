package com.cloudview.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	@OneToOne(mappedBy="appBucket")
	@JsonManagedReference
	private AppVeterinary appVeterinarie;

	public AppVeterinary getAppVeterinarie() {
		return appVeterinarie;
	}

	public void setAppVeterinarie(AppVeterinary appVeterinarie) {
		this.appVeterinarie = appVeterinarie;
	}

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

}