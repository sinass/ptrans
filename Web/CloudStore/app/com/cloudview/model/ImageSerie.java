package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image_serie database table.
 * 
 */
@Entity
@Table(name="image_serie")
@NamedQuery(name="ImageSerie.findAll", query="SELECT i FROM ImageSerie i")
public class ImageSerie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="serie_number")
	private Integer serieNumber;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="imageSerie")
	private List<Image> images;

	//bi-directional many-to-one association to Examination
	@ManyToOne
	private Examination examination;

	public ImageSerie() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSerieNumber() {
		return this.serieNumber;
	}

	public void setSerieNumber(Integer serieNumber) {
		this.serieNumber = serieNumber;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setImageSerie(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setImageSerie(null);

		return image;
	}

	public Examination getExamination() {
		return this.examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

}