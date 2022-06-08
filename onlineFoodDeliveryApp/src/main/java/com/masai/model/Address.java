package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	private Integer addressId;
	private String buildingName;
	private String streetNumber;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;

}
