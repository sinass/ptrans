package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pathology database table.
 * 
 */
@Entity
@Table(name="pathology")
@NamedQuery(name="Pathology.findAll", query="SELECT p FROM Pathology p")
public class Pathology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Examination
	@OneToMany(mappedBy="pathology")
	private List<Examination> examinations;

	//bi-directional many-to-one association to AnatomicalRegion
	@ManyToOne
	@JoinColumn(name="anatomical_region_id", nullable=false)
	private AnatomicalRegion anatomicalRegion;

	public Pathology() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Examination> getExaminations() {
		return this.examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public Examination addExamination(Examination examination) {
		getExaminations().add(examination);
		examination.setPathology(this);

		return examination;
	}

	public Examination removeExamination(Examination examination) {
		getExaminations().remove(examination);
		examination.setPathology(null);

		return examination;
	}

	public AnatomicalRegion getAnatomicalRegion() {
		return this.anatomicalRegion;
	}

	public void setAnatomicalRegion(AnatomicalRegion anatomicalRegion) {
		this.anatomicalRegion = anatomicalRegion;
	}

}