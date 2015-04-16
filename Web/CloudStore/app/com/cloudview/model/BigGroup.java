package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the big_group database table.
 * 
 */
@Entity
@Table(name="big_group")
@NamedQuery(name="BigGroup.findAll", query="SELECT b FROM BigGroup b")
public class BigGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="name_de", nullable=false, length=45)
	private String nameDe;

	@Column(name="name_en", nullable=false, length=45)
	private String nameEn;

	@Column(name="name_es", nullable=false, length=45)
	private String nameEs;

	@Column(name="name_fr", nullable=false, length=45)
	private String nameFr;

	@Column(name="name_zh", nullable=false, length=45)
	private String nameZh;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to BigMorpho
	@OneToMany(mappedBy="bigGroup")
	private List<BigMorpho> bigMorphos;

	public BigGroup() {
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<BigMorpho> getBigMorphos() {
		return this.bigMorphos;
	}

	public void setBigMorphos(List<BigMorpho> bigMorphos) {
		this.bigMorphos = bigMorphos;
	}

	public BigMorpho addBigMorpho(BigMorpho bigMorpho) {
		getBigMorphos().add(bigMorpho);
		bigMorpho.setBigGroup(this);

		return bigMorpho;
	}

	public BigMorpho removeBigMorpho(BigMorpho bigMorpho) {
		getBigMorphos().remove(bigMorpho);
		bigMorpho.setBigGroup(null);

		return bigMorpho;
	}

}