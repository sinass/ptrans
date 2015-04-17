package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filter_has_treatment_protocol database table.
 * 
 */
@Entity
@Table(name="filter_has_treatment_protocol")
@NamedQuery(name="FilterHasTreatmentProtocol.findAll", query="SELECT f FROM FilterHasTreatmentProtocol f")
public class FilterHasTreatmentProtocol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="number_filter", nullable=false)
	private Integer numberFilter;

	//bi-directional one-to-one association to Filter
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Filter filter;

	//bi-directional many-to-one association to TreatmentProtocol
	@ManyToOne
	@JoinColumn(name="treatment_protocol_id", nullable=false)
	private TreatmentProtocol treatmentProtocol;

	public FilterHasTreatmentProtocol() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberFilter() {
		return this.numberFilter;
	}

	public void setNumberFilter(Integer numberFilter) {
		this.numberFilter = numberFilter;
	}

	public Filter getFilter() {
		return this.filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public TreatmentProtocol getTreatmentProtocol() {
		return this.treatmentProtocol;
	}

	public void setTreatmentProtocol(TreatmentProtocol treatmentProtocol) {
		this.treatmentProtocol = treatmentProtocol;
	}

}