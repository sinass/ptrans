package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the owner database table.
 * 
 */
@Entity
@NamedQuery(name="Owner.findAll", query="SELECT o FROM Owner o")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adress;

	private String city;

	private String country;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String mail;

	private String phone;

	@Column(name="post_code")
	private Integer postCode;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to OwnerHasAnimal
	@OneToMany(mappedBy="owner")
	private List<OwnerHasAnimal> ownerHasAnimals;

	public Owner() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPostCode() {
		return this.postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OwnerHasAnimal> getOwnerHasAnimals() {
		return this.ownerHasAnimals;
	}

	public void setOwnerHasAnimals(List<OwnerHasAnimal> ownerHasAnimals) {
		this.ownerHasAnimals = ownerHasAnimals;
	}

	public OwnerHasAnimal addOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().add(ownerHasAnimal);
		ownerHasAnimal.setOwner(this);

		return ownerHasAnimal;
	}

	public OwnerHasAnimal removeOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().remove(ownerHasAnimal);
		ownerHasAnimal.setOwner(null);

		return ownerHasAnimal;
	}

}