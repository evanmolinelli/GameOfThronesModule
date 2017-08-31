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
@Table(name ="STATUS")
public class Status {
	
	@Id //this field is the primary key identifier
	@Column(name="STATUS_ID") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="STATUS_BEAN_SEQ")
	private int id; 
	@Column(name="STATUS_NAME")
	private String status; 
	@OneToMany(mappedBy="status")
	private Set<Character> character;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JsonIgnore
	public Set<Character> getCharacters() {
		return character;
	}
	
	public void setHouse(HashSet<Character> character) {
		this.character = character; 
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
	
}
	