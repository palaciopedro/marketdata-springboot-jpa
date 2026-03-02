package com.springproject.salesdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.salesdb.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
