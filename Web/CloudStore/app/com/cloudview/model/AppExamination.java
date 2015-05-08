package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_examination database table.
 * 
 */
@Entity
@Table(name="app_examination")
@NamedQuery(name="AppExamination.findAll", query="SELECT a FROM AppExamination a")
public class AppExamination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer anesthesis;

	@Temporal(TemporalType.DATE)
	@Column(name="date_examination")
	private Date dateExamination;

	@Column(name="diagnostic_report")
	private String diagnosticReport;

	@Column(name="is_shared")
	private Integer isShared;

	@Column(name="path_report")
	private String pathReport;

	//bi-directional many-to-one association to AppStudy
	@ManyToOne
	@JoinColumn(name="study_id")
	private AppStudy appStudy;

	//bi-directional many-to-one association to AppVeterinary
	@ManyToOne
	@JoinColumn(name="veterinary_id")
	private AppVeterinary appVeterinary;

	//bi-directional many-to-one association to AppImageSerie
	@OneToMany(mappedBy="appExamination")
	private List<AppImageSerie> appImageSeries;

	public AppExamination() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnesthesis() {
		return this.anesthesis;
	}

	public void setAnesthesis(Integer anesthesis) {
		this.anesthesis = anesthesis;
	}

	public Date getDateExamination() {
		return this.dateExamination;
	}

	public void setDateExamination(Date dateExamination) {
		this.dateExamination = dateExamination;
	}

	public String getDiagnosticReport() {
		return this.diagnosticReport;
	}

	public void setDiagnosticReport(String diagnosticReport) {
		this.diagnosticReport = diagnosticReport;
	}

	public Integer getIsShared() {
		return this.isShared;
	}

	public void setIsShared(Integer isShared) {
		this.isShared = isShared;
	}

	public String getPathReport() {
		return this.pathReport;
	}

	public void setPathReport(String pathReport) {
		this.pathReport = pathReport;
	}

	public AppStudy getAppStudy() {
		return this.appStudy;
	}

	public void setAppStudy(AppStudy appStudy) {
		this.appStudy = appStudy;
	}

	public AppVeterinary getAppVeterinary() {
		return this.appVeterinary;
	}

	public void setAppVeterinary(AppVeterinary appVeterinary) {
		this.appVeterinary = appVeterinary;
	}

	public List<AppImageSerie> getAppImageSeries() {
		return this.appImageSeries;
	}

	public void setAppImageSeries(List<AppImageSerie> appImageSeries) {
		this.appImageSeries = appImageSeries;
	}

	public AppImageSerie addAppImageSery(AppImageSerie appImageSery) {
		getAppImageSeries().add(appImageSery);
		appImageSery.setAppExamination(this);

		return appImageSery;
	}

	public AppImageSerie removeAppImageSery(AppImageSerie appImageSery) {
		getAppImageSeries().remove(appImageSery);
		appImageSery.setAppExamination(null);

		return appImageSery;
	}

}