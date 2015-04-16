package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the header_dicom database table.
 * 
 */
@Entity
@Table(name="header_dicom")
@NamedQuery(name="HeaderDicom.findAll", query="SELECT h FROM HeaderDicom h")
public class HeaderDicom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=150)
	private String sopinstuid;

	@Column(nullable=false)
	private float height;

	@Column(name="image_type", nullable=false, length=100)
	private String imageType;

	@Column(nullable=false, length=20)
	private String modality;

	@Column(name="pixel_size", nullable=false, length=100)
	private String pixelSize;

	@Column(name="protocol_name", nullable=false, length=100)
	private String protocolName;

	@Column(nullable=false, length=100)
	private String resolution;

	@Column(nullable=false, length=150)
	private String seriesinstanceuid;

	@Column(nullable=false, length=150)
	private String sopclassuid;

	@Column(nullable=false, length=150)
	private String studyinstanceuid;

	@Column(nullable=false)
	private float width;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="headerDicom")
	private List<Image> images;

	public HeaderDicom() {
	}

	public String getSopinstuid() {
		return this.sopinstuid;
	}

	public void setSopinstuid(String sopinstuid) {
		this.sopinstuid = sopinstuid;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getImageType() {
		return this.imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getModality() {
		return this.modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getPixelSize() {
		return this.pixelSize;
	}

	public void setPixelSize(String pixelSize) {
		this.pixelSize = pixelSize;
	}

	public String getProtocolName() {
		return this.protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSeriesinstanceuid() {
		return this.seriesinstanceuid;
	}

	public void setSeriesinstanceuid(String seriesinstanceuid) {
		this.seriesinstanceuid = seriesinstanceuid;
	}

	public String getSopclassuid() {
		return this.sopclassuid;
	}

	public void setSopclassuid(String sopclassuid) {
		this.sopclassuid = sopclassuid;
	}

	public String getStudyinstanceuid() {
		return this.studyinstanceuid;
	}

	public void setStudyinstanceuid(String studyinstanceuid) {
		this.studyinstanceuid = studyinstanceuid;
	}

	public float getWidth() {
		return this.width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setHeaderDicom(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setHeaderDicom(null);

		return image;
	}

}