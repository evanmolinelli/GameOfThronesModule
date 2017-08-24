package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WEAPONS")
public class Weapons {

	@Id // this field is the primary key identifier
	@Column(name = "WEAPONS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weaponsSeq")
	@SequenceGenerator(name = "weaponsSeq", sequenceName = "WEAPONS_BEAN_SEQ")
	private int weaponId;
	@Column(name = "WEAPON_NAME")
	private String weaponName;
	@OneToOne
	@JoinColumn(name="WEAPON_ID", nullable=true)
	private Character character;

	public Weapons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weapons(int weaponId, String weaponName) {
		super();
		this.weaponId = weaponId;
		this.weaponName = weaponName;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	@Override
	public String toString() {
		return "Weapons [weaponId=" + weaponId + ", weaponName=" + weaponName + "]";
	}

}
