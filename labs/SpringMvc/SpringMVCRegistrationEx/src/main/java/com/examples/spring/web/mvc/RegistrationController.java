package com.examples.spring.web.mvc;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = {"/register"})
@SessionAttributes({"user"})
public class RegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegisterForm() {
		ModelAndView modelView = new ModelAndView("register","user",new User());
		
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user,@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request,HttpSession session) {
		//Enumeration<String> headerNames=request.getHeaderNames();
		
	
		//User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		
		ModelAndView modelView = new ModelAndView("success");
		modelView.addObject("");
		//HttpSession session = request.getSession();
		System.out.println(session.getId());
		modelView.addObject("username",username);
		return modelView;
	}	
	
	@ModelAttribute("countries")
	public List<String> listCountries(){
		return Arrays.asList("India","Usa","Denmark","Russia");
	}
}
