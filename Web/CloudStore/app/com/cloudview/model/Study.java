package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the study database table.
 * 
 */
@Entity
@Table(name="study")
@NamedQuery(name="Study.findAll", query="SELECT s FROM Study s")
public class Study implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private float height;

	@Column(name="old_id_study", nullable=false)
	private Integer oldIdStudy;

	@Column(nullable=false, length=45)
	private String report;

	@Column(name="start_date", nullable=false)
	private Timestamp startDate;

	@Column(nullable=false)
	private Integer used;

	@Column(nullable=false)
	private float weight;

	//bi-directional many-to-one association to Examination
	@OneToMany(mappedBy="study")
	private List<Examination> examinations;

	//bi-directional many-to-one association to AnimalFile
	@ManyToOne
	@JoinColumn(name="animal_file_id", nullable=false)
	private AnimalFile animalFile;

	public Study() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Integer getOldIdStudy() {
		return this.oldIdStudy;
	}

	public void setOldIdStudy(Integer oldIdStudy) {
		this.oldIdStudy = oldIdStudy;
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

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
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