package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="app_user")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="grant_access")
	private Integer grantAccess;

	private String login;

	private String password;

	private String type;

	//bi-directional many-to-one association to AppImageSharedWith
	@OneToMany(mappedBy="appUser")
	private List<AppImageSharedWith> appImageSharedWiths;

	//bi-directional many-to-one association to AppNotification
	@OneToMany(mappedBy="appUser")
	private List<AppNotification> appNotifications;

	//bi-directional many-to-one association to AppVeterinary
	@OneToMany(mappedBy="appUser")
	private List<AppVeterinary> appVeterinaries;

	public AppUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGrantAccess() {
		return this.grantAccess;
	}

	public void setGrantAccess(Integer grantAccess) {
		this.grantAccess = grantAccess;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AppImageSharedWith> getAppImageSharedWiths() {
		return this.appImageSharedWiths;
	}

	public void setAppImageSharedWiths(List<AppImageSharedWith> appImageSharedWiths) {
		this.appImageSharedWiths = appImageSharedWiths;
	}

	public AppImageSharedWith addAppImageSharedWith(AppImageSharedWith appImageSharedWith) {
		getAppImageSharedWiths().add(appImageSharedWith);
		appImageSharedWith.setAppUser(this);

		return appImageSharedWith;
	}

	public AppImageSharedWith removeAppImageSharedWith(AppImageSharedWith appImageSharedWith) {
		getAppImageSharedWiths().remove(appImageSharedWith);
		appImageSharedWith.setAppUser(null);

		return appImageSharedWith;
	}

	public List<AppNotification> getAppNotifications() {
		return this.appNotifications;
	}

	public void setAppNotifications(List<AppNotification> appNotifications) {
		this.appNotifications = appNotifications;
	}

	public AppNotification addAppNotification(AppNotification appNotification) {
		getAppNotifications().add(appNotification);
		appNotification.setAppUser(this);

		return appNotification;
	}

	public AppNotification removeAppNotification(AppNotification appNotification) {
		getAppNotifications().remove(appNotification);
		appNotification.setAppUser(null);

		return appNotification;
	}

	public List<AppVeterinary> getAppVeterinaries() {
		return this.appVeterinaries;
	}

	public void setAppVeterinaries(List<AppVeterinary> appVeterinaries) {
		this.appVeterinaries = appVeterinaries;
	}

	public AppVeterinary addAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().add(appVeterinary);
		appVeterinary.setAppUser(this);

		return appVeterinary;
	}

	public AppVeterinary removeAppVeterinary(AppVeterinary appVeterinary) {
		getAppVeterinaries().remove(appVeterinary);
		appVeterinary.setAppUser(null);

		return appVeterinary;
	}

}