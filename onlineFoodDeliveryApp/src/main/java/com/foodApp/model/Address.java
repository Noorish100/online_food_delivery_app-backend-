package com.foodApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull
	private String buildingName;
	@NotNull
	private String streetNo;
	@NotNull
	private String area;
	@NotNull
	private String city;
	@NotNull
	private String State;
	@NotNull
	private String country;
	@NotNull
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pinCode;
	
	@JsonIgnore
	@OneToMany(cascade =  CascadeType.ALL )
	private Resturant rest;
}
