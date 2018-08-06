package com.vivek.springbootreference.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.headers().frameOptions().sameOrigin();

		http.csrf().disable().authorizeRequests().anyRequest().
		authenticated().and().formLogin().loginPage("/login").
		permitAll().and().logout().deleteCookies("rememberme").
		permitAll().and().rememberMe().tokenValiditySeconds(60);
		
		
        
    }
}