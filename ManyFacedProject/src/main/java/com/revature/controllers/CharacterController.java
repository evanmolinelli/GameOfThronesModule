package com.revature.controllers;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.data.CharacterDAO;
import com.revature.data.SigilDAO;
import com.revature.data.StatusDAO;
import com.revature.data.WeaponDAO;
import com.revature.beans.Character;
import com.revature.beans.Sigil;
import com.revature.beans.Status;
import com.revature.beans.Weapons;

@Controller
public class CharacterController {

	@Autowired
	private CharacterDAO dao;
	@Autowired
	private StatusDAO sdao;
	@Autowired
	private WeaponDAO wdao;
	@Autowired
	private SigilDAO sigdao;

	public void setDAO(CharacterDAO dao) {
		this.dao = dao;
	}

	public void setSdao(StatusDAO sdao) {
		this.sdao = sdao;
	}

	public void setWdao(WeaponDAO wdao) {
		this.wdao = wdao;
	}

	public void setSigdao(SigilDAO sigdao) {
		this.sigdao = sigdao;
	}

	@RequestMapping(value = "/character/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // consumes
																															// accepts
																															// application
																															// in
																															// JSON
	@ResponseBody // do not redirect/forward.. instead write to response
	public void create(@RequestBody Character character) {
		System.out.println("character = " + character.toString());
		dao.create(character);
		// black magic to convert JSON -> object
	}

	@RequestMapping(value = "/character/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // do not redirect/forward.. instead write to response
	public void update(@RequestBody Character character) {
		dao.update(character);
	}

	@RequestMapping(value = "/character/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody Character character) {
		dao.delete(character);
	}

	@RequestMapping(value = "/character/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Character> findAll() {
		return dao.findAll();
	}

	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Character findOne(@PathVariable(value = "id") Integer id) {
		return dao.findOne((int) id.intValue());
	}

	@RequestMapping(value = "/status/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Status> findAllStatus() {
		return sdao.findAll();
	}

	@RequestMapping(value = "/weapons/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Weapons> findAllWeapons() {
		return wdao.findAll();
	}


	@RequestMapping(value = "/charactersInHouse/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Character> findCharactersInHouse(@PathVariable(value = "id") Integer id) {
		return dao.findAllCharactersInHouse((int) id.intValue());
	}



	@RequestMapping(value = "/sigil/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // do not redirect/forward.. instead write to response
	public void create(@RequestBody Sigil sigil) {
		sigdao.create(sigil);
		// black magic to convert JSON -> object
	}

}
