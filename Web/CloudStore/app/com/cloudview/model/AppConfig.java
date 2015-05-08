package com.cloudview.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_config database table.
 * 
 */
@Entity
@Table(name="app_config")
@NamedQuery(name="AppConfig.findAll", query="SELECT a FROM AppConfig a")
public class AppConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="s3_first_key")
	private String s3FirstKey;

	@Column(name="s3_second_key")
	private String s3SecondKey;

	public AppConfig() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getS3FirstKey() {
		return this.s3FirstKey;
	}

	public void setS3FirstKey(String s3FirstKey) {
		this.s3FirstKey = s3FirstKey;
	}

	public String getS3SecondKey() {
		return this.s3SecondKey;
	}

	public void setS3SecondKey(String s3SecondKey) {
		this.s3SecondKey = s3SecondKey;
	}

}