package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filter database table.
 * 
 */
@Entity
@Table(name="filter")
@NamedQuery(name="Filter.findAll", query="SELECT f FROM Filter f")
public class Filter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=20)
	private String name;

	//bi-directional one-to-one association to FilterHasTreatmentProtocol
	@OneToOne(mappedBy="filter")
	private FilterHasTreatmentProtocol filterHasTreatmentProtocol;

	public Filter() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FilterHasTreatmentProtocol getFilterHasTreatmentProtocol() {
		return this.filterHasTreatmentProtocol;
	}

	public void setFilterHasTreatmentProtocol(FilterHasTreatmentProtocol filterHasTreatmentProtocol) {
		this.filterHasTreatmentProtocol = filterHasTreatmentProtocol;
	}

}