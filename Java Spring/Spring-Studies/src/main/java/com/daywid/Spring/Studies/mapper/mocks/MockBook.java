package com.daywid.Spring.Studies.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.daywid.Spring.Studies.data.vo.v1.BookVO;
import com.daywid.Spring.Studies.models.Book;

/*
 * This class provides methods to create mock entitites and value objects for testing purposes
 */
public class MockBook {
    /*
     * Creates a mock Book entity with default values
     * @return the mock Book entity
     */
    public Book mockEntity() 
    {
        return mockEntity(0);
    }
    /*
     * Creates a mock Book value object with default values
     * @return the mock Book value object
     */
    public BookVO mockVO() 
    {
        return mockVO(0);
    }
    /*
     * Creates a mock list of Books with default values
     * @return the mock list of Books
     */
    public List<Book> mockEntityList() 
    {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) 
        {
            books.add(mockEntity(i));
        }
        return books;
    }
    /*
     * Creates a list of mock Book value objects with default values
     * @return the list of mock Book value objects
     */
    public List<BookVO> mockVOList() 
    {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) 
        {
            books.add(mockVO(i));
        }
        return books;
    }
    /*
     * Creates a mock Book entity customized values based on the provided number.
     * @param number the number to customize the mock entity
     * @return the customized mock Book entity
     */
    public Book mockEntity(Integer number) 
    {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }
    /*
     * Creates a mock Book value object customized values based on the provided number.
     * @param number the number to customize the mock value object
     * @return the customized mock Book value object
     */
    public BookVO mockVO(Integer number) 
    {
        BookVO book = new BookVO();
        book.setKey(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }
}