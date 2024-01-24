package com.daywid.web2;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.daywid.web2.entity.Functionality;
import com.daywid.web2.entity.Role;
import com.daywid.web2.entity.User;
import com.daywid.web2.repository.RoleRepository;
import com.daywid.web2.repository.UserRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    
        Functionality functionality = new Functionality();
        functionality.setName("Add");


        Role role = new Role("Admin", StatusRole.ATIVO, Arrays.asList(functionality));
        Role role3 = new Role("Admin", StatusRole.ATIVO, Arrays.asList(functionality));
        // this.roleRepository.save(role);

        User user = new User();

        user.setName("NomeTeste");
        user.setEmail("EmailTest");
        user.setRole(Arrays.asList(role));

        this.userRepository.save(user);

        List<User> users = this.userRepository.findAll();

        for (User user2 : users) {
            System.out.println(user.getRole());
        }

    }

}