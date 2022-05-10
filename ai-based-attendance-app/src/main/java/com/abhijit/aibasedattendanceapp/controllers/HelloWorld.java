package com.abhijit.aibasedattendanceapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

	@RequestMapping(value="/hello-world", method=RequestMethod.GET, produces="application/json")
	@ResponseBody	
	public String helloWorld() {
		return "Hello-world";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", "Abhijit");
		return "welcome";
	}


}
