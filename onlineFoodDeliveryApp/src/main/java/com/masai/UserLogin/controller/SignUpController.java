package com.masai.UserLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.masai.UserLogin.model.SignUp;
import com.masai.UserLogin.service.SignUpService;
import com.masai.model.Customer;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUp> createNewSignUpHandler(@RequestBody SignUp newSignUp) {
		
		SignUp newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<SignUp>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUp> updateSignUpDetailsHandler(@RequestBody SignUp signUp, @RequestParam(required=false) String key)
	{
		SignUp newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<SignUp>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

}