package com.foodApp.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.model.Resturant;
import com.foodApp.repository.ResturantDao;
import com.masai.exception.StudentException;
import com.masai.model.Student;

@Service
public class ResturantServiceImpl implements ResturantService{

	@Autowired
	private ResturantDao rdao;
	
	@Override
	public Resturant addResturant(Resturant res) {
		// TODO Auto-generated method stub
		return rdao.save(res);
	}

	@Override
	public Resturant updateResturant(Resturant res) {
		// TODO Auto-generated method stub
		
		Optional<Resturant> optR = rdao.findById(res.getResturantId());
		
		if(optR.isPresent()) {
			
			Resturant existingResturant= optR.get();
			
			return rdao.save(res);
		}
		return null;
	}
	
	
	@Override
	public Resturant removeResturant(Resturant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resturant viewResturant(Resturant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resturant> viewNearByResturant(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resturant> viewResturantByItemName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
