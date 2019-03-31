package com.examples.spring.web.mvc;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.model.User;
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {

private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegisterForm() {
		ModelAndView modelView = new ModelAndView("login","command",new User());
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request,HttpSession session) {
	   
		User user=(User) session.getAttribute("user");
		logger.info("Register username: {}",user.getUsername());
		logger.info(" country: {}",user.getCountry());
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			ModelAndView mav=new ModelAndView();
			return mav;
		}
		else {
			return new ModelAndView("redirect:login");
		}
	
		//ModelAndView modelView = new ModelAndView("success");
		
		
		//return modelView;
	}
}
