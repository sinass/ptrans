package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cahier_tirs database table.
 * 
 */
@Entity
@Table(name="cahier_tirs")
@NamedQuery(name="CahierTir.findAll", query="SELECT c FROM CahierTir c")
public class CahierTir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to RadioModality
	@ManyToOne
	@JoinColumn(name="radio_modality_id", nullable=false)
	private RadioModality radioModality;

	//bi-directional many-to-one association to Veterinary
	@ManyToOne
	@JoinColumn(name="veterinary_id", nullable=false)
	private Veterinary veterinary;

	public CahierTir() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RadioModality getRadioModality() {
		return this.radioModality;
	}

	public void setRadioModality(RadioModality radioModality) {
		this.radioModality = radioModality;
	}

	public Veterinary getVeterinary() {
		return this.veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

}