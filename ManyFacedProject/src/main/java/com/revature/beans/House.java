package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity // mapped to Hibernate
@Table(name = "HOUSE")
public class House {

	@Id // this field is the primary key identifier
	@Column(name = "HOUSE_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="HOUSE_BEAN_SEQ")
	private int houseId;
	
	@OneToMany(mappedBy="house")
	private Set<Character> character;
	@Column(name = "HOUSE_NAME")
	private String houseName;
	@Column(name = "HOUSE_SIGIL")
	private String houseSigil;
	@Column(name = "HOUSE_NUMBERS_MEMBERS")
	private int numberOfMembers;

	@ManyToOne 
	@JoinColumn(name="LOCATION_ID", nullable=false)
	private Location location;
	@OneToOne(mappedBy="house")
	private Sigil sigil; 
	@Column(name = "HOUSE_LORD")
	private String lordOfHouse; // king or queen of the house
	@ManyToOne 
	@JoinColumn(name="USER_ID", nullable = false)
	private User user; 
	

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(String houseName, String houseSigil, int numberOfMembers, 
			String lordOfHouse) {
		super();

		this.houseName = houseName;
		this.houseSigil = houseSigil;
		this.numberOfMembers = numberOfMembers;
		this.lordOfHouse = lordOfHouse;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
	
	public Set<Character> getCharacter() {
		return character;
	}

	public void setCharacter(Set<Character> character) {
		this.character = character;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseSigil() {
		return houseSigil;
	}

	public void setHouseSigil(String houseSigil) {
		this.houseSigil = houseSigil;
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
		return "House [houseId=" + houseId + ", character=" + character + ", houseName=" + houseName + ", houseSigil="
				+ houseSigil + ", numberOfMembers=" + numberOfMembers + ", location=" + location + ", sigil=" + sigil
				+ ", lordOfHouse=" + lordOfHouse + "]";
	}
	
	

}
