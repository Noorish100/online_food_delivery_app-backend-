package com.foodApp.repository;

import com.foodApp.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface BillDao extends JpaRepository<Bills,Integer>{
	
    public List<Bills> findByBillDate(LocalDate startDate, LocalDate endDate);
}
