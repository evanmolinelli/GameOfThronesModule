package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Controller
public class HelloController {
	
	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getHomePageAfterLogin(HttpServletRequest request){
		String username = request.getParameter("username"); 
		String password = request.getParameter("pwd"); 
		
		System.out.println("request parameter" + username);
		System.out.println("request paramter" + password);
			
			User user = dao.getUsername(request.getParameter("username"));
			
			
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			
			if(BCrypt.checkpw(password, hashed)) {
				System.out.println(hashed);
				System.out.println(password);
				System.out.println("Passed");
				return "redirect:/pages/home.html";
			} else {
				System.out.println("Failed");
				return "redirect:/index.html";
			}
	}
}
