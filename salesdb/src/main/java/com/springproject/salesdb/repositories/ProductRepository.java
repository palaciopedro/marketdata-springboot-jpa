package com.springproject.salesdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.salesdb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
