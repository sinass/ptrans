package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the radio_modality database table.
 * 
 */
@Entity
@Table(name="radio_modality")
@NamedQuery(name="RadioModality.findAll", query="SELECT r FROM RadioModality r")
public class RadioModality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="capteur_plan_position", nullable=false)
	private float capteurPlanPosition;

	@Column(name="emma_sensor_position", nullable=false)
	private float emmaSensorPosition;

	@Column(name="exposure_time", nullable=false)
	private float exposureTime;

	@Column(name="focal_distance", nullable=false)
	private float focalDistance;

	@Column(nullable=false)
	private float kv;

	@Column(nullable=false)
	private float ma;

	@Column(nullable=false)
	private float mas;

	@Column(name="release_dose", nullable=false)
	private float releaseDose;

	@Column(name="source_position", nullable=false)
	private float sourcePosition;

	//bi-directional many-to-one association to CahierTir
	@OneToMany(mappedBy="radioModality")
	private List<CahierTir> cahierTirs;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="radioModality")
	private List<Image> images;

	//bi-directional many-to-one association to AcquisitionSystem
	@ManyToOne
	@JoinColumn(name="acquisition_system_id", nullable=false)
	private AcquisitionSystem acquisitionSystem;

	//bi-directional many-to-one association to Radioprotection
	@ManyToOne
	@JoinColumn(name="radioprotection_id", nullable=false)
	private Radioprotection radioprotection;

	public RadioModality() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getCapteurPlanPosition() {
		return this.capteurPlanPosition;
	}

	public void setCapteurPlanPosition(float capteurPlanPosition) {
		this.capteurPlanPosition = capteurPlanPosition;
	}

	public float getEmmaSensorPosition() {
		return this.emmaSensorPosition;
	}

	public void setEmmaSensorPosition(float emmaSensorPosition) {
		this.emmaSensorPosition = emmaSensorPosition;
	}

	public float getExposureTime() {
		return this.exposureTime;
	}

	public void setExposureTime(float exposureTime) {
		this.exposureTime = exposureTime;
	}

	public float getFocalDistance() {
		return this.focalDistance;
	}

	public void setFocalDistance(float focalDistance) {
		this.focalDistance = focalDistance;
	}

	public float getKv() {
		return this.kv;
	}

	public void setKv(float kv) {
		this.kv = kv;
	}

	public float getMa() {
		return this.ma;
	}

	public void setMa(float ma) {
		this.ma = ma;
	}

	public float getMas() {
		return this.mas;
	}

	public void setMas(float mas) {
		this.mas = mas;
	}

	public float getReleaseDose() {
		return this.releaseDose;
	}

	public void setReleaseDose(float releaseDose) {
		this.releaseDose = releaseDose;
	}

	public float getSourcePosition() {
		return this.sourcePosition;
	}

	public void setSourcePosition(float sourcePosition) {
		this.sourcePosition = sourcePosition;
	}

	public List<CahierTir> getCahierTirs() {
		return this.cahierTirs;
	}

	public void setCahierTirs(List<CahierTir> cahierTirs) {
		this.cahierTirs = cahierTirs;
	}

	public CahierTir addCahierTir(CahierTir cahierTir) {
		getCahierTirs().add(cahierTir);
		cahierTir.setRadioModality(this);

		return cahierTir;
	}

	public CahierTir removeCahierTir(CahierTir cahierTir) {
		getCahierTirs().remove(cahierTir);
		cahierTir.setRadioModality(null);

		return cahierTir;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setRadioModality(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setRadioModality(null);

		return image;
	}

	public AcquisitionSystem getAcquisitionSystem() {
		return this.acquisitionSystem;
	}

	public void setAcquisitionSystem(AcquisitionSystem acquisitionSystem) {
		this.acquisitionSystem = acquisitionSystem;
	}

	public Radioprotection getRadioprotection() {
		return this.radioprotection;
	}

	public void setRadioprotection(Radioprotection radioprotection) {
		this.radioprotection = radioprotection;
	}

}