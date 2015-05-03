package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the study database table.
 * 
 */
@Entity
@NamedQuery(name="Study.findAll", query="SELECT s FROM Study s")
public class Study implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String report;

	@Column(name="start_date")
	private Timestamp startDate;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="study")
	private List<Diagnosi> diagnosis;

	//bi-directional many-to-one association to Examination
	@OneToMany(mappedBy="study")
	private List<Examination> examinations;

	//bi-directional many-to-one association to AnimalFile
	@ManyToOne
	@JoinColumn(name="animal_file_id")
	private AnimalFile animalFile;

	public Study() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public List<Diagnosi> getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(List<Diagnosi> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Diagnosi addDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().add(diagnosi);
		diagnosi.setStudy(this);

		return diagnosi;
	}

	public Diagnosi removeDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().remove(diagnosi);
		diagnosi.setStudy(null);

		return diagnosi;
	}

	public List<Examination> getExaminations() {
		return this.examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public Examination addExamination(Examination examination) {
		getExaminations().add(examination);
		examination.setStudy(this);

		return examination;
	}

	public Examination removeExamination(Examination examination) {
		getExaminations().remove(examination);
		examination.setStudy(null);

		return examination;
	}

	public AnimalFile getAnimalFile() {
		return this.animalFile;
	}

	public void setAnimalFile(AnimalFile animalFile) {
		this.animalFile = animalFile;
	}

}