package com.foodApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Resturant{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resturantId;
	@NotNull(message = "Please provide Valid ResturantName")
	private String resturantName;
	@NotNull(message = "Please provide ManagerName")
	@Size(max = 25, message = "Please provide Valid ManagerName")
	private String managerName;
	@NotNull(message = "Please provide Phone Number")
	@Size(max = 12, min = 10, message = "Please provide Valid contactNo")
	private String contactNo;
	
	//@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address addr;
	
//	@Embedded
//	private List<Item> itemlist = new ArrayList<Item>();
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "itemId")
	private List<Item> itemlist;
}
