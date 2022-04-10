package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	//for in-memory users and roles
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//adding users as in memory authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser(users.username("sufyan").password("Sufyan@123").roles("EMPLOYEE"))
//		.withUser(users.username("abc").password("Sufyan@123").roles("EMPLOYEE", "MANAGER"))
//		.withUser(users.username("susan").password("Sufyan@123").roles("EMPLOYEE", "ADMIN"));
//	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().
//		and().
//		formLogin().loginPage("/customLoginForm").loginProcessingUrl("/processForm").permitAll()
//		.and()
//		.logout().logoutSuccessUrl("/customLoginForm").permitAll();
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/customLoginForm").loginProcessingUrl("/processForm").permitAll()
		.and()
		.logout().logoutSuccessUrl("/customLoginForm").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	

}
