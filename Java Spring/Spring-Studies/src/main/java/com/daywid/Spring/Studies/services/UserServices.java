package com.daywid.Spring.Studies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.daywid.Spring.Studies.controllers.PersonController;
import com.daywid.Spring.Studies.data.vo.v1.PersonVO;
import com.daywid.Spring.Studies.exceptions.ResourceNotFoundException;
import com.daywid.Spring.Studies.mapper.DozerMapper;
import com.daywid.Spring.Studies.repositories.UserRepository;

@Service
public class UserServices implements UserDetailsService{
    
   	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	UserRepository repository;

    public UserServices(UserRepository repository){
        this.repository = repository;
    }


	public PersonVO findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name!" + username + "!");
        var user = repository.findByUsername(username);
        
        if(user != null){
             return user;
        }else{
            throw new UsernameNotFoundException("username" + username + "Not found!");
        }
    }
	
    
}
