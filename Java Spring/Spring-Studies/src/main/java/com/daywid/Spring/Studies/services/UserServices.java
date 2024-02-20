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

/*
 * This class represents the User Services in the application.
 */
@Service
public class UserServices implements UserDetailsService
{    
   	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	UserRepository repository;
    /*
     * Constructor for the UserServices.
     * @param repository The user repository.
     */
    public UserServices(UserRepository repository)
    {
        this.repository = repository;
    }
    /*
     * Find a user by ID.
     * @param id the user ID.
     * @return the person value object
     * @throws ResourceNotFoundException if no record are found for the ID.
     */
	public PersonVO findById(Long id) 
    {	
		logger.info("Finding one person!");	
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
	}
    /*
     * Find a user by username.
     * @param username the user username.
     * @return the user details
     * @throws UsernameNotFoundException if the username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        logger.info("Finding one user by name!" + username + "!");
        var user = repository.findByUsername(username);    
        if(user != null)
        {
             return user;
        }
        else
        {
            throw new UsernameNotFoundException("username" + username + "Not found!");
        }
    }    
}
