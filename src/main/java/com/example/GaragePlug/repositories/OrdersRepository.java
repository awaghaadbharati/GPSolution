package com.example.GaragePlug.repositories;

import com.example.GaragePlug.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByCustomerID(Long custID);
}
