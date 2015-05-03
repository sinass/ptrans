package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diagnosis database table.
 * 
 */
@Entity
@Table(name="diagnosis")
@NamedQuery(name="Diagnosi.findAll", query="SELECT d FROM Diagnosi d")
public class Diagnosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String report;

	private Integer status;

	private String type;

	//bi-directional many-to-one association to Study
	@ManyToOne
	@JoinColumn(name="id_study")
	private Study study;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_sender")
	private Veterinary veterinary1;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_receiver")
	private Veterinary veterinary2;

	public Diagnosi() {
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

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Study getStudy() {
		return this.study;
	}

	public void setStudy(Study study) {
		this.study = study;
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