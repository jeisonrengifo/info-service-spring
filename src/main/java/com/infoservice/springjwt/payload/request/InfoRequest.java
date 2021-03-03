package com.infoservice.springjwt.payload.request;

import com.infoservice.springjwt.models.User;

public class InfoRequest {
	
	private String description;
	
	private String info;
	
	private User user;
	
	private Long typeInfo;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getTypeInfo() {
		return typeInfo;
	}

	public void setTypeInfo(Long typeInfo) {
		this.typeInfo = typeInfo;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	

}
