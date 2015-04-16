package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the breed database table.
 * 
 */
@Entity
@Table(name="breed")
@NamedQuery(name="Breed.findAll", query="SELECT b FROM Breed b")
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="name_de", nullable=false, length=50)
	private String nameDe;

	@Column(name="name_en", nullable=false, length=50)
	private String nameEn;

	@Column(name="name_es", nullable=false, length=50)
	private String nameEs;

	@Column(name="name_fr", nullable=false, length=50)
	private String nameFr;

	@Column(name="name_zh", nullable=false, length=50)
	private String nameZh;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="breed")
	private List<Animal> animals;

	//bi-directional one-to-one association to BigBreed
	@OneToOne(mappedBy="breed")
	private BigBreed bigBreed;

	//bi-directional one-to-one association to CatBreed
	@OneToOne(mappedBy="breed")
	private CatBreed catBreed;

	//bi-directional many-to-one association to Constant
	@OneToMany(mappedBy="breed")
	private List<Constant> constants;

	//bi-directional one-to-one association to DogBreed
	@OneToOne(mappedBy="breed")
	private DogBreed dogBreed;

	//bi-directional one-to-one association to NacBreed
	@OneToOne(mappedBy="breed")
	private NacBreed nacBreed;

	public Breed() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameDe() {
		return this.nameDe;
	}

	public void setNameDe(String nameDe) {
		this.nameDe = nameDe;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameEs() {
		return this.nameEs;
	}

	public void setNameEs(String nameEs) {
		this.nameEs = nameEs;
	}

	public String getNameFr() {
		return this.nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setBreed(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setBreed(null);

		return animal;
	}

	public BigBreed getBigBreed() {
		return this.bigBreed;
	}

	public void setBigBreed(BigBreed bigBreed) {
		this.bigBreed = bigBreed;
	}

	public CatBreed getCatBreed() {
		return this.catBreed;
	}

	public void setCatBreed(CatBreed catBreed) {
		this.catBreed = catBreed;
	}

	public List<Constant> getConstants() {
		return this.constants;
	}

	public void setConstants(List<Constant> constants) {
		this.constants = constants;
	}

	public Constant addConstant(Constant constant) {
		getConstants().add(constant);
		constant.setBreed(this);

		return constant;
	}

	public Constant removeConstant(Constant constant) {
		getConstants().remove(constant);
		constant.setBreed(null);

		return constant;
	}

	public DogBreed getDogBreed() {
		return this.dogBreed;
	}

	public void setDogBreed(DogBreed dogBreed) {
		this.dogBreed = dogBreed;
	}

	public NacBreed getNacBreed() {
		return this.nacBreed;
	}

	public void setNacBreed(NacBreed nacBreed) {
		this.nacBreed = nacBreed;
	}

}