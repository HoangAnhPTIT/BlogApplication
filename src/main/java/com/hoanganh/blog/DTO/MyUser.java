package com.hoanganh.blog.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6175219762207466374L;
	
	private Long id;
	
	public MyUser(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
