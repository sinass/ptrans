package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="grant_access")
	private Integer grantAccess;

	private String login;

	private String password;

	private String type;

	//bi-directional many-to-one association to ImageSharedWith
	@OneToMany(mappedBy="user1")
	private List<ImageSharedWith> imageSharedWiths1;

	//bi-directional many-to-one association to ImageSharedWith
	@OneToMany(mappedBy="user2")
	private List<ImageSharedWith> imageSharedWiths2;

	//bi-directional many-to-one association to Owner
	@OneToMany(mappedBy="user")
	private List<Owner> owners;

	//bi-directional many-to-one association to ServiceNotification
	@OneToMany(mappedBy="user")
	private List<ServiceNotification> serviceNotifications;

	//bi-directional many-to-one association to Veterinary
	@OneToMany(mappedBy="user")
	private List<Veterinary> veterinaries;

	public User() {
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

	public List<ImageSharedWith> getImageSharedWiths1() {
		return this.imageSharedWiths1;
	}

	public void setImageSharedWiths1(List<ImageSharedWith> imageSharedWiths1) {
		this.imageSharedWiths1 = imageSharedWiths1;
	}

	public ImageSharedWith addImageSharedWiths1(ImageSharedWith imageSharedWiths1) {
		getImageSharedWiths1().add(imageSharedWiths1);
		imageSharedWiths1.setUser1(this);

		return imageSharedWiths1;
	}

	public ImageSharedWith removeImageSharedWiths1(ImageSharedWith imageSharedWiths1) {
		getImageSharedWiths1().remove(imageSharedWiths1);
		imageSharedWiths1.setUser1(null);

		return imageSharedWiths1;
	}

	public List<ImageSharedWith> getImageSharedWiths2() {
		return this.imageSharedWiths2;
	}

	public void setImageSharedWiths2(List<ImageSharedWith> imageSharedWiths2) {
		this.imageSharedWiths2 = imageSharedWiths2;
	}

	public ImageSharedWith addImageSharedWiths2(ImageSharedWith imageSharedWiths2) {
		getImageSharedWiths2().add(imageSharedWiths2);
		imageSharedWiths2.setUser2(this);

		return imageSharedWiths2;
	}

	public ImageSharedWith removeImageSharedWiths2(ImageSharedWith imageSharedWiths2) {
		getImageSharedWiths2().remove(imageSharedWiths2);
		imageSharedWiths2.setUser2(null);

		return imageSharedWiths2;
	}

	public List<Owner> getOwners() {
		return this.owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	public Owner addOwner(Owner owner) {
		getOwners().add(owner);
		owner.setUser(this);

		return owner;
	}

	public Owner removeOwner(Owner owner) {
		getOwners().remove(owner);
		owner.setUser(null);

		return owner;
	}

	public List<ServiceNotification> getServiceNotifications() {
		return this.serviceNotifications;
	}

	public void setServiceNotifications(List<ServiceNotification> serviceNotifications) {
		this.serviceNotifications = serviceNotifications;
	}

	public ServiceNotification addServiceNotification(ServiceNotification serviceNotification) {
		getServiceNotifications().add(serviceNotification);
		serviceNotification.setUser(this);

		return serviceNotification;
	}

	public ServiceNotification removeServiceNotification(ServiceNotification serviceNotification) {
		getServiceNotifications().remove(serviceNotification);
		serviceNotification.setUser(null);

		return serviceNotification;
	}

	public List<Veterinary> getVeterinaries() {
		return this.veterinaries;
	}

	public void setVeterinaries(List<Veterinary> veterinaries) {
		this.veterinaries = veterinaries;
	}

	public Veterinary addVeterinary(Veterinary veterinary) {
		getVeterinaries().add(veterinary);
		veterinary.setUser(this);

		return veterinary;
	}

	public Veterinary removeVeterinary(Veterinary veterinary) {
		getVeterinaries().remove(veterinary);
		veterinary.setUser(null);

		return veterinary;
	}

}