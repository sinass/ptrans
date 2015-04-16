package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@Table(name="animal")
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="animal_id", nullable=false, length=45)
	private String animalId;

	@Column(nullable=false, length=45)
	private String birthday;

	@Column(nullable=false, length=45)
	private String lof;

	@Column(nullable=false, length=45)
	private String name;

	@Column(name="num_file", length=45)
	private String numFile;

	@Column(nullable=false)
	private Integer sex;

	@Column(length=2147483647)
	private String signes;

	@Column(nullable=false, length=45)
	private String tatouage;

	@Column(nullable=false)
	private Integer used;

	//bi-directional many-to-one association to Breed
	@ManyToOne
	@JoinColumn(name="breed_id", nullable=false)
	private Breed breed;

	//bi-directional many-to-one association to AnimalFile
	@OneToMany(mappedBy="animal")
	private List<AnimalFile> animalFiles;

	//bi-directional many-to-one association to OwnerHasAnimal
	@OneToMany(mappedBy="animal")
	private List<OwnerHasAnimal> ownerHasAnimals;

	public Animal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnimalId() {
		return this.animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLof() {
		return this.lof;
	}

	public void setLof(String lof) {
		this.lof = lof;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumFile() {
		return this.numFile;
	}

	public void setNumFile(String numFile) {
		this.numFile = numFile;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSignes() {
		return this.signes;
	}

	public void setSignes(String signes) {
		this.signes = signes;
	}

	public String getTatouage() {
		return this.tatouage;
	}

	public void setTatouage(String tatouage) {
		this.tatouage = tatouage;
	}

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Breed getBreed() {
		return this.breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public List<AnimalFile> getAnimalFiles() {
		return this.animalFiles;
	}

	public void setAnimalFiles(List<AnimalFile> animalFiles) {
		this.animalFiles = animalFiles;
	}

	public AnimalFile addAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().add(animalFile);
		animalFile.setAnimal(this);

		return animalFile;
	}

	public AnimalFile removeAnimalFile(AnimalFile animalFile) {
		getAnimalFiles().remove(animalFile);
		animalFile.setAnimal(null);

		return animalFile;
	}

	public List<OwnerHasAnimal> getOwnerHasAnimals() {
		return this.ownerHasAnimals;
	}

	public void setOwnerHasAnimals(List<OwnerHasAnimal> ownerHasAnimals) {
		this.ownerHasAnimals = ownerHasAnimals;
	}

	public OwnerHasAnimal addOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().add(ownerHasAnimal);
		ownerHasAnimal.setAnimal(this);

		return ownerHasAnimal;
	}

	public OwnerHasAnimal removeOwnerHasAnimal(OwnerHasAnimal ownerHasAnimal) {
		getOwnerHasAnimals().remove(ownerHasAnimal);
		ownerHasAnimal.setAnimal(null);

		return ownerHasAnimal;
	}

}