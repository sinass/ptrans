package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the app_image_shared_with database table.
 * 
 */
@Entity
@Table(name="app_image_shared_with")
@NamedQuery(name="AppImageSharedWith.findAll", query="SELECT a FROM AppImageSharedWith a")
public class AppImageSharedWith implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="share_end_date")
	private Date shareEndDate;

	//bi-directional many-to-one association to AppImage
	@ManyToOne
	@JoinColumn(name="image_id")
	private AppImage appImage;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUser appUser;

	public AppImageSharedWith() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getShareEndDate() {
		return this.shareEndDate;
	}

	public void setShareEndDate(Date shareEndDate) {
		this.shareEndDate = shareEndDate;
	}

	public AppImage getAppImage() {
		return this.appImage;
	}

	public void setAppImage(AppImage appImage) {
		this.appImage = appImage;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}