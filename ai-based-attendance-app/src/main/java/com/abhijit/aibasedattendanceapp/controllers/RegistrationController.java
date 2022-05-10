package com.abhijit.aibasedattendanceapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhijit.aibasedattendanceapp.entity.User;
import com.abhijit.aibasedattendanceapp.service.UserService;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/registration")
	public ModelAndView showRegistrationForm() {
		User user = new User();
		ModelAndView mv = new ModelAndView("registration", "user", user);
		return mv;
	}

	@PostMapping(value = "/registration")
	public ModelAndView registerUserAccount(@ModelAttribute("user") User user) {	
		ModelAndView mv = null;
		String message = "";
		message += userService.validateUserName(user.getUserName());
		message += userService.validatePassword(user.getPassword());
		if (message.equals("")) {
			userService.save(user);
			mv = new ModelAndView("registration", "user", user);
			mv.addObject("message", 
					"<div class=\"alert alert-success\">User Registration Successful</div>");

		} else {
			mv = new ModelAndView("registration", "user", user);
			mv.addObject("message", message);
			mv.addObject("message", 
					"<div class=\"alert alert-danger\">"+message+"</div>");
		}
		return mv;

	}




}
