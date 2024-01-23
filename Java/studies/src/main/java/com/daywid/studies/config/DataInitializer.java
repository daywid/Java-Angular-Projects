package com.daywid.studies.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.daywid.studies.entity.User;
import com.daywid.studies.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){


            User user = new User();
        
            user.setEmail("teste@gmail.com");
            user.setName("Nome teste");

            userRepository.save(user);
        }
    }
    
}
