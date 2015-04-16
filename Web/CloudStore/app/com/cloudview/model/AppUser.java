package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;
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
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	private Array login;

	@Column(length=255)
	private Array password;

	@Column(length=10)
	private Array type;

	//bi-directional many-to-one association to Owner
	@OneToMany(mappedBy="appUser")
	private List<Owner> owners;

	//bi-directional many-to-one association to ServiceNotification
	@OneToMany(mappedBy="appUser")
	private List<ServiceNotification> serviceNotifications;

	//bi-directional many-to-one association to Veterinary
	@OneToMany(mappedBy="appUser")
	private List<Veterinary> veterinaries;

	public AppUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Array getLogin() {
		return this.login;
	}

	public void setLogin(Array login) {
		this.login = login;
	}

	public Array getPassword() {
		return this.password;
	}

	public void setPassword(Array password) {
		this.password = password;
	}

	public Array getType() {
		return this.type;
	}

	public void setType(Array type) {
		this.type = type;
	}

	public List<Owner> getOwners() {
		return this.owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	public Owner addOwner(Owner owner) {
		getOwners().add(owner);
		owner.setAppUser(this);

		return owner;
	}

	public Owner removeOwner(Owner owner) {
		getOwners().remove(owner);
		owner.setAppUser(null);

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
		serviceNotification.setAppUser(this);

		return serviceNotification;
	}

	public ServiceNotification removeServiceNotification(ServiceNotification serviceNotification) {
		getServiceNotifications().remove(serviceNotification);
		serviceNotification.setAppUser(null);

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
		veterinary.setAppUser(this);

		return veterinary;
	}

	public Veterinary removeVeterinary(Veterinary veterinary) {
		getVeterinaries().remove(veterinary);
		veterinary.setAppUser(null);

		return veterinary;
	}

}