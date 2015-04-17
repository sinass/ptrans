package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;


/**
 * The persistent class for the app_diagnosis database table.
 * 
 */
@Entity
@Table(name="app_diagnosis")
@NamedQuery(name="AppDiagnosi.findAll", query="SELECT a FROM AppDiagnosi a")
public class AppDiagnosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	private Array date;

	@Column(length=255)
	private Array report;

	private Integer status;

	@Column(length=14)
	private Array type;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_sender")
	private Veterinary veterinary1;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_receiver")
	private Veterinary veterinary2;

	public AppDiagnosi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Array getDate() {
		return this.date;
	}

	public void setDate(Array date) {
		this.date = date;
	}

	public Array getReport() {
		return this.report;
	}

	public void setReport(Array report) {
		this.report = report;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Array getType() {
		return this.type;
	}

	public void setType(Array type) {
		this.type = type;
	}

	public Veterinary getVeterinary1() {
		return this.veterinary1;
	}

	public void setVeterinary1(Veterinary veterinary1) {
		this.veterinary1 = veterinary1;
	}

	public Veterinary getVeterinary2() {
		return this.veterinary2;
	}

	public void setVeterinary2(Veterinary veterinary2) {
		this.veterinary2 = veterinary2;
	}

}