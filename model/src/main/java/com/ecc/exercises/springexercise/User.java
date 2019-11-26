// package com.ecc.exercises.springexercise.model;

// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Pattern;

// import java.util.Arrays;
// import java.util.Collection;

// import javax.persistence.Entity;
// import javax.persistence.Table;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;


// @Entity
// @Table(name="account")
// public class User extends BaseEntity implements UserDetails {
	
// 	private String username;
// 	private String password;

// 	public User() {}

// 	public User(String username, String password) {
// 		this.username = username;
// 		this.password = password;
// 	}

// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
// 	}

// 	public String getUsername() {
// 		return this.username;
// 	}

// 	public String getPassword() {
// 		return this.password;
// 	}

// 	// public void setUsername(String username) {
// 	// 	this.username = username;
// 	// }

// 	// public void setPassword(String password) {
// 	// 	this.password = password;
// 	// }

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return true;
// 	}
	
// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return true;
// 	}
	
// 	@Override
// 	public boolean isEnabled() {
// 		return true;
// 	}
// }
