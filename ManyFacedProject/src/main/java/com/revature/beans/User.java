package com.revature.beans;

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
@Table(name="GOT_USERS")
public class User {
	@Id // this field is the primary key identifier
	@Column(name = "USER_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="USER_BEAN_SEQ")
	private int id;
	@Column(name= "USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<House> house;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public Set<House> getHouse() {
		return house;
	}
	public void setHouse(Set<House> house) {
		this.house = house;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	} 
	
	
	
	

}
