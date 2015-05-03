package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the souscription database table.
 * 
 */
@Entity
@NamedQuery(name="Souscription.findAll", query="SELECT s FROM Souscription s")
public class Souscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Integer status;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_veterinary")
	private Veterinary veterinary;

	public Souscription() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

}