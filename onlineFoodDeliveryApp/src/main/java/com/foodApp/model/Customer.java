package com.foodApp.model;

<<<<<<< HEAD
public class Customer {

}
=======
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addId")
	private Address address;
	
	private String email;
	

}

>>>>>>> 61507e18291983bfa005ed9e3437162dbfe7653e
