package com.springproject.salesdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.salesdb.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
