package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name="image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer clouded;

	@Column(name="name_examen", nullable=false, length=100)
	private String nameExamen;

	@Column(name="path_image", nullable=false, length=150)
	private String pathImage;

	@Column(name="path_thumbnail", nullable=false, length=150)
	private String pathThumbnail;

	@Column(nullable=false)
	private Integer quality;

	@Column(name="serie_number", nullable=false)
	private Integer serieNumber;

	@Column(nullable=false)
	private Integer used;

	//bi-directional many-to-one association to Description
	@ManyToOne
	@JoinColumn(name="description_id", nullable=false)
	private Description description;

	//bi-directional many-to-one association to HeaderDicom
	@ManyToOne
	@JoinColumn(name="header_dicom_id", nullable=false)
	private HeaderDicom headerDicom;

	//bi-directional many-to-one association to ImageSerie
	@ManyToOne
	@JoinColumn(name="image_serie_id", nullable=false)
	private ImageSerie imageSerie;

	//bi-directional many-to-one association to RadioModality
	@ManyToOne
	@JoinColumn(name="radio_modality_id", nullable=false)
	private RadioModality radioModality;

	//bi-directional many-to-one association to TreatmentProtocol
	@ManyToOne
	@JoinColumn(name="treatment_protocol_id", nullable=false)
	private TreatmentProtocol treatmentProtocol;

	public Image() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClouded() {
		return this.clouded;
	}

	public void setClouded(Integer clouded) {
		this.clouded = clouded;
	}

	public String getNameExamen() {
		return this.nameExamen;
	}

	public void setNameExamen(String nameExamen) {
		this.nameExamen = nameExamen;
	}

	public String getPathImage() {
		return this.pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getPathThumbnail() {
		return this.pathThumbnail;
	}

	public void setPathThumbnail(String pathThumbnail) {
		this.pathThumbnail = pathThumbnail;
	}

	public Integer getQuality() {
		return this.quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getSerieNumber() {
		return this.serieNumber;
	}

	public void setSerieNumber(Integer serieNumber) {
		this.serieNumber = serieNumber;
	}

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Description getDescription() {
		return this.description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public HeaderDicom getHeaderDicom() {
		return this.headerDicom;
	}

	public void setHeaderDicom(HeaderDicom headerDicom) {
		this.headerDicom = headerDicom;
	}

	public ImageSerie getImageSerie() {
		return this.imageSerie;
	}

	public void setImageSerie(ImageSerie imageSerie) {
		this.imageSerie = imageSerie;
	}

	public RadioModality getRadioModality() {
		return this.radioModality;
	}

	public void setRadioModality(RadioModality radioModality) {
		this.radioModality = radioModality;
	}

	public TreatmentProtocol getTreatmentProtocol() {
		return this.treatmentProtocol;
	}

	public void setTreatmentProtocol(TreatmentProtocol treatmentProtocol) {
		this.treatmentProtocol = treatmentProtocol;
	}

}