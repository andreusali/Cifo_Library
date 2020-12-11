package com.REST_API.REST_API.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LEND")
public class Lend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	@ManyToOne//(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public User user;
//
//	@ManyToOne//(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
//	@JoinColumn(name = "STUDENT_ID")
//	public Student student;
//	
//	@ManyToOne
//	@JoinColumn(name = "GENERICMEMBER_ID")
//	public Genericmember genericmember;
	
//	@ManyToOne//, cascade=CascadeType.MERGE)//, fetch = FetchType.EAGER)
//	@JsonIgnore	
//	@JoinColumn(name = "LENDBOOK")
//	public Lendbook lendbook;
	
	@OneToMany(mappedBy="lend")//(cascade=CascadeType.ALL)//, fetch = FetchType.EAGER)//, orphanRemoval = true)
//	@JoinColumn(name = "LEND_ID")
//	@JsonIgnore
	public List<Lendbook> lendbooks = new ArrayList<Lendbook>();
		
//	@ManyToMany(mappedBy = "bookid", cascade = CascadeType.ALL)
//	@ManyToMany(mappedBy = "", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "lendid", cascade = CascadeType.ALL)
//	List<Book> books = new ArrayList<Book>();
	
//	@OneToMany(mappedBy = "lendid", cascade = CascadeType.ALL)
//	List<LendBook> lendbooks = new ArrayList<LendBook>();


//	
//	@ManyToOne
//	@JoinColumn
//	public Pensioner pensioner;
	
//	@OneToMany(mappedBy = "lend", cascade = CascadeType.ALL)
//	List<Cd> cds = new ArrayList<Cd>();
//	
//	@OneToMany(mappedBy = "lend", cascade = CascadeType.ALL)
//	List<Newspaper> newspapers = new ArrayList<Newspaper>();
	
//	@OneToMany(mappedBy = "lend", cascade = CascadeType.ALL)
//	List<Magazine> magazines = new ArrayList<Magazine>();
	
	public Lend() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Lendbook> getLendbooks() {
		return lendbooks;
	}

	public void setLendbooks(List<Lendbook> lendbooks) {
		this.lendbooks = lendbooks;
	}


	
	
}
