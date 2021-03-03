package com.infoservice.springjwt.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.infoservice.springjwt.models.TypeInfo;

public class Util {
	
	public static String getUserConected() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		String userName = "";
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		  userName =userDetails.getUsername();
		}
		return userName;
		
	}
	
	public static TypeInfo getTypeInfo(String nameInfo) {
		
		TypeInfo typeInfo = new TypeInfo();
		
		if(nameInfo.contains("phone")) {
			typeInfo.setId(1l);
			typeInfo.setName("phone-number");
		}else if(nameInfo.contains("mail")) {
			typeInfo.setId(2l);
			typeInfo.setName("e-mail");
		}
		
		return typeInfo;
		
	}
	
	

}
