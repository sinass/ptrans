package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_owner database table.
 * 
 */
@Entity
@Table(name="app_owner")
@NamedQuery(name="AppOwner.findAll", query="SELECT a FROM AppOwner a")
public class AppOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to AppOwnerHasAnimal
	@OneToMany(mappedBy="appOwner")
	private List<AppOwnerHasAnimal> appOwnerHasAnimals;

	public AppOwner() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<AppOwnerHasAnimal> getAppOwnerHasAnimals() {
		return this.appOwnerHasAnimals;
	}

	public void setAppOwnerHasAnimals(List<AppOwnerHasAnimal> appOwnerHasAnimals) {
		this.appOwnerHasAnimals = appOwnerHasAnimals;
	}

	public AppOwnerHasAnimal addAppOwnerHasAnimal(AppOwnerHasAnimal appOwnerHasAnimal) {
		getAppOwnerHasAnimals().add(appOwnerHasAnimal);
		appOwnerHasAnimal.setAppOwner(this);

		return appOwnerHasAnimal;
	}

	public AppOwnerHasAnimal removeAppOwnerHasAnimal(AppOwnerHasAnimal appOwnerHasAnimal) {
		getAppOwnerHasAnimals().remove(appOwnerHasAnimal);
		appOwnerHasAnimal.setAppOwner(null);

		return appOwnerHasAnimal;
	}

}