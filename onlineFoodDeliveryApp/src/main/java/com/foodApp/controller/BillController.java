
package com.foodApp.controller;
import com.foodApp.model.Bill;
import com.foodApp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

    @RestController
    public class BillController {
        @Autowired
        private BillService billService;
        @PostMapping("/saveBill")
        public ResponseEntity<Bill> saveBill(@RequestBody Bill bills){

            return new ResponseEntity<>(billService.SaveBill(bills), HttpStatus.CREATED);
        }
        @PutMapping("/updateBills")
        public ResponseEntity<Bill> UpdateBill(@RequestBody Bill bills){
            return new ResponseEntity<>(billService.UpdateBill(bills),HttpStatus.ACCEPTED);
        }
        @PutMapping("/removeBill")
        public ResponseEntity<Bill> deleteBill(Bill bill){
            return  new ResponseEntity<>(billService.removeBill(bill),HttpStatus.OK);
        }
        @PutMapping("findbetweendates/{sDate}/{eDate}")
        public ResponseEntity<List<Bill>> billsbetweendates(@PathVariable LocalDate sDate,@PathVariable LocalDate eDate ){
            return new ResponseEntity<>(billService.billBetweenDate(sDate,eDate),HttpStatus.FOUND);
        }
    }

