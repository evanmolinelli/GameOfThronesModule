package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Character;
import com.revature.beans.House;
import com.revature.beans.User;
import com.revature.data.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO dao;

	public void setDAO(UserDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@RequestBody User user) {
		dao.create(user);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody User user) {
		dao.update(user);
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody User user) {
		dao.delete(user);
	}

	@RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> findAll() {
		return dao.findAll();
	}// automagically converted object->JSON

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User findOne(@PathVariable(value = "id") Integer id) {
		return dao.findOne((int) id.intValue());
	}
}
