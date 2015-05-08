package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_surgery database table.
 * 
 */
@Entity
@Table(name="app_surgery")
@NamedQuery(name="AppSurgery.findAll", query="SELECT a FROM AppSurgery a")
public class AppSurgery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adress;

	private String city;

	private String country;

	private String mail;

	private String name;

	private String phone;

	@Column(name="post_code")
	private Integer postCode;

	//bi-directional many-to-one association to AppVeterinary
	@OneToMany(mappedBy="appSurgery")
	private List<AppVeterinary> appVeterinaries;

	public AppSurgery() {
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

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<AppVeterinary> getAppVeterinaries() {
		return this.appVeterinaries;
	}

	public void setAppVeterinaries(List<AppVeterinary> appVeterinaries) {
		this.appVeterinaries = appVeterinaries;
	}

	public AppVeterinary addAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().add(appVeterinary);
		appVeterinary.setAppSurgery(this);

		return appVeterinary;
	}

	public AppVeterinary removeAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().remove(appVeterinary);
		appVeterinary.setAppSurgery(null);

		return appVeterinary;
	}

}