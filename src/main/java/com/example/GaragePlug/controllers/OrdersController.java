package com.example.GaragePlug.controllers;

import com.example.GaragePlug.exception.ResourceNotFoundException;
import com.example.GaragePlug.model.Customers;
import com.example.GaragePlug.model.Orders;
import com.example.GaragePlug.repositories.CustomersRepository;
import com.example.GaragePlug.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersController{

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/customers/{customerid}/orders")
    public ResponseEntity<List<Orders>> getAllCommentsByTutorialId(@PathVariable(value = "customerid") Long customerid) {
        if (!customersRepository.existsById(customerid)) {
            throw new ResourceNotFoundException("Customer doesn't exist for given id: " + customerid);
        }

        List<Orders> orders = ordersRepository.findByCustomerID(customerid);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping("/customers/{customerid}/orders")
    public ResponseEntity<Orders> createComment(@PathVariable(value = "customerid") Long customerid,
                                                 @RequestBody Orders orderRequest) {
        Customers customer=customersRepository.findById(customerid).get();
            orderRequest.setCustomer(customer);
            if(customer.getCustType()!="Platinum")
            {
                //the efficiennt approach is to store the number of orderplaced in cutomers table itself and every time customer places an order,
                //just increment the order. But, running out of time
                List<Orders> orders = ordersRepository.findByCustomerID(customerid);
                if(orders.size()<10)
                {
                    customer.setCustType("Regular");
                    orderRequest.setTotalDiscount(0);
                }
                else if(orders.size()>=10 && orders.size()<20)
                {
                    customer.setCustType("Gold");
                    orderRequest.setTotalDiscount((orderRequest.getAmount()*10)/100);
                }
                else
                {
                    customer.setCustType("Platinum");
                    orderRequest.setTotalDiscount((orderRequest.getAmount()*20)/100);
                }
            }
            else{
                orderRequest.setTotalDiscount((orderRequest.getAmount()*20)/100);
            }
        Orders order =ordersRepository.save(orderRequest);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
