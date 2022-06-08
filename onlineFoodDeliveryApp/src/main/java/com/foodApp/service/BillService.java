package com.foodApp.service;

import com.foodApp.model.Bills;

import java.time.LocalDate;
import java.util.List;

public interface BillService {
    public Bills SaveBill(Bills bills);
    public Bills UpdateBill(Bills bills);
    public Bills removeBill(Bills bills);
    public List<Bills> billBetweenDate(LocalDate startDate, LocalDate EndDate);
//    public TotalBill viewBillByCustomerId(Integer CustomerId);

}
