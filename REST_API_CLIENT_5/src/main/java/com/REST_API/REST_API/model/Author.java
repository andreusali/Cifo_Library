package com.REST_API.REST_API.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@PrimaryKeyJoinColumn(name = "AUTHOR")
@Table(name="AUTHOR")
public class Author extends Person{

	public String publisher; 

	@OneToMany(mappedBy = "author", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonIgnore
//	@JsonBackReference
	public List<Book> books = new ArrayList<Book>();
	

	public Author(Long id, String name, String countryoforigin, String dateofbirth, String publisher) {
		super(id, name, countryoforigin, dateofbirth);
		this.publisher=publisher;

	}

	public Author() {
		
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	




	
}