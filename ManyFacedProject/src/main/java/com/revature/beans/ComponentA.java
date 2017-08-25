package com.revature.beans;

import com.revature.data.HouseDAO;

public class ComponentA {

	private HouseDAO houseDAO;

	public void setHouseDAO(HouseDAO houseDAO) {
		this.houseDAO = houseDAO;
	}
	
	public void create(House house){
		houseDAO.create(house);
		System.out.println("Created a house guy.");
	}
}
