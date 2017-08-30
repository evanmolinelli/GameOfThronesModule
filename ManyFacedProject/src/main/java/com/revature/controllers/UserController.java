package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Controller
public class UserController {
	
	private UserDAO dao;
	
	public void setDAO(UserDAO dao) {
		this.dao = dao; 
	}
	@RequestMapping(value="/create", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@RequestBody User user) {
		dao.create(user);
	}

}
