package com.besuh.Crud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Language {
	@Id
	@GeneratedValue
	private Integer ID;
	@Column
	@Size(min=2, max=20)
	private String name;
	@Column
	@Size(min=2,max=20)
	private String creator;
	@Column
	@NotNull
	private double version;
		
	public Language(String name, String creator, double version) {
		this.setName(name);
		this.setCreator(creator);
		this.setVersion(version);
	}
	
	public Language() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
}
