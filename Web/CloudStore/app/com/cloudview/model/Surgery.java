package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the surgery database table.
 * 
 */
@Entity
@Table(name="surgery")
@NamedQuery(name="Surgery.findAll", query="SELECT s FROM Surgery s")
public class Surgery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=255)
	private String adress;

	@Column(nullable=false, length=45)
	private String city;

	@Column(nullable=false, length=45)
	private String country;

	@Column(length=45)
	private String mail;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false, length=45)
	private String phone;

	@Column(name="post_code", nullable=false)
	private Integer postCode;

	//bi-directional many-to-one association to Veterinary
	@OneToMany(mappedBy="surgery")
	private List<Veterinary> veterinaries;

	public Surgery() {
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

	public List<Veterinary> getVeterinaries() {
		return this.veterinaries;
	}

	public void setVeterinaries(List<Veterinary> veterinaries) {
		this.veterinaries = veterinaries;
	}

	public Veterinary addVeterinary(Veterinary veterinary) {
		getVeterinaries().add(veterinary);
		veterinary.setSurgery(this);

		return veterinary;
	}

	public Veterinary removeVeterinary(Veterinary veterinary) {
		getVeterinaries().remove(veterinary);
		veterinary.setSurgery(null);

		return veterinary;
	}

}