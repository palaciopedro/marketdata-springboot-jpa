package com.springproject.salesdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.salesdb.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
