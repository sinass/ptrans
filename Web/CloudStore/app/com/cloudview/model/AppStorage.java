package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;


/**
 * The persistent class for the app_storage database table.
 * 
 */
@Entity
@Table(name="app_storage")
@NamedQuery(name="AppStorage.findAll", query="SELECT a FROM AppStorage a")
public class AppStorage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="bucket_name", length=50)
	private Array bucketName;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_veterinary")
	private Veterinary veterinary;

	public AppStorage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Array getBucketName() {
		return this.bucketName;
	}

	public void setBucketName(Array bucketName) {
		this.bucketName = bucketName;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

}