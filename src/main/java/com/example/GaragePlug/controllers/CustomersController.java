package com.example.GaragePlug.controllers;

import com.example.GaragePlug.model.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customers")
public class CustomersController {
 /*   @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<Customers> list() {
        return customerService.listAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> get(@PathVariable Integer id) {
        try {
            Customers customer = customerService.getCustomer(id);
            return new ResponseEntity<Customers>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Customers customer) {
        customerService.saveCustomer(customer);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody Customers user, @PathVariable Integer id) {
//        try {
//            Customers customer = customerService.getCustomer(id);
//            customer.setCustID(id);
//            customerService.saveCustomer(customer);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        customerService.deleteCustomer(id);
    }*/
}
