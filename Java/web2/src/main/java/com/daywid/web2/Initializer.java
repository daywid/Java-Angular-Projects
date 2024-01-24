package com.daywid.web2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.daywid.web2.entity.Role;
import com.daywid.web2.entity.User;
import com.daywid.web2.repository.RoleRepository;
import com.daywid.web2.repository.UserRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    
        Role role = new Role();

        role.setName("Admin");
        role.setStatus(StatusRole.ATIVO);

        Role role2 = new Role();

        role2.setName("Aluno");
        role2.setStatus(StatusRole.INATIVO);

        this.roleRepository.save(role);
        this.roleRepository.save(role2);

        User user = new User();

        user.setName("Nome");
        user.setEmail("email.com");
        user.setRole(role);

        this.userRepository.save(user);

        User user2 = new User();

        user2.setEmail("email2.com");
        user2.setName("Nome2");
        user2.setRole(role2);

        List<Role> roles = this.roleRepository.findByStatus(StatusRole.ATIVO);


    }
    
}
