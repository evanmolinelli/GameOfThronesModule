package com.revature.controllers;

import java.util.List;
import java.util.Set;

import javax.naming.Context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.beans.Character;
import com.revature.beans.House;
import com.revature.beans.Location;
import com.revature.beans.Sigil;
import com.revature.data.HouseDAO;
import com.revature.data.LocationDAO;
import com.revature.data.SigilDAO;
import com.revature.data.UserDAO;

@Controller
// @RequestMapping(value="/house")
@SessionAttributes("username") //sessionAttribute carries the stored session
public class HouseController {

	@Autowired
	private HouseDAO dao;
	@Autowired
	private UserDAO userdao;
	@Autowired
	private LocationDAO locdao;
	@Autowired
	private SigilDAO sigildao;

	public void setDao(HouseDAO dao) {
		this.dao = dao;
	}

	public void setUserDAO(UserDAO userdao) {
		this.userdao = userdao;
	}

	public void setLocationDAO(LocationDAO locdao) {
		this.locdao = locdao;
	}
	
	public void setSigilDAO(SigilDAO sigildao) {
		this.sigildao = sigildao;
	}

	@RequestMapping(value = "/house/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // Accept=application/json
	@ResponseBody // do not redirect/forward.. rather write to response
	public void create(@RequestBody House house, @ModelAttribute("username") String username, ModelMap model) {
		// look in request body and find house
		System.out.println(username);
		//if the model contains the stored username create the house.
		if(model.containsAttribute("username")) {
			house.setUser(userdao.getUsername(username));
			System.out.println(username);
			dao.create(house);
		} else {
			System.out.println("uh ohhh");
		}
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
	public Set<House> findAll() {
		return dao.findAll();
	}// automagically converted object->JSON

	@RequestMapping(value = "/house/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House findOne(@PathVariable(value = "id") Integer id) {
		return dao.findOne((int) id.intValue());
	}

	@RequestMapping(value = "/location/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Set<Location> findAllLocations() {
//		for (Location l : locdao.findAll()){
//			System.out.println(l.getName());
//		}
		return locdao.findAll();
	}
	@RequestMapping(value = "/sigil/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Sigil> findAllSigils() {
		return sigildao.findAll();
	}
}

