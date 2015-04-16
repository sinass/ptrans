package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the anatomical_region database table.
 * 
 */
@Entity
@Table(name="anatomical_region")
@NamedQuery(name="AnatomicalRegion.findAll", query="SELECT a FROM AnatomicalRegion a")
public class AnatomicalRegion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="bone_length")
	private float boneLength;

	@Column(nullable=false)
	private float depth;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Constant
	@OneToMany(mappedBy="anatomicalRegion")
	private List<Constant> constants;

	//bi-directional many-to-one association to Description
	@OneToMany(mappedBy="anatomicalRegion")
	private List<Description> descriptions;

	//bi-directional many-to-one association to Pathology
	@OneToMany(mappedBy="anatomicalRegion")
	private List<Pathology> pathologies;

	public AnatomicalRegion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getBoneLength() {
		return this.boneLength;
	}

	public void setBoneLength(float boneLength) {
		this.boneLength = boneLength;
	}

	public float getDepth() {
		return this.depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Constant> getConstants() {
		return this.constants;
	}

	public void setConstants(List<Constant> constants) {
		this.constants = constants;
	}

	public Constant addConstant(Constant constant) {
		getConstants().add(constant);
		constant.setAnatomicalRegion(this);

		return constant;
	}

	public Constant removeConstant(Constant constant) {
		getConstants().remove(constant);
		constant.setAnatomicalRegion(null);

		return constant;
	}

	public List<Description> getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public Description addDescription(Description description) {
		getDescriptions().add(description);
		description.setAnatomicalRegion(this);

		return description;
	}

	public Description removeDescription(Description description) {
		getDescriptions().remove(description);
		description.setAnatomicalRegion(null);

		return description;
	}

	public List<Pathology> getPathologies() {
		return this.pathologies;
	}

	public void setPathologies(List<Pathology> pathologies) {
		this.pathologies = pathologies;
	}

	public Pathology addPathology(Pathology pathology) {
		getPathologies().add(pathology);
		pathology.setAnatomicalRegion(this);

		return pathology;
	}

	public Pathology removePathology(Pathology pathology) {
		getPathologies().remove(pathology);
		pathology.setAnatomicalRegion(null);

		return pathology;
	}

}