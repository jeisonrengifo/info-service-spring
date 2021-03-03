package com.infoservice.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idinfo")
	private Long id;
	
	private String description;
	
	private String value;
	
	@Column(name = "typeinfo")
	private Long typeInfo;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;	

	public Info() {
		
	}
	
	public Info(String description, String value) {
		this.description = description;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Long getTypeInfo() {
		return typeInfo;
	}

	public void setTypeInfo(Long typeInfo) {
		this.typeInfo = typeInfo;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
