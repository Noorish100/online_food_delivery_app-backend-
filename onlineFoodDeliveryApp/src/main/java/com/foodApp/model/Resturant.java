package com.foodApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotNull(message = "Please provide Valid ResturantName")
	private String resturantName;
	@NotNull(message = "Please provide ManagerName")
	@Size(max = 25, message = "Please provide Valid ManagerName")
	private String managerName;
	@NotNull(message = "Please provide Phone Number")
	@Size(max = 12, min = 10, message = "Please provide Valid contactNo")
	private String contactNo;
	
	//private Address addr;
	
	//private List<Item> itemlist;
}
