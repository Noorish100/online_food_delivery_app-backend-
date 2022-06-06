package com.foodApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Resturant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resturantId;
	private String resturantName;
	private String managerName;
	private String contactNo;
	
	//private Address addr;
	
	private List<Item> itemlist;
}
