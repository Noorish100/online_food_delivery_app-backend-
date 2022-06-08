package com.foodApp.service;

import com.foodApp.Exception.BillNotFoundException;
import com.foodApp.model.Bills;
import com.foodApp.repository.BillDao;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;

    @Override
    public Bills SaveBill(Bills bills) {
        return billDao.save(bills);


    }

    @Override
    public Bills UpdateBill(Bills bills) {
        Optional<Bills> opt = billDao.findById(bills.getBillId());
        if (opt.isPresent()) {
            billDao.save(bills);
        }
        else throw new BillNotFoundException("Bill not found");
        return bills;
    }

    @Override
    public Bills removeBill(Bills bills) {

        Bills bls=billDao.findById(bills.getBillId()).orElseThrow(()-> new BillNotFoundException("Bill not Found"));
        billDao.delete(bills);
        return bls;


    }

    @Override
    public List<Bills> billBetweenDate(LocalDate startDate, LocalDate EndDate) {
        List<Bills> tb =billDao.findTotalBillsByBillDateBetween(startDate,EndDate);
        return tb;
    }

//    @Override
//    public TotalBill viewBillByCustomerId(Integer CustomerId) {
//        billDao.fi
//    }
}