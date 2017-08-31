package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(HttpServletRequest request){
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		return "redirect:*/pages/home.html";
	}
	
}
