package com.infoservice.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoservice.springjwt.models.User;
import com.infoservice.springjwt.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User findByUserName(String userName) {
		
		if(userName==null) {
			throw (new RuntimeException("Can not save Info, Info is empty."));
		}
		User user = userRepository.findByUsername(userName);
		return user;
		
	}
}
