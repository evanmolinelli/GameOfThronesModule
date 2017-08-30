package com.revature.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.data.CharacterDAO;
import com.revature.beans.Character;

@Controller
public class CharacterController {
	
	private CharacterDAO dao; 
	
	public void setDAO(CharacterDAO dao) {
		this.dao=dao;
	}
	
	@RequestMapping(value="/character/create", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE) //consumes accepts application in JSON
	@ResponseBody //do not redirect/forward.. instead write to response
	public void create(@RequestBody Character character) {
		dao.create(character);
		//black magic to convert JSON -> object
	}
	
	@RequestMapping(value="/character/update", method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody //do not redirect/forward.. instead write to response
	public void update(@RequestBody Character character) {
		dao.update(character);
	}
	
	@RequestMapping(value="/character/delete", method=RequestMethod.DELETE, 
	consumes=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public void delete(@RequestBody Character character) {
		dao.delete(character);
	}
	
	@RequestMapping(value="/character/all", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Character> findAll(){
		System.out.println("Connected?");
		return dao.findAll();
	}
	
//	@RequestMapping(value="/character/{id}", method=RequestMethod.GET,
//			produces=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List <Character> findOne() {
//		return dao.findOne();
//	}
	

}
