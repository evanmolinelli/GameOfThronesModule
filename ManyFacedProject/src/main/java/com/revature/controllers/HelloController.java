package com.revature.controllers;

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

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getHomePageAfterLogin(@RequestParam String username, @RequestParam String pwd, ModelMap model) {
		model.put("username", username);
		model.put("pwd", pwd);

		User user = dao.getUsername(username);

		if (user != null) {

			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

			if (BCrypt.checkpw(pwd, hashed)) {
				return "redirect:/pages/home.html";
			} else {
				return "redirect:/index.html";
			}
		} else {
			return "redirect:/index.html";
		}
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String getCreateUser(@RequestParam String createUser, @RequestParam String createPassword, ModelMap model) {
		model.put("username", createUser);
		model.put("pwd", createPassword);

		User user = new User(createUser, createPassword);
		dao.create(user);

		return "redirect:/pages/home.html";

	}
}
