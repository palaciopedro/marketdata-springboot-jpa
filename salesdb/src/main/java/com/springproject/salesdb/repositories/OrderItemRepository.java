package com.springproject.salesdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.salesdb.entities.OrderItem;
import com.springproject.salesdb.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
