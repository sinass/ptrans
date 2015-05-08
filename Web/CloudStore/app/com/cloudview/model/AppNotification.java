package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_notification database table.
 * 
 */
@Entity
@Table(name="app_notification")
@NamedQuery(name="AppNotification.findAll", query="SELECT a FROM AppNotification a")
public class AppNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String text;

	@Column(name="viewed_status")
	private Integer viewedStatus;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUser appUser;

	public AppNotification() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getViewedStatus() {
		return this.viewedStatus;
	}

	public void setViewedStatus(Integer viewedStatus) {
		this.viewedStatus = viewedStatus;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}