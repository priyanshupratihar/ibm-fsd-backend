package com.examples.spring.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.model.Login;
import com.examples.spring.web.mvc.model.Registration;


@Controller
//@RequestMapping(value = {"/register"})
public class RegistrationController {
	
	//private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView showRegisterForm() {
//		ModelAndView modelView = new ModelAndView("registration");
//		return modelView;
//	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)	
	public ModelAndView Registration(Model model) {

		return new ModelAndView("registration", "command", new Registration());
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Registration registration,@RequestParam("userName") String username, @RequestParam("password") String password, HttpRequest request,HttpSession session) {
		ModelAndView modelView = new ModelAndView("registration");
		System.out.println(session.getId());
		session.setAttribute("userName", registration.getUserName());
		session.setAttribute("password",registration.getPassword());
		modelView.addObject("userName",username);
		modelView.addObject("password",password);
//		
		//return modelView;
		return new ModelAndView("redirect:/employee/list");
	}	
}
