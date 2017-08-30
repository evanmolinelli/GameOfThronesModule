package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Character;
import com.revature.beans.House;
import com.revature.data.HouseDAO;

@Controller
public class HouseController {

	@Autowired
	private HouseDAO dao;

	public void setDao(HouseDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/house/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // Accept=application/json
	@ResponseBody // do not redirect/forward.. rather write to response
	public void create(@RequestBody House house) {
		// look in request body and find Game
		dao.create(house);
	}// automagically converted JSON->object

	@RequestMapping(value = "/house/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody House house) {
		dao.update(house);
	}

	@RequestMapping(value = "/house/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody House house) {
		dao.delete(house);
	}

	@RequestMapping(value = "/house/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<House> findAll() {
		return dao.findAll();
	}// automagically converted object->JSON

	@RequestMapping(value="/house/{id}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House findOne(int id) {
		return dao.findOne(id);
	}
}
