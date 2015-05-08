package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the app_resilliation database table.
 * 
 */
@Entity
@Table(name="app_resilliation")
@NamedQuery(name="AppResilliation.findAll", query="SELECT a FROM AppResilliation a")
public class AppResilliation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Integer status;

	//bi-directional many-to-one association to AppVeterinary
	@OneToOne
	@JoinColumn(name="veterinary_id")
	private AppVeterinary appVeterinary;

	public AppResilliation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AppVeterinary getAppVeterinary() {
		return this.appVeterinary;
	}

	public void setAppVeterinary(AppVeterinary appVeterinary) {
		this.appVeterinary = appVeterinary;
	}

}