package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acquisition_system database table.
 * 
 */
@Entity
@Table(name="acquisition_system")
@NamedQuery(name="AcquisitionSystem.findAll", query="SELECT a FROM AcquisitionSystem a")
public class AcquisitionSystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String model;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false, length=45)
	private String reference;

	//bi-directional many-to-one association to Constant
	@OneToMany(mappedBy="acquisitionSystem")
	private List<Constant> constants;

	//bi-directional many-to-one association to RadioModality
	@OneToMany(mappedBy="acquisitionSystem")
	private List<RadioModality> radioModalities;

	public AcquisitionSystem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Constant> getConstants() {
		return this.constants;
	}

	public void setConstants(List<Constant> constants) {
		this.constants = constants;
	}

	public Constant addConstant(Constant constant) {
		getConstants().add(constant);
		constant.setAcquisitionSystem(this);

		return constant;
	}

	public Constant removeConstant(Constant constant) {
		getConstants().remove(constant);
		constant.setAcquisitionSystem(null);

		return constant;
	}

	public List<RadioModality> getRadioModalities() {
		return this.radioModalities;
	}

	public void setRadioModalities(List<RadioModality> radioModalities) {
		this.radioModalities = radioModalities;
	}

	public RadioModality addRadioModality(RadioModality radioModality) {
		getRadioModalities().add(radioModality);
		radioModality.setAcquisitionSystem(this);

		return radioModality;
	}

	public RadioModality removeRadioModality(RadioModality radioModality) {
		getRadioModalities().remove(radioModality);
		radioModality.setAcquisitionSystem(null);

		return radioModality;
	}

}