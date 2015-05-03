package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer clouded;

	@Column(name="name_examen")
	private String nameExamen;

	@Column(name="number_in_serie")
	private Integer numberInSerie;

	@Column(name="path_image")
	private String pathImage;

	@Column(name="path_thumbnail")
	private String pathThumbnail;

	private Integer quality;

	private Integer used;

	//bi-directional many-to-one association to ImageSerie
	@ManyToOne
	@JoinColumn(name="image_serie_id")
	private ImageSerie imageSerie;

	//bi-directional many-to-one association to ImageSharedWith
	@OneToMany(mappedBy="image")
	private List<ImageSharedWith> imageSharedWiths;

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

	public Integer getNumberInSerie() {
		return this.numberInSerie;
	}

	public void setNumberInSerie(Integer numberInSerie) {
		this.numberInSerie = numberInSerie;
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

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public ImageSerie getImageSerie() {
		return this.imageSerie;
	}

	public void setImageSerie(ImageSerie imageSerie) {
		this.imageSerie = imageSerie;
	}

	public List<ImageSharedWith> getImageSharedWiths() {
		return this.imageSharedWiths;
	}

	public void setImageSharedWiths(List<ImageSharedWith> imageSharedWiths) {
		this.imageSharedWiths = imageSharedWiths;
	}

	public ImageSharedWith addImageSharedWith(ImageSharedWith imageSharedWith) {
		getImageSharedWiths().add(imageSharedWith);
		imageSharedWith.setImage(this);

		return imageSharedWith;
	}

	public ImageSharedWith removeImageSharedWith(ImageSharedWith imageSharedWith) {
		getImageSharedWiths().remove(imageSharedWith);
		imageSharedWith.setImage(null);

		return imageSharedWith;
	}

}