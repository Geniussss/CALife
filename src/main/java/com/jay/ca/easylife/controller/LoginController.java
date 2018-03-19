package com.jay.ca.easylife.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jay.ca.easylife.model.User;
import com.jay.ca.easylife.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService	userService;
	
	@RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
	public ModelAndView login() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login");
			return modelAndView;
	}
	
	@RequestMapping(value = "/registration",method = RequestMethod.GET)
	public ModelAndView registration() {
			ModelAndView modelAndView = new ModelAndView();
			User user = new User();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("registration");
			return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView creatNewUser(@Valid User user, BindingResult bindingResult) {
			ModelAndView modelAndView = new ModelAndView();
			User userExists = userService.findUserByEmail(user.getEmail());
			if (userExists != null) {
					bindingResult.rejectValue("email","error.user",
												"There is already a user registered with the email provided");
			}
			
			if (bindingResult.hasErrors()) {
				modelAndView.setViewName("registration");
			}
			else {
				userService.saveUser(user);
				modelAndView.addObject("successMessage", "User has been registered successful");
				modelAndView.addObject("user", new User());
				modelAndView.setViewName("registration");
			}
			return modelAndView;
			
	}
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
			ModelAndView modelAndView = new ModelAndView();
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    User user = userService.findUserByEmail(auth.getName());
		    modelAndView .addObject("userName", "Welcome"+user.getFirstname()+" "+user.getLastname()+"("+user.getEmail()+")");
		    modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		    modelAndView.setViewName("admin/home");
		    return modelAndView;
	}
	
}
