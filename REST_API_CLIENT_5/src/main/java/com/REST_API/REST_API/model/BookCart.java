package com.REST_API.REST_API.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOKCART")
public class BookCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Long id;
	@OneToOne(mappedBy="bookcart")
	public Book book;
	public int quantity;
	
	public BookCart() {
		
	}

	public BookCart(Book book, int quantity) {
		super();
//		this.id = id;
		this.book=book;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
}
