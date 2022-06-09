package com.masai.UserLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.UserLogin.model.LoginData;

public interface LoginDataDAO extends JpaRepository<LoginData,Integer>{

}
