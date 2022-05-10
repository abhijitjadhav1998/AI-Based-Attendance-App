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

	@RequestMapping(value = "processLogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("employee") User user, HttpServletRequest request) {
		ModelAndView mv = null;

		boolean status = loginService.validateLogin(user);
		if (status) {
			mv = new ModelAndView("dashboard", "user", user);
			mv.addObject("userName", user.getUserName());
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUserName());
		} else {
			String message = "";
			mv = new ModelAndView("error", "user", user);

			if(user.getUserName() == "" ) {
				message += "User Name is Mandatory ||||";
			}
			if(user.getPassword() == "") {
				message += "  Password is Mandatory ||||";
			}
			if(loginService.getUserByUsername(user.getUserName())) {
				message += "   There is No such user in the system ||||";
			}
			message += "  Invalid UserName or Password";
			mv.addObject("message", message);
		}
		return mv;
	}
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public ModelAndView showDashboard(HttpServletRequest request,HttpServletResponse response) {
		HttpSession sess = request.getSession(false);
		String username = null;
		try {
			 username = (String) sess.getAttribute("username");
			System.out.println(username);
			if(username.equals(null)) {
				return new ModelAndView("redirect:/Login");
			}
		}catch (Exception e) {
			return new ModelAndView("redirect:/Login");
		}
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("userName", username);
		return mv;
	}

}
