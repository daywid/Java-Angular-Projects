package com.daywid.studies.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.daywid.studies.entity.User;
import com.daywid.studies.repository.UserRepository;

/*
 * Initializes the data on application startup
 */


@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UserRepository userRepository;


    /*
     * Triggered when the application context is initialized or refreshed
     */

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){
           createUser("NomeTeste", "Emailteste@gmail.com");
           createUser("NomeTeste2", "Emteste222@gmail.com");
           createUser("NomeTest33", "Email333@gmail.com");

        }
        // userRepository.deleteById(2L);

        User user = userRepository.findbyName("NomeTeste");
        user.setName("testandoSET");
        userRepository.save(user);
    }

    /*
     * Creates a new user with the given name and email
     * 
     * @Param name the name of the user
     * @Param email the email of the user
     */

    public void createUser(String name, String email){

        User user = new User(name, email);
        userRepository.save(user);
    }

}
