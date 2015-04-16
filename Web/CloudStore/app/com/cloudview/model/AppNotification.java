package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;


/**
 * The persistent class for the app_notification database table.
 * 
 */
@Entity
@Table(name="app_notification")
@NamedQuery(name="AppNotification.findAll", query="SELECT a FROM AppNotification a")
public class AppNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	private Integer status;

	@Column(length=255)
	private Array text;

	public AppNotification() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Array getText() {
		return this.text;
	}

	public void setText(Array text) {
		this.text = text;
	}

}