package com.iwcn.master.services;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.iwcn.master.entities.User;
import com.iwcn.master.repositories.UserRepository;

@Component
public class UserDataBase {

	@Autowired
	UserRepository userRepository;
	
//	@PostConstruct
//	void initDataBase() {
//		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
//		userRepository.save(new User("user", "user", Arrays.asList(userRoles)));
//		
//		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority("ROLE_USER"),
//				new SimpleGrantedAuthority("ROLE_ADMIN")};
//		userRepository.save(new User("admin", "admin", Arrays.asList(adminRoles)));
//	}
}
