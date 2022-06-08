package com.foodApp.repository;

import com.foodApp.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer>{
	
    //public List<Bill> findByBillDate(LocalDate startDate, LocalDate endDate);
}
