package com.foodApp.service;

import com.foodApp.Exception.BillNotFoundException;

import com.foodApp.model.Customer;
import com.foodApp.model.OrderDetails;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServideIml implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Override
    public OrderDetails addOrders(OrderDetails orderDetails) {
        Optional<OrderDetails> opt = orderDao.findById(orderDetails.getOrderId());
        if (opt.isPresent()) {
            throw  new BillNotFoundException("Orders Already Exist");
        }
        else  orderDao.save(orderDetails);
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrders(OrderDetails orderDetails) {
        Optional<OrderDetails> opt = orderDao.findById(orderDetails.getOrderId());
        if (opt.isPresent()) {
            orderDao.save(orderDetails);
        }
        else   throw  new BillNotFoundException("Orders Already Exist");
        return orderDetails;
    }

    @Override
    public OrderDetails removeOrder(OrderDetails orderDetails) {

        OrderDetails orderDetails1=orderDao.findById(orderDetails.getOrderId()).orElseThrow(()-> new BillNotFoundException("Order not Found"));
        orderDao.delete(orderDetails1);
        return orderDetails1;
    }

    @Override
    public OrderDetails viewOrderById(Integer id) {
        OrderDetails orderDetails1=orderDao.findById(id).orElseThrow(()-> new BillNotFoundException("Order not Found"));

        return orderDetails1;
    }




}
