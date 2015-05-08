package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_image_serie database table.
 * 
 */
@Entity
@Table(name="app_image_serie")
@NamedQuery(name="AppImageSerie.findAll", query="SELECT a FROM AppImageSerie a")
public class AppImageSerie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="serie_number")
	private Integer serieNumber;

	//bi-directional many-to-one association to AppImage
	@OneToMany(mappedBy="appImageSerie")
	private List<AppImage> appImages;

	//bi-directional many-to-one association to AppExamination
	@ManyToOne
	@JoinColumn(name="examination_id")
	private AppExamination appExamination;

	public AppImageSerie() {
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

	public List<AppImage> getAppImages() {
		return this.appImages;
	}

	public void setAppImages(List<AppImage> appImages) {
		this.appImages = appImages;
	}

	public AppImage addAppImage(AppImage appImage) {
		getAppImages().add(appImage);
		appImage.setAppImageSerie(this);

		return appImage;
	}

	public AppImage removeAppImage(AppImage appImage) {
		getAppImages().remove(appImage);
		appImage.setAppImageSerie(null);

		return appImage;
	}

	public AppExamination getAppExamination() {
		return this.appExamination;
	}

	public void setAppExamination(AppExamination appExamination) {
		this.appExamination = appExamination;
	}

}