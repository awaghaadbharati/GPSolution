package com.example.GaragePlug.repositories;

import com.example.GaragePlug.model.Customers;
import com.example.GaragePlug.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {


}
