package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHARACTERS")
public class Character {

	@Id // this field is the primary key identifier
	@Column(name = "CHAR_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="CHARACTER_BEAN_SEQ")
	private int id;
	@Column(name = "CHARACTER_FIRSTNAME")
	private String firstName;
	@Column(name = "CHARACTER_LASTNAME")
	private String lastName;
	@Column(name = "CHARACTER_GENDER")
	private String gender;
	@Column(name = "CHARACTER_HEIGHT")
	private int height; // in centimeters??
	
	@ManyToOne 
	@JoinColumn(name="HOUSE_ID", nullable=false)
	private House house;
	
	@ManyToOne 
	@JoinColumn(name="STATUS_ID", nullable=false)
	private Status status; // High-born, flea-bottom/peasant, pirate, smuggler

	@OneToOne(mappedBy="character") //? 
	private Weapons weapons; //Swords, axes, daggers, direwolf
	@Column(name = "CHARACTER_ALIAS")
	private String alias;

	public Character() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Character(String firstName, String lastName, String gender, int height, String alias) {
		super();
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
	
	

	