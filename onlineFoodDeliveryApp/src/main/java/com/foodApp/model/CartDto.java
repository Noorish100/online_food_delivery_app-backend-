package com.foodApp.model;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDto {

	@NotNull
	private Integer itemId;
	
	private String itemName;
	
	private Double price;
	
	@Min(1)
	private Integer quantity;
}
