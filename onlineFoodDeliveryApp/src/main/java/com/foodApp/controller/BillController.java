package com.foodApp.controller;

import com.foodApp.model.Bills;
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
    BillService billService;
  @PostMapping("/saveBill")
    public ResponseEntity<Bills> saveBill(@RequestBody Bills bills){

      return new ResponseEntity<Bills>(billService.SaveBill(bills), HttpStatus.CREATED);

  }
      @PutMapping("/updateBills")
      public ResponseEntity<Bills> UpdateBill(@RequestBody Bills bills){
       return new ResponseEntity<Bills>(billService.UpdateBill(bills),HttpStatus.ACCEPTED);
      }
      @PutMapping("/removeBill")
   public ResponseEntity<Bills> deleteBill(Bills bills){
      return  new ResponseEntity<Bills>(billService.removeBill(bills),HttpStatus.OK);
   }
   @PutMapping("findbetweendates/{sDate}/{eDate}")
   public ResponseEntity<List<Bills>> billsbetweendates(@PathVariable LocalDate sDate,@PathVariable LocalDate eDate ){
        return new ResponseEntity<List<Bills>>(billService.billBetweenDate(sDate,eDate),HttpStatus.FOUND);
   }
}
