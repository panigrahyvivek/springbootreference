package com.vivek.springbootreference.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
	
	@RequestMapping("currentcontext1")
	public Map<String, Object> getUserContext1(Authentication authentication) {
    	String currentPrincipalName = authentication.getName();
    	
    	Map<String, Object> userContext = new HashMap<String, Object>();
    	userContext.put("userprincipal", currentPrincipalName);
    	
    	return userContext;
	}
	
	@RequestMapping("currentcontext2")
	public Map<String, Object> getUserContext2(Principal principal) {
    	String currentPrincipalName = principal.getName();
    	Map<String, Object> userContext = new HashMap<String, Object>();
    	userContext.put("userprincipal", currentPrincipalName);
    	return userContext;
	}
	
	@RequestMapping("currentcontext3")
	public Map<String, Object> getUserContext3(HttpServletRequest request) {
    	String currentPrincipalName = request.getUserPrincipal().getName();
    	
    	Map<String, Object> userContext = new HashMap<String, Object>();
    	userContext.put("userprincipal", currentPrincipalName);
    	
    	return userContext;
	}
	
	@RequestMapping("currentcontext4")
	public Map<String, Object> getUserContext() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	
    	Map<String, Object> userContext = new HashMap<String, Object>();
    	userContext.put("userprincipal", currentPrincipalName);
    	
    	return userContext;
	}
	
	
	
}