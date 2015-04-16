package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the description database table.
 * 
 */
@Entity
@Table(name="description")
@NamedQuery(name="Description.findAll", query="SELECT d FROM Description d")
public class Description implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="animal_position", nullable=false, length=45)
	private String animalPosition;

	@Column(nullable=false)
	private float roi;

	//bi-directional many-to-one association to AnatomicalRegion
	@ManyToOne
	@JoinColumn(name="anatomical_region_id", nullable=false)
	private AnatomicalRegion anatomicalRegion;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="description")
	private List<Image> images;

	public Description() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnimalPosition() {
		return this.animalPosition;
	}

	public void setAnimalPosition(String animalPosition) {
		this.animalPosition = animalPosition;
	}

	public float getRoi() {
		return this.roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}

	public AnatomicalRegion getAnatomicalRegion() {
		return this.anatomicalRegion;
	}

	public void setAnatomicalRegion(AnatomicalRegion anatomicalRegion) {
		this.anatomicalRegion = anatomicalRegion;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setDescription(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setDescription(null);

		return image;
	}

}