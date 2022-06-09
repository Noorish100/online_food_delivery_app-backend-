package com.foodApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private String contactNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
	@JoinColumn(name="restaurantId")
	private List<Item> item = new ArrayList<>();
}