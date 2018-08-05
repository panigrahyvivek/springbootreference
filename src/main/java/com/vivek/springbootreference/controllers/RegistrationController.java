package com.vivek.springbootreference.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.vivek.springbootreference.models.User;
import com.vivek.springbootreference.models.UserDto;
import com.vivek.springbootreference.services.UserService;


@Controller
public class RegistrationController{
	
	@Autowired
	UserService service;
		
	
	@RequestMapping(value="/user/registration", method=RequestMethod.GET)
	public String showRegistrationForm(WebRequest req, Model model) {
		
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";

	}
	
	@RequestMapping(value="/user/registration", method=RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("user") @Valid UserDto userDto, 
			BindingResult result, WebRequest req, Errors errors) {
		User registered = new User();
		if(!result.hasErrors()) {
			registered = createUserAccount(userDto, result);
		}
		
		if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", userDto);
	    } 
	    else {
	        return new ModelAndView("successRegister", "user", userDto);
	    }

	}
	
	private User createUserAccount(UserDto userDto, BindingResult result) {
	    User registered = null;
	    try {
	        registered = service.registerNewUserAccount(userDto);
	    } catch (Exception e) {
	        return null;
	    }
	    return registered;
	}
	
}