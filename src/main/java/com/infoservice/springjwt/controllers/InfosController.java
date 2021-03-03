package com.infoservice.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoservice.springjwt.models.Info;
import com.infoservice.springjwt.models.User;
import com.infoservice.springjwt.payload.request.InfoRequest;
import com.infoservice.springjwt.payload.response.MessageResponse;
import com.infoservice.springjwt.security.services.InfoService;
import com.infoservice.springjwt.security.services.UserService;
import com.infoservice.springjwt.util.Util;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/info")
public class InfosController {
	
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveinfo")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?>registerInfo(@RequestBody List<InfoRequest> infoRequest){
		
		List<Info>infoList = new ArrayList<>();
		String userName = Util.getUserConected();
		User user = userService.findByUserName(userName);
		
		infoRequest.forEach(itemInfo->{
			Info info = new Info();
			info.setDescription(itemInfo.getDescription());
			info.setTypeInfo(itemInfo.getTypeInfo());
			info.setUser(user);
			info.setValue(itemInfo.getInfo());
			infoList.add(info);
		});
		
		infoService.saveAll(infoList);
		
		return ResponseEntity.ok(new MessageResponse("Info registered successfully!"));
		
	}
	
	
	
	
	

}
