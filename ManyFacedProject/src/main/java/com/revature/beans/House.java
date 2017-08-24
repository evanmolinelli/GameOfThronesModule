package com.revature.beans;

import javax.persistence.*;

@Entity // mapped to Hibernate
@Table(name = "HOUSE")
public class House {

	@Id // this field is the primary key identifier
	@Column(name = "HOUSE_ID") // Using sql key words i.e. ID
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int houseId;
	@Column(name = "HOUSE_NAME")
	private String houseName;
	@Column(name = "HOUSE_SIGIL")
	private String houseSigil;
	@Column(name = "HOUSE_NUMBERS_MEMBERS")
	private int numberOfMembers;
	@Column(name = "HOUSE_LOCATION")
	@ManyToOne // ? 
	private Location location;
	@OneToOne
	private Sigil sigil; 
	@Column(name = "HOUSE_LORD")
	private String lordOfHouse; // king or queen of the house
	

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(int houseId, String houseName, String houseSigil, int numberOfMembers, 
			String lordOfHouse) {
		super();
		this.houseId = houseId;
		this.houseName = houseName;
		this.houseSigil = houseSigil;
		this.numberOfMembers = numberOfMembers;
		this.lordOfHouse = lordOfHouse;
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

}
