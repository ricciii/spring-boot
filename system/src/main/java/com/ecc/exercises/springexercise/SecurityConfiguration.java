// package com.ecc.exercises.springexercise.system;

// // import com.ecc.exercises.springexercise.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.StandardPasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

// 	@Autowired
// 	private UserDetailsService userDetailsService;

// 	@Bean
// 	public PasswordEncoder encoder() {
// 		return new StandardPasswordEncoder("53cr3t");
// 	}

// 	@Override
// 	public void configure(AuthenticationManagerBuilder authentication) throws Exception {
// 		authentication.userDetailsService(userDetailsService).passwordEncoder(encoder());
// 	} 

// 	// @Override
// 	// protected void configure(HttpSecurity http) throws Exception {
// 	// 	http.authorizeRequests()
// 	// 	// .antMatchers("/design", "/orders")
// 	// 	.hasRole("ROLE_USER");
// 	// 	//.antMatchers(“/”, "/**").permitAll();
// 	// }
// }
