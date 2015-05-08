package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_service_notification database table.
 * 
 */
@Entity
@Table(name="app_service_notification")
@NamedQuery(name="AppServiceNotification.findAll", query="SELECT a FROM AppServiceNotification a")
public class AppServiceNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String text;

	@Column(name="viewed_status")
	private Integer viewedStatus;

	public AppServiceNotification() {
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

}