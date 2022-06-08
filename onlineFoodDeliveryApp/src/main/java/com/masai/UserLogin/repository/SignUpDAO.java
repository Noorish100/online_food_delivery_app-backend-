package com.masai.UserLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.UserLogin.model.SignUp;

public interface SignUpDAO extends JpaRepository<SignUp,Integer> {
	
	public Optional<SignUp> findByUserName(String userName);

}
