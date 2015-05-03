package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bucket database table.
 * 
 */
@Entity
@NamedQuery(name="Bucket.findAll", query="SELECT b FROM Bucket b")
public class Bucket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="first_key")
	private String firstKey;

	@Column(name="second_key")
	private String secondKey;

	//bi-directional many-to-one association to Veterinary
	@OneToMany(mappedBy="bucket")
	private List<Veterinary> veterinaries;

	public Bucket() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstKey() {
		return this.firstKey;
	}

	public void setFirstKey(String firstKey) {
		this.firstKey = firstKey;
	}

	public String getSecondKey() {
		return this.secondKey;
	}

	public void setSecondKey(String secondKey) {
		this.secondKey = secondKey;
	}

	public List<Veterinary> getVeterinaries() {
		return this.veterinaries;
	}

	public void setVeterinaries(List<Veterinary> veterinaries) {
		this.veterinaries = veterinaries;
	}

	public Veterinary addVeterinary(Veterinary veterinary) {
		getVeterinaries().add(veterinary);
		veterinary.setBucket(this);

		return veterinary;
	}

	public Veterinary removeVeterinary(Veterinary veterinary) {
		getVeterinaries().remove(veterinary);
		veterinary.setBucket(null);

		return veterinary;
	}

}