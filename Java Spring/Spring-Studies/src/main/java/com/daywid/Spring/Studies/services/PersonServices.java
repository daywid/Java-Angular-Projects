package com.daywid.Spring.Studies.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.daywid.Spring.Studies.controllers.PersonController;
import com.daywid.Spring.Studies.data.vo.v1.PersonVO;
import com.daywid.Spring.Studies.exceptions.RequiredObjectIsNullException;
import com.daywid.Spring.Studies.exceptions.ResourceNotFoundException;
import com.daywid.Spring.Studies.mapper.DozerMapper;
import com.daywid.Spring.Studies.models.Person;
import com.daywid.Spring.Studies.repositories.PersonRepository;

/*
 * This class represents the services for handling Person entities.
 */
@Service
public class PersonServices 
{	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	/*
	 * Retrieves all person entities.
	 * 
	 * @return List of PersonVO representing all person entities.
	 */
	public List<PersonVO> findAll() 
	{
		logger.info("Finding all people!");
		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		persons
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}
	/*
	 * Retrieves a specific person entity by ID.
	 * 
	 * @param id The ID of the person entity.
	 * @return PersonVO representing the person entity with the give ID.
	 * @throws ResourceNotFoundException if no record is found for the given ID.
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
	 * Creates a new person entity.
	 * 
	 * @param person The PersonVO object representing the new person entity.
	 * @return PersonVO representing the created person entity.
	 * @throws RequiredObjectIsNullException if the person parameter is null.
	 */
	public PersonVO create(PersonVO person) 
	{
		if (person == null) throw new RequiredObjectIsNullException();	
		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	/*
	 * Updates an existing person entity.
	 * 
	 * @param person the PersonVO object representing the updated person entity.
	 * @return PersonVO representing the updated person entity.
	 * @throws RequiredObjectIsNullException if the person parameter is null.
	 * @throws ResourceNotFoundException if no record is found for the given ID.
	 */
	public PersonVO update(PersonVO person) 
	{
		if (person == null) throw new RequiredObjectIsNullException();
		logger.info("Updating one person!");
		var entity = repository.findById(person.getKey())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	/*
	 * Deletes a person entity by ID.
	 * 
	 * @param id The ID of the person entity to be deleted.
	 * @throws ResourceNotFoundException if no record is found for the given ID.
	 */
	public void delete(Long id) 
	{	
		logger.info("Deleting one person!");	
		var entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}