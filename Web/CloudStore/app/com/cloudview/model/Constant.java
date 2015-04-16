package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the constants database table.
 * 
 */
@Entity
@Table(name="constants")
@NamedQuery(name="Constant.findAll", query="SELECT c FROM Constant c")
public class Constant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="capteur_plan_position", nullable=false)
	private float capteurPlanPosition;

	@Column(nullable=false)
	private Integer epaisseur;

	@Column(name="exposure_time", nullable=false)
	private float exposureTime;

	@Column(name="focal_distance", nullable=false)
	private float focalDistance;

	@Column(nullable=false)
	private Integer focus;

	@Column(nullable=false)
	private float kv;

	@Column(nullable=false)
	private float ma;

	@Column(nullable=false)
	private float mas;

	@Column(name="release_dose", nullable=false)
	private float releaseDose;

	@Column(nullable=false)
	private Integer resolution;

	@Column(name="source_position", nullable=false)
	private float sourcePosition;

	//bi-directional many-to-one association to AcquisitionSystem
	@ManyToOne
	@JoinColumn(name="acquisition_system_id", nullable=false)
	private AcquisitionSystem acquisitionSystem;

	//bi-directional many-to-one association to AnatomicalRegion
	@ManyToOne
	@JoinColumn(name="anatomical_region_id", nullable=false)
	private AnatomicalRegion anatomicalRegion;

	//bi-directional many-to-one association to Breed
	@ManyToOne
	@JoinColumn(name="breed_id", nullable=false)
	private Breed breed;

	public Constant() {
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

	public Integer getEpaisseur() {
		return this.epaisseur;
	}

	public void setEpaisseur(Integer epaisseur) {
		this.epaisseur = epaisseur;
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

	public Integer getFocus() {
		return this.focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
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

	public Integer getResolution() {
		return this.resolution;
	}

	public void setResolution(Integer resolution) {
		this.resolution = resolution;
	}

	public float getSourcePosition() {
		return this.sourcePosition;
	}

	public void setSourcePosition(float sourcePosition) {
		this.sourcePosition = sourcePosition;
	}

	public AcquisitionSystem getAcquisitionSystem() {
		return this.acquisitionSystem;
	}

	public void setAcquisitionSystem(AcquisitionSystem acquisitionSystem) {
		this.acquisitionSystem = acquisitionSystem;
	}

	public AnatomicalRegion getAnatomicalRegion() {
		return this.anatomicalRegion;
	}

	public void setAnatomicalRegion(AnatomicalRegion anatomicalRegion) {
		this.anatomicalRegion = anatomicalRegion;
	}

	public Breed getBreed() {
		return this.breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

}