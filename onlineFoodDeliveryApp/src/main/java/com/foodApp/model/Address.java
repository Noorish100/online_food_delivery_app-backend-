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
	
	@NotNull(message = "BuildingName cannot be null")
	private String buildingName;
	
	@NotNull(message = "StreetNo cannot be null")
	private String streetNo;
	
	@NotNull(message = "Area cannot be null")
	private String area;
	
	@NotNull(message = "City cannot be null")
	private String city;
	
	@NotNull(message = "State cannot be null")
	private String State;
	
	@NotNull(message = "Country cannot be null")
	private String country;
	
	@NotNull(message = "PinCode cannot be null")
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pinCode;
	
	@JsonIgnore
	@OneToMany(cascade =  CascadeType.ALL )
	private Resturant rest;
}
