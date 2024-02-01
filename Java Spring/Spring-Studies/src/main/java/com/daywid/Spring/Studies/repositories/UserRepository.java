package com.daywid.Spring.Studies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daywid.Spring.Studies.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    User findByUsername(@Param("userName") String username);
}
