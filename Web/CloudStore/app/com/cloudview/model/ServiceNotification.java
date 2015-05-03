package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the service_notification database table.
 * 
 */
@Entity
@Table(name="service_notification")
@NamedQuery(name="ServiceNotification.findAll", query="SELECT s FROM ServiceNotification s")
public class ServiceNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer status;

	private String text;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public ServiceNotification() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}