package com.daywid.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daywid.studies.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
