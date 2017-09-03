package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Controller
@SessionAttributes("username")
public class HelloController {

	@Autowired
	private UserDAO dao;

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String getHomePageAfterLogin(HttpServletRequest request) {
//		String username = request.getParameter("username");
//		String password = request.getParameter("pwd");
//
//		User user = dao.getUsername(request.getParameter("username"));
//
//		// System.out.println(user.getUsername());
//		// System.out.println(user.getPassword());
//
//		// System.out.println(user);
//
//		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//
//		if (BCrypt.checkpw(password, hashed)) {
//			request.getSession().setAttribute("user", user);
////			req.getRequestDispatcher("index.html").forward(req, resp);
//			System.out.println(hashed);
//			System.out.println(password);
//			System.out.println("Passed");
//			return "redirect:/pages/home.html";
////			return "redirect:/pages/home.html";
////			return "request.getRequestDispatcher(':/pages/home.html').forward(request, response)";
//		} else {
//			System.out.println("Failed");
//			return "redirect:/index.html";
//		}
//	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getHomePageAfterLogin(@RequestParam String username, @RequestParam String pwd, ModelMap model) {
		model.put("username", username);
		model.put("pwd", pwd);
		System.out.println(username); 
		System.out.println(pwd);
		
		User user = dao.getUsername(username); 
		
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

		if (BCrypt.checkpw(pwd, hashed)) {
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
