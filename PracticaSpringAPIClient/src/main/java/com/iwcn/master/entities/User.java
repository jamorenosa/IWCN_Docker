package com.iwcn.master.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String user;
	String password;
	
	@ElementCollection(fetch=FetchType.EAGER)
	List<GrantedAuthority> roles;
	
	public User() {}
	
	public String getPasswordHash() {
		return this.password;
	}
	
	public List<GrantedAuthority> getRoles() {
		return this.roles;
	}
	
	public User(String user, String password, List<GrantedAuthority> roles) {
		this.user = user;
		this.password =  new BCryptPasswordEncoder().encode(password);
		this.roles = roles;
	}
}
