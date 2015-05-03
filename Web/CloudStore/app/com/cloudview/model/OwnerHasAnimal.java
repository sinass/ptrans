package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the owner_has_animal database table.
 * 
 */
@Entity
@Table(name="owner_has_animal")
@NamedQuery(name="OwnerHasAnimal.findAll", query="SELECT o FROM OwnerHasAnimal o")
public class OwnerHasAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	private Animal animal;

	//bi-directional many-to-one association to Owner
	@ManyToOne
	private Owner owner;

	public OwnerHasAnimal() {
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

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}