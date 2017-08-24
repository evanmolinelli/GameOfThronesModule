package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHARACTERS")
public class Character {

	@Id // this field is the primary key identifier
	@Column(name = "CHAR_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "CHARACTER_FIRSTNAME")
	private String firstName;
	@Column(name = "CHARACTER_LASTNAME")
	private String lastName;
	@Column(name = "CHARACTER_GENDER")
	private String gender;
	@Column(name = "CHARACTER_HEIGHT")
	private int height; // in centimeters??
	@Column(name = "CHARACTER_STATUS")
	@ManyToOne //? 
	private Status status; // High-born, flea-bottom/peasant, pirate, smuggler
	@Column (name="CHARACTER_WEAPONS")
	@OneToOne //? 
	private Weapons weapons; //Swords, axes, daggers, direwolf
	@Column(name = "CHARACTER_ALIAS")
	private String alias;

	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Character(int id, String firstName, String lastName, String gender, int height, String alias) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.alias = alias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}
	
	

	