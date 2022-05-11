package com.abhijit.aibasedattendanceapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abhijit.aibasedattendanceapp.entity.User;
import com.abhijit.aibasedattendanceapp.service.LoginService;
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;


	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		User user = new User();
		ModelAndView mv = new ModelAndView("login", "user", user);
		return mv;
	}

	@RequestMapping("/userDashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("userdashboard");
	}

	@RequestMapping("/adminDashboard")
	public ModelAndView adminDashboard() {
		return new ModelAndView("admindashboard");
	}

}
