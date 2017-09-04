package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity // mapped to Hibernate
@Table(name = "HOUSE")
public class House {

	@Id // this field is the primary key identifier
	@Column(name = "HOUSE_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="HOUSE_BEAN_SEQ")
	private int houseId;
	
	@OneToMany(mappedBy="house", fetch=FetchType.EAGER)
	private Set<Character> character;
	@Column(name = "HOUSE_NAME")
	private String houseName;
	@Column(name = "HOUSE_NUMBERS_MEMBERS")
	private int numberOfMembers;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="LOCATION_ID", nullable=false)
	private Location location;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SIGIL_ID", nullable=false)
	private Sigil sigil; 
	@Column(name = "HOUSE_LORD")
	private String lordOfHouse; // king or queen of the house

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", nullable = false)
	private User user; 
	

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(String houseName, int numberOfMembers, 
			String lordOfHouse) {
		super();

		this.houseName = houseName;
		this.numberOfMembers = numberOfMembers;
		this.lordOfHouse = lordOfHouse;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

	public Sigil getSigil() {
		return sigil;
	}

	public void setSigil(Sigil sigil) {
		this.sigil = sigil;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}
	@JsonIgnore
	public Set<Character> getCharacter() {
		return character;
	}

	public void setCharacter(Set<Character> character) {
		this.character = character;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public String getLordOfHouse() {
		return lordOfHouse;
	}

	public void setLordOfHouse(String lordOfHouse) {
		this.lordOfHouse = lordOfHouse;
	}

	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", character=" + character + ", houseName=" + houseName + ", numberOfMembers=" + numberOfMembers + ", location=" + location + ", sigil=" + sigil
				+ ", lordOfHouse=" + lordOfHouse + "]";
	}
	
	

}
