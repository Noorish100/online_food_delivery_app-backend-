package com.foodApp.service;

import com.foodApp.Exception.BillNotFoundException;
import com.foodApp.model.Bill;
import com.foodApp.model.Customer;
import com.foodApp.model.Item;
import com.foodApp.repository.BillDao;
import com.foodApp.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Bill SaveBill(Bill bills) {
        Optional<Bill> opt = billDao.findById(bills.getBillId());
        if (opt.isPresent()) {
            throw  new BillNotFoundException("Bill Already Exist");
        }
        else  billDao.save(bills);
        return bills;

    }

    @Override
    public Bill UpdateBill(Bill bills) {
        Optional<Bill> opt = billDao.findById(bills.getBillId());
        if (opt.isPresent()) {
            billDao.save(bills);
        }
        else throw new BillNotFoundException("Bill not found");
        return bills;
    }

    @Override
    public Bill removeBill(Bill bills) {

        Bill bls=billDao.findById(bills.getBillId()).orElseThrow(()-> new BillNotFoundException("Bill not Found"));
        billDao.delete(bills);
        return bls;
    }

    @Override
    public String genrateBillByCustomerId(Integer customerId) {
        Customer customer=customerDAO.findById(customerId).orElseThrow(()-> new BillNotFoundException("Customer Not Found"));
       List<Item> orderlist= customer.getFoodCart().getItems();
       Double sum=0.0;
       for(Item i:orderlist){
          sum+= (i.getCost()*i.getQuantity());
       }
       return "[ Bill is for "+customer.getName()+" is "+sum+" ]";
    }


//    @Override
//    public TotalBill viewBillByCustomerId(Integer CustomerId) {
//        billDao.fi
//    }
}