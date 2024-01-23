package com.daywid.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daywid.studies.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("select u from user where u.name = ?l")
    User findbyName(String name);

    User findByNameIgnoreCase(String name);

}
