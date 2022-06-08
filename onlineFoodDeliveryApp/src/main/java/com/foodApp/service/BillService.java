package com.foodApp.service;

import com.foodApp.model.Bill;
import java.time.LocalDate;
import java.util.List;

public interface BillService {
    public Bill SaveBill(Bill bill);
    public Bill UpdateBill(Bill bill);
    public Bill removeBill(Bill bill);
    public List<Bill> billBetweenDate(LocalDate startDate, LocalDate EndDate);
//    public TotalBill viewBillByCustomerId(Integer CustomerId);
}
