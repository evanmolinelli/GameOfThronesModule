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

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getHomePageAfterLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		User user = dao.getUsername(request.getParameter("username"));

		// System.out.println(user.getUsername());
		// System.out.println(user.getPassword());

		// System.out.println(user);

		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

		if (BCrypt.checkpw(password, hashed)) {
			System.out.println(hashed);
			System.out.println(password);
			System.out.println("Passed");
			
			
			return "redirect:/pages/home.html";
		} else {
			System.out.println("Failed");
			return "redirect:/index.html";
		}
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String getCreateUser(HttpServletRequest request) {
		String username = request.getParameter("createUser");
		String pwd = request.getParameter("createPassword");
		
		User user = new User(username,pwd);
		System.out.println("created"); 
		dao.create(user);

		return "redirect:/pages/home.html";
	}

}
