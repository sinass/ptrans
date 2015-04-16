package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the examination database table.
 * 
 */
@Entity
@Table(name="examination")
@NamedQuery(name="Examination.findAll", query="SELECT e FROM Examination e")
public class Examination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer anesthesic;

	@Column(name="date_examination", nullable=false)
	private Timestamp dateExamination;

	@Column(name="diagnostis_report", length=2147483647)
	private String diagnostisReport;

	@Column(name="is_local", nullable=false)
	private Integer isLocal;

	@Column(name="is_share", nullable=false)
	private Integer isShare;

	@Column(nullable=false, length=150)
	private String pathreport;

	//bi-directional many-to-one association to Pathology
	@ManyToOne
	@JoinColumn(name="pathology_id", nullable=false)
	private Pathology pathology;

	//bi-directional many-to-one association to Study
	@ManyToOne
	@JoinColumn(name="study_id", nullable=false)
	private Study study;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="veterinary_id", nullable=false)
	private Veterinary veterinary;

	//bi-directional many-to-one association to ImageSerie
	@OneToMany(mappedBy="examination")
	private List<ImageSerie> imageSeries;

	public Examination() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnesthesic() {
		return this.anesthesic;
	}

	public void setAnesthesic(Integer anesthesic) {
		this.anesthesic = anesthesic;
	}

	public Timestamp getDateExamination() {
		return this.dateExamination;
	}

	public void setDateExamination(Timestamp dateExamination) {
		this.dateExamination = dateExamination;
	}

	public String getDiagnostisReport() {
		return this.diagnostisReport;
	}

	public void setDiagnostisReport(String diagnostisReport) {
		this.diagnostisReport = diagnostisReport;
	}

	public Integer getIsLocal() {
		return this.isLocal;
	}

	public void setIsLocal(Integer isLocal) {
		this.isLocal = isLocal;
	}

	public Integer getIsShare() {
		return this.isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	public String getPathreport() {
		return this.pathreport;
	}

	public void setPathreport(String pathreport) {
		this.pathreport = pathreport;
	}

	public Pathology getPathology() {
		return this.pathology;
	}

	public void setPathology(Pathology pathology) {
		this.pathology = pathology;
	}

	public Study getStudy() {
		return this.study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

	public List<ImageSerie> getImageSeries() {
		return this.imageSeries;
	}

	public void setImageSeries(List<ImageSerie> imageSeries) {
		this.imageSeries = imageSeries;
	}

	public ImageSerie addImageSery(ImageSerie imageSery) {
		getImageSeries().add(imageSery);
		imageSery.setExamination(this);

		return imageSery;
	}

	public ImageSerie removeImageSery(ImageSerie imageSery) {
		getImageSeries().remove(imageSery);
		imageSery.setExamination(null);

		return imageSery;
	}

}