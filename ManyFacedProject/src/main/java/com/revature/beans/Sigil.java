package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity // mapped to Hibernate
@Table(name = "SIGIL")
public class Sigil {

	@Id // this field is the primary key identifier
	@Column(name = "SIGIL_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName="SIGIL_BEAN_SEQ")
	private int sigilId;
	@Column(name = "SIGIL_NAME")
	private String sigilName;
	@OneToMany(mappedBy="sigil")
	private Set<House> house;

	public Sigil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sigil(String sigilName) {
		super();
		this.sigilName = sigilName;
	}

	public int getSigilId() {
		return sigilId;
	}

	public void setSigilId(int sigilId) {
		this.sigilId = sigilId;
	}

	public String getSigilName() {
		return sigilName;
	}

	public void setSigilName(String sigilName) {
		this.sigilName = sigilName;
	}

	@Override
	public String toString() {
		return "Sigil [sigilId=" + sigilId + ", sigilName=" + sigilName + "]";
	}

}
