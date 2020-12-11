package com.REST_API.REST_API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@PrimaryKeyJoinColumn(name = "USERID")
public class User extends Person{
	 
	public boolean isuniversitystudent; 
	public String eduinstitution;
	public String username;
	public String password;
	
	public User(Long id, String name, String countryoforigin, String dateofbirth, boolean isuniversitystudent, 
			String eduinstitution, String username, String password) {
			super(id, name, countryoforigin, dateofbirth);
//			this.studentid = studentid;
			this.isuniversitystudent = isuniversitystudent;
			this.eduinstitution = eduinstitution;
//			this.lends = lends;
			this.username=username;
			this.password=password;
		}

	public User() {
		
	}

	public boolean isIsuniversitystudent() {
		return isuniversitystudent;
	}

	public void setIsuniversitystudent(boolean isuniversitystudent) {
		this.isuniversitystudent = isuniversitystudent;
	}

	public String getEduinstitution() {
		return eduinstitution;
	}

	public void setEduinstitution(String eduinstitution) {
		this.eduinstitution = eduinstitution;
	}




}