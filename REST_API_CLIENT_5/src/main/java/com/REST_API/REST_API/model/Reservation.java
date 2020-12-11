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

//@Entity
//@Table(name="RESERVATION")
////@PrimaryKeyJoinColumn(name = "BOOKID")
//public class Reservation { 
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
//	public Long id;
//	public String timestampreservation;
//	public int statusreservation;
//	public int sessionreservation;
//	
//	@OneToOne(cascade=CascadeType.ALL)
////	@JoinColumn(name = "BOOKCART")
//	public User user;
//	
//	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
//	public List<ReservationDetail> reservationdetails = new ArrayList<>();
//
//
//
//
//	
//
//	
//}