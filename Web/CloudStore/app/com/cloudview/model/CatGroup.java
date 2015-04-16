package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_group database table.
 * 
 */
@Entity
@Table(name="cat_group")
@NamedQuery(name="CatGroup.findAll", query="SELECT c FROM CatGroup c")
public class CatGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;

	//bi-directional many-to-one association to CatMorpho
	@OneToMany(mappedBy="catGroup")
	private List<CatMorpho> catMorphos;

	public CatGroup() {
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<CatMorpho> getCatMorphos() {
		return this.catMorphos;
	}

	public void setCatMorphos(List<CatMorpho> catMorphos) {
		this.catMorphos = catMorphos;
	}

	public CatMorpho addCatMorpho(CatMorpho catMorpho) {
		getCatMorphos().add(catMorpho);
		catMorpho.setCatGroup(this);

		return catMorpho;
	}

	public CatMorpho removeCatMorpho(CatMorpho catMorpho) {
		getCatMorphos().remove(catMorpho);
		catMorpho.setCatGroup(null);

		return catMorpho;
	}

}