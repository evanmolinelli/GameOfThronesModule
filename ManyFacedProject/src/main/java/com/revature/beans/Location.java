package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LOCATIONS")
public class Location {

	@Id // this field is the primary key identifier
	@Column(name = "LOCATION_ID") // Using sql key words i.e ID
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="LOCATION_BEAN_SEQ")
	private int id;
	@Column(name = "LOCATION_NAME")
	private String name;
	@OneToMany(mappedBy = "location", fetch=FetchType.EAGER) // relationship owner
	private Set<House> house;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String name, HashSet<House> house) {
		super();
		this.name = name;
		this.house = house;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public Set<House> getHouse() {
		return house;
	}

	public void setHouse(HashSet<House> house) {
		this.house = house;
	}

}
