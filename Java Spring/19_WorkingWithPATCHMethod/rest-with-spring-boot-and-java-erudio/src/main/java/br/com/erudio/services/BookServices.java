package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.erudio.controllers.BookController;
import br.com.erudio.controllers.BookController;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Book;
import br.com.erudio.repositories.BookRepository;

/*
 * Service class for managing books
 */
@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository repository;

	@Autowired
	PagedResourcesAssembler<BookVO> assembler;

	/*
	 * Find all books with paging support.
	 * 
	 * @param pageable the pageable object
	 * @return PagedModel of EntityModel of BookVO
	 */
	public PagedModel<EntityModel<BookVO>> findAll(Pageable pageable) {

		logger.info("Finding all book!");

		var bookPage = repository.findAll(pageable);

		var bookVosPage = bookPage.map(p -> DozerMapper.parseObject(p, BookVO.class));
		bookVosPage.map(
			p -> p.add(
				linkTo(methodOn(BookController.class)
					.findById(p.getKey())).withSelfRel()));
		
		Link link = linkTo(
			methodOn(BookController.class)
				.findAll(pageable.getPageNumber(),
						pageable.getPageSize(),
						"asc")).withSelfRel();
		
		return assembler.toModel(bookVosPage, link);
	}

	/*
	 * Find one book by id
	 * 
	 * @param id the ID of the book
	 * @return the BookVO object
	 */
	public BookVO findById(Long id) {
		
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	/*
	 * Create a new book
	 * 
	 * @param book the bookVO object to be created
	 * @return the created BookVO object
	 */
	public BookVO create(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	/*
	 * Update a book.
	 * 
	 * @param book the BookVO object to update
	 * @return the updated BookVO object
	 */
	public BookVO update(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one book!");
		
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
	 * Delete a book by ID
	 * 
	 * @param the id of the book to be deleted
	 */
	public void delete(Long id) {
		
		logger.info("Deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
