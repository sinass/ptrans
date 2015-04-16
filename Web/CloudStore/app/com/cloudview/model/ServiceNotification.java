package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;


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
	@Column(unique=true, nullable=false)
	private Integer id;

	private Integer status;

	@Column(length=255)
	private Array text;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private AppUser appUser;

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

	public Array getText() {
		return this.text;
	}

	public void setText(Array text) {
		this.text = text;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}