package com.REST_API.REST_API.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


@Entity(name = "PERSON")
@Inheritance(strategy=InheritanceType.JOINED)//TABLE_PER_CLASS)//.SINGLE_TABLE)
//@DiscriminatorColumn(name = "persontype", discriminatorType =DiscriminatorType.STRING, length = 10)
//@DiscriminatorValue(value="P")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String countryoforigin;
	public String dateofbirth;
	
	public Person() {
		 
	}
	
	public Person(Long id, String name, String countryoforigin, String dateofbirth) {
		super();
		this.id = id;
		this.name = name;
		this.countryoforigin = countryoforigin;
		this.dateofbirth = dateofbirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryoforigin() {
		return countryoforigin;
	}

	public void setCountryoforigin(String countryoforigin) {
		this.countryoforigin = countryoforigin;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}



	

}
