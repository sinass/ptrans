package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_study database table.
 * 
 */
@Entity
@Table(name="app_study")
@NamedQuery(name="AppStudy.findAll", query="SELECT a FROM AppStudy a")
public class AppStudy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String report;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to AppExamination
	@OneToMany(mappedBy="appStudy")
	private List<AppExamination> appExaminations;

	//bi-directional many-to-one association to AppAnimalFile
	@ManyToOne
	@JoinColumn(name="animal_file_id")
	private AppAnimalFile appAnimalFile;

	public AppStudy() {
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<AppExamination> getAppExaminations() {
		return this.appExaminations;
	}

	public void setAppExaminations(List<AppExamination> appExaminations) {
		this.appExaminations = appExaminations;
	}

	public AppExamination addAppExamination(AppExamination appExamination) {
		getAppExaminations().add(appExamination);
		appExamination.setAppStudy(this);

		return appExamination;
	}

	public AppExamination removeAppExamination(AppExamination appExamination) {
		getAppExaminations().remove(appExamination);
		appExamination.setAppStudy(null);

		return appExamination;
	}

	public AppAnimalFile getAppAnimalFile() {
		return this.appAnimalFile;
	}

	public void setAppAnimalFile(AppAnimalFile appAnimalFile) {
		this.appAnimalFile = appAnimalFile;
	}

}