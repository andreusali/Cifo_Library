package com.REST_API.REST_API.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="BOOK")
@PrimaryKeyJoinColumn(name = "BOOKID")
public class Book { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Long id;
	public String title;
	public int isbn;
	public int numberpages;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "BOOKCART")
	public BookCart bookcart;
	
	@ManyToOne//(mappedBy = "book")//, fetch = FetchType.EAGER)//(cascade=CascadeType.ALL)//(mappedBy="lendbook")//
//	@JsonIgnore
//	@JoinColumn(name = "LENDBOOK_ID")//, referencedColumnName = "id")
	Lendbook lendbook;
	
	@OneToMany(mappedBy="book")//, cascade=CascadeType.ALL, fetch = FetchType.EAGER)//(mappedBy="lendbook", //, orphanRemoval = true)
//	@JsonIgnore
//	@JoinColumn(name = "BOOK_ID")//(LENDBOOK_ID)
	public List<Lendbook> lendbooks = new ArrayList<Lendbook>();
	
	@ManyToOne//(cascade=CascadeType.MERGE)//, fetch = FetchType.EAGER)
//	@JsonIgnore
//	@JsonManagedReference
	@JoinColumn(name = "AUTHOR")
	public Author author;

	public Book(Long id, String title, int isbn, int numberpages, Author author) {
		super();
		this.id = id;
		this.title=title;
		this.isbn = isbn;
		this.numberpages = numberpages;
		this.author = author;
	}
	
	public Book() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getNumberpages() {
		return numberpages;
	}

	public void setNumberpages(int numberpages) {
		this.numberpages = numberpages;
	}

	public Lendbook getLendbook() {
		return lendbook;
	}

	public void setLendbook(Lendbook lendbook) {
		this.lendbook = lendbook;
	}

	public List<Lendbook> getLendbooks() {
		return lendbooks;
	}

	public void setLendbooks(List<Lendbook> lendbooks) {
		this.lendbooks = lendbooks;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}


	
}