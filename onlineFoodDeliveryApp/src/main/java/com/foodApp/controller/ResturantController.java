package com.foodApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.model.Resturant;
import com.foodApp.service.ResturantService;
import com.foodApp.service.ResturantServiceImpl;


@RestController
public class ResturantController{
	
	@Autowired
	private ResturantService resSer;
	
	@PostMapping("/Resturant")
	public Resturant saveResturant(@Valid @RequestBody Resturant res) {
		
		Resturant r = resSer.addResturant(res);
		
		return r;
	}
	
	@GetMapping("/resturantId/{resturantId}")
	public Resturant getStudentByresturantId(@PathVariable ("resturantId") Integer rId) {
			
		return resSer.viewResturantByResturantId(rId);		
	}
	
	
	@DeleteMapping("/resturant/{resturantId}")
	public Resturant deleteResturant(@PathVariable ("resturantId") Integer rId){
		
		return resSer.removeResturant(rId);
	}
	
	
	@PutMapping("/resturant")
	public ResponseEntity<Resturant> updateResturant(@Valid @RequestBody Resturant rest){
		
		Resturant updatedResturant=resSer.updateResturant(rest);
		
		return new ResponseEntity<Resturant>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	
//	@PutMapping("/resturant/{resturantId}")
//	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,@RequestParam("marks") Integer marks) {
//		
//		Student updatedStudent = sService.updateStudentMarks(roll, marks);
//		
//		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
//		
//	}
			
	@GetMapping("/resturantById/{itemName}")
	public ResponseEntity<List<Resturant>> viewResturant(String name){
		List<Resturant> rest= resSer.viewResturantByItemName(name);
		
		return new ResponseEntity<List<Resturant>>(rest, HttpStatus.OK);
	}
	
	@GetMapping("/resturant/{location}")
	public ResponseEntity<List<Resturant>> viewResturantByLocation(String location){
		List<Resturant> rest= resSer.viewNearByResturant(location);
		
		return new ResponseEntity<List<Resturant>>(rest, HttpStatus.OK);
	}
	
}

//package com.foodApp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.foodApp.model.Resturant;
//import com.foodApp.service.ResturantService;
//
//@RestController
//public class ResturantController{
//	
//	@Autowired
//	private ResturantService resSer;
//	
//	@PostMapping("/Resturant")
//	public Resturant saveResturant(@RequestBody Resturant res) {
//		
//		Resturant r = resSer.addResturant(res);
//		
//		return r;
//	}
//}