package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		     .authorizeRequests()
		     .antMatchers("/home").permitAll()
		     .anyRequest()
		     .authenticated()
		     .and()
		     .httpBasic();
		
		     
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("gorv").password(this.passwordEncoder().encode("user")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("abc").password(this.passwordEncoder().encode("abc")).roles("ADMIN");
	}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder(10);
}
	}

	
	

		
		
		
	



