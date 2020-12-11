package com.REST_API.REST_API.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="LENDBOOK")
public class Lendbook {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	public int datebegin;
	public int datefinish;
	public String status;

	@ManyToOne//, cascade=CascadeType.MERGE)//, fetch = FetchType.EAGER)
	@JsonIgnore	
	@JoinColumn(name = "LENDBOOK")
	public Lend lend;
	
	@ManyToOne//(mappedBy = "book")//, fetch = FetchType.EAGER)//(cascade=CascadeType.ALL)//(mappedBy="lendbook")//
	@JsonIgnore
	@JoinColumn(name = "LENDBOOK2")//, referencedColumnName = "id")
	public Book book;
	
//	@OneToMany(mappedBy="lendbook")//(cascade=CascadeType.ALL)//, fetch = FetchType.EAGER)//(mappedBy="lendbook", //, orphanRemoval = true)
//	@JsonIgnore
//	@JoinColumn(name = "BOOK_ID")//(LENDBOOK_ID)
//	public List<Book> books = new ArrayList<Book>();
	
//	@OneToMany(mappedBy="lendbook")//(cascade=CascadeType.ALL)//, fetch = FetchType.EAGER)//, orphanRemoval = true)
//	@JoinColumn(name = "LEND_ID")
//	@JsonIgnore
//	public List<Lend> lends = new ArrayList<Lend>();
	
	public Lendbook() {
		
	}

	public Lendbook(Long id, int datebegin, int datefinish, String status, Book book, Lend lend) {
		super();
		this.id = id;
		this.datebegin = datebegin;
		this.datefinish = datefinish;
		this.status = status;
		this.book = book;
		this.lend = lend;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDatebegin() {
		return datebegin;
	}

	public void setDatebegin(int datebegin) {
		this.datebegin = datebegin;
	}

	public int getDatefinish() {
		return datefinish;
	}

	public void setDatefinish(int datefinish) {
		this.datefinish = datefinish;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Lend getLend() {
		return lend;
	}

	public void setLend(Lend lend) {
		this.lend = lend;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	



}
