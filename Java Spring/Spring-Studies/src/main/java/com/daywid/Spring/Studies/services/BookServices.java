package com.daywid.Spring.Studies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daywid.Spring.Studies.controllers.BookController;

import com.daywid.Spring.Studies.data.vo.v1.BookVO;
import com.daywid.Spring.Studies.exceptions.RequiredObjectIsNullException;
import com.daywid.Spring.Studies.exceptions.ResourceNotFoundException;
import com.daywid.Spring.Studies.mapper.DozerMapper;
import com.daywid.Spring.Studies.models.Book;
import com.daywid.Spring.Studies.repositories.BookRepository;
/*
 * This class represents the services for managin books.
 */
@Service
public class BookServices 
{    
    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
	BookRepository repository;
	/*
	 * Retrieves all books with links to their details.
	 * 
	 * @return List of BookVO with self links.
	 */
    public List<BookVO> findAll() 
	{
		logger.info("Finding all books!");
		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
		books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}
	/*
	 * Retrieves a specific book by ID with a link to its details.
	 * 
	 * @param id The id of the book.
	 * @return BookVO with self links.
	 */
    public BookVO findById(Long id) 
	{	
		logger.info("Finding one book!");	
		var entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
	/*
	 * Creates a new book with a link to its details.
	 * 
	 * @param book The book to be created.
	 * @return BookVO with self links.
	 * @throws RequiredObjectIsNullException if the input book is null
	 */
    public BookVO create(BookVO book) 
	{
		 if (book == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	/*
	 * Updates an existing book with a link to its details.
	 * 
	 * @param book the update book information
	 * @return BookVO with self links.
	 * @throws RequiredObjectIsNullException if the input book is null
	 * @throws ResourceNotFoundException if no record is found for the given ID
	 */
    public BookVO update(BookVO book) 
	{
		if (book == null) throw new RequiredObjectIsNullException();	
		logger.info("Updating one person!");
		var entity = repository.findById(book.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	/*
	 * Deletes a book by ID.
	 * 
	 * @param id The id of the book to be deleted.
	 * @throws ResourceNotFoundException if no record is found for the given ID
	 */
    public void delete(Long id) 
	{	
		logger.info("Deleting one books!");	
		var entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}