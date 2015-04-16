package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;


/**
 * The persistent class for the app_souscription database table.
 * 
 */
@Entity
@Table(name="app_souscription")
@NamedQuery(name="AppSouscription.findAll", query="SELECT a FROM AppSouscription a")
public class AppSouscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	private Array date;

	private Integer status;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="id_veterinary")
	private Veterinary veterinary;

	public AppSouscription() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Array getDate() {
		return this.date;
	}

	public void setDate(Array date) {
		this.date = date;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

}