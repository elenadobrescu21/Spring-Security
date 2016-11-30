package com.elena.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@PropertySource("application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Value("${security.admin.user}")
	 private String adminUsername;
	 
	 @Value("${security.admin.password}")
	 private String adminPassword;
	 
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("USER", "ADMIN");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()                                                                
				.antMatchers("/home").permitAll()                  
				.antMatchers("/admin").hasRole("ADMIN")                                      
				.antMatchers("/user").hasRole("USER")           
				.anyRequest().authenticated().and()
				.formLogin();
		
		

				
	}
	
	

}
