package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the treatment_protocol database table.
 * 
 */
@Entity
@Table(name="treatment_protocol")
@NamedQuery(name="TreatmentProtocol.findAll", query="SELECT t FROM TreatmentProtocol t")
public class TreatmentProtocol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to FilterHasTreatmentProtocol
	@OneToMany(mappedBy="treatmentProtocol")
	private List<FilterHasTreatmentProtocol> filterHasTreatmentProtocols;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="treatmentProtocol")
	private List<Image> images;

	public TreatmentProtocol() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<FilterHasTreatmentProtocol> getFilterHasTreatmentProtocols() {
		return this.filterHasTreatmentProtocols;
	}

	public void setFilterHasTreatmentProtocols(List<FilterHasTreatmentProtocol> filterHasTreatmentProtocols) {
		this.filterHasTreatmentProtocols = filterHasTreatmentProtocols;
	}

	public FilterHasTreatmentProtocol addFilterHasTreatmentProtocol(FilterHasTreatmentProtocol filterHasTreatmentProtocol) {
		getFilterHasTreatmentProtocols().add(filterHasTreatmentProtocol);
		filterHasTreatmentProtocol.setTreatmentProtocol(this);

		return filterHasTreatmentProtocol;
	}

	public FilterHasTreatmentProtocol removeFilterHasTreatmentProtocol(FilterHasTreatmentProtocol filterHasTreatmentProtocol) {
		getFilterHasTreatmentProtocols().remove(filterHasTreatmentProtocol);
		filterHasTreatmentProtocol.setTreatmentProtocol(null);

		return filterHasTreatmentProtocol;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setTreatmentProtocol(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setTreatmentProtocol(null);

		return image;
	}

}