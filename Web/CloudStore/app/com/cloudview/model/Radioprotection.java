package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the radioprotection database table.
 * 
 */
@Entity
@Table(name="radioprotection")
@NamedQuery(name="Radioprotection.findAll", query="SELECT r FROM Radioprotection r")
public class Radioprotection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer distance;

	@Column(nullable=false)
	private Integer dose;

	@Column(nullable=false)
	private Integer duration;

	//bi-directional many-to-one association to RadioModality
	@OneToMany(mappedBy="radioprotection")
	private List<RadioModality> radioModalities;

	public Radioprotection() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getDose() {
		return this.dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<RadioModality> getRadioModalities() {
		return this.radioModalities;
	}

	public void setRadioModalities(List<RadioModality> radioModalities) {
		this.radioModalities = radioModalities;
	}

	public RadioModality addRadioModality(RadioModality radioModality) {
		getRadioModalities().add(radioModality);
		radioModality.setRadioprotection(this);

		return radioModality;
	}

	public RadioModality removeRadioModality(RadioModality radioModality) {
		getRadioModalities().remove(radioModality);
		radioModality.setRadioprotection(null);

		return radioModality;
	}

}