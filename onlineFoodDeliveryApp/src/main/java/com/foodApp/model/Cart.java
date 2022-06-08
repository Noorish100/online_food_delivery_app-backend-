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
public class Cart {

	@Id
	private Integer cart_Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
<<<<<<< HEAD
	private Customer customer;
	
=======
//	private User user;

>>>>>>> 61507e18291983bfa005ed9e3437162dbfe7653e
	private Integer resturant_id;

	@OneToMany(cascade = CascadeType.ALL)
<<<<<<< HEAD
	private List<Item> items;
=======
	private List<Item> liItem;




>>>>>>> 61507e18291983bfa005ed9e3437162dbfe7653e
}
