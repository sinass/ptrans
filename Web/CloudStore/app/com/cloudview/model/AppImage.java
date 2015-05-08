package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_image database table.
 * 
 */
@Entity
@Table(name="app_image")
@NamedQuery(name="AppImage.findAll", query="SELECT a FROM AppImage a")
public class AppImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="number_in_serie")
	private Integer numberInSerie;

	@Column(name="path_image_name")
	private String pathImageName;

	@Column(name="path_thumbnail")
	private String pathThumbnail;

	private Integer quality;

	//bi-directional many-to-one association to AppImageSerie
	@ManyToOne
	@JoinColumn(name="image_serie_id")
	private AppImageSerie appImageSerie;

	//bi-directional many-to-one association to AppImageSharedWith
	@OneToMany(mappedBy="appImage")
	private List<AppImageSharedWith> appImageSharedWiths;

	public AppImage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberInSerie() {
		return this.numberInSerie;
	}

	public void setNumberInSerie(Integer numberInSerie) {
		this.numberInSerie = numberInSerie;
	}

	public String getPathImageName() {
		return this.pathImageName;
	}

	public void setPathImageName(String pathImageName) {
		this.pathImageName = pathImageName;
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

	public AppImageSerie getAppImageSerie() {
		return this.appImageSerie;
	}

	public void setAppImageSerie(AppImageSerie appImageSerie) {
		this.appImageSerie = appImageSerie;
	}

	public List<AppImageSharedWith> getAppImageSharedWiths() {
		return this.appImageSharedWiths;
	}

	public void setAppImageSharedWiths(List<AppImageSharedWith> appImageSharedWiths) {
		this.appImageSharedWiths = appImageSharedWiths;
	}

	public AppImageSharedWith addAppImageSharedWith(AppImageSharedWith appImageSharedWith) {
		getAppImageSharedWiths().add(appImageSharedWith);
		appImageSharedWith.setAppImage(this);

		return appImageSharedWith;
	}

	public AppImageSharedWith removeAppImageSharedWith(AppImageSharedWith appImageSharedWith) {
		getAppImageSharedWiths().remove(appImageSharedWith);
		appImageSharedWith.setAppImage(null);

		return appImageSharedWith;
	}

}