package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_owner_has_animal database table.
 * 
 */
@Entity
@Table(name="app_owner_has_animal")
@NamedQuery(name="AppOwnerHasAnimal.findAll", query="SELECT a FROM AppOwnerHasAnimal a")
public class AppOwnerHasAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to AppAnimal
	@ManyToOne
	@JoinColumn(name="animal_id")
	private AppAnimal appAnimal;

	//bi-directional many-to-one association to AppOwner
	@ManyToOne
	@JoinColumn(name="owner_id")
	private AppOwner appOwner;

	public AppOwnerHasAnimal() {
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

	public AppOwner getAppOwner() {
		return this.appOwner;
	}

	public void setAppOwner(AppOwner appOwner) {
		this.appOwner = appOwner;
	}

}