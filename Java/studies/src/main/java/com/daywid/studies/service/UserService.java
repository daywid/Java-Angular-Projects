package com.daywid.studies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daywid.studies.entity.User;
import com.daywid.studies.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;



    public List<User>findAll(){
        
        return userRepository.findAll();

    }

}
