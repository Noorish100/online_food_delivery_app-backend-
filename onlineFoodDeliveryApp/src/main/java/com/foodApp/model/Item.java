package com.foodApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@NotNull(message = "Please provide itemName")
	@Size(max = 25, message = "Please provide Valid itemName")
	private String itemName;
	
	@NotNull(message = "Please provide Quantity")
	private Integer quantity;
	
	@NotNull(message = "Please provide Cost of Item")
	private Double cost;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resturantId")
	private Resturant res;

	@ManyToOne
	@JoinColumn(name = "cartId")
   // @JsonBackReference
    private Cart cart;
//	@JsonIgnore
//	@OneToMany
//	@JoinColumn(name = "resturantId")
//	private List<Resturant> resturant;
}