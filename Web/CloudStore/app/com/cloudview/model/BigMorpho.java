package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the big_morpho database table.
 * 
 */
@Entity
@Table(name="big_morpho")
@NamedQuery(name="BigMorpho.findAll", query="SELECT b FROM BigMorpho b")
public class BigMorpho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=10)
	private String ear;

	private Integer fur;

	private Integer muscular;

	@Column(length=10)
	private String tail;

	//bi-directional many-to-one association to BigBreed
	@OneToMany(mappedBy="bigMorpho")
	private List<BigBreed> bigBreeds;

	//bi-directional many-to-one association to BigGroup
	@ManyToOne
	@JoinColumn(name="big_group_id", nullable=false)
	private BigGroup bigGroup;

	public BigMorpho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEar() {
		return this.ear;
	}

	public void setEar(String ear) {
		this.ear = ear;
	}

	public Integer getFur() {
		return this.fur;
	}

	public void setFur(Integer fur) {
		this.fur = fur;
	}

	public Integer getMuscular() {
		return this.muscular;
	}

	public void setMuscular(Integer muscular) {
		this.muscular = muscular;
	}

	public String getTail() {
		return this.tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public List<BigBreed> getBigBreeds() {
		return this.bigBreeds;
	}

	public void setBigBreeds(List<BigBreed> bigBreeds) {
		this.bigBreeds = bigBreeds;
	}

	public BigBreed addBigBreed(BigBreed bigBreed) {
		getBigBreeds().add(bigBreed);
		bigBreed.setBigMorpho(this);

		return bigBreed;
	}

	public BigBreed removeBigBreed(BigBreed bigBreed) {
		getBigBreeds().remove(bigBreed);
		bigBreed.setBigMorpho(null);

		return bigBreed;
	}

	public BigGroup getBigGroup() {
		return this.bigGroup;
	}

	public void setBigGroup(BigGroup bigGroup) {
		this.bigGroup = bigGroup;
	}

}