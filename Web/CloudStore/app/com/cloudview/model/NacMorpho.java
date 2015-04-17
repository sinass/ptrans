package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nac_morpho database table.
 * 
 */
@Entity
@Table(name="nac_morpho")
@NamedQuery(name="NacMorpho.findAll", query="SELECT n FROM NacMorpho n")
public class NacMorpho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	private Integer fur;

	@Column(name="legs_number")
	private Integer legsNumber;

	@Column(length=1)
	private String wing;

	//bi-directional many-to-one association to NacBreed
	@OneToMany(mappedBy="nacMorpho")
	private List<NacBreed> nacBreeds;

	//bi-directional many-to-one association to NacGroup
	@ManyToOne
	@JoinColumn(name="nac_group_id", nullable=false)
	private NacGroup nacGroup;

	public NacMorpho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFur() {
		return this.fur;
	}

	public void setFur(Integer fur) {
		this.fur = fur;
	}

	public Integer getLegsNumber() {
		return this.legsNumber;
	}

	public void setLegsNumber(Integer legsNumber) {
		this.legsNumber = legsNumber;
	}

	public String getWing() {
		return this.wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public List<NacBreed> getNacBreeds() {
		return this.nacBreeds;
	}

	public void setNacBreeds(List<NacBreed> nacBreeds) {
		this.nacBreeds = nacBreeds;
	}

	public NacBreed addNacBreed(NacBreed nacBreed) {
		getNacBreeds().add(nacBreed);
		nacBreed.setNacMorpho(this);

		return nacBreed;
	}

	public NacBreed removeNacBreed(NacBreed nacBreed) {
		getNacBreeds().remove(nacBreed);
		nacBreed.setNacMorpho(null);

		return nacBreed;
	}

	public NacGroup getNacGroup() {
		return this.nacGroup;
	}

	public void setNacGroup(NacGroup nacGroup) {
		this.nacGroup = nacGroup;
	}

}