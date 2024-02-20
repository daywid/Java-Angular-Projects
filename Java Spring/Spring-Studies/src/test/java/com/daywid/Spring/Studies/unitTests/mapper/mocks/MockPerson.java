package com.daywid.Spring.Studies.unitTests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;
import com.daywid.Spring.Studies.data.vo.v1.PersonVO;
import com.daywid.Spring.Studies.models.Person;

/*
 * This class provides mock data for unit tests related to the Person entity and PersonVO value object.
 */
public class MockPerson 
{
    /*
     * Returns a mocked Person entity with default values.
     * 
     * @return the mocked Person entity.
     */
    public Person mockEntity() 
    {
        return mockEntity(0);
    }
    /**
     * Returns a mocked PersonVO value object with default values.
     * 
     * @return The mocked PersonVO value object
     */
    public PersonVO mockVO() 
    {
        return mockVO(0);
    }
    
    /*
     * Returns a list of mocked Person entities with default values.
     * 
     * @return the list of mocked Person entities.
     */
    public List<Person> mockEntityList() 
    {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) 
        {
            persons.add(mockEntity(i));
        }
        return persons;
    }
    /*
     * Returns a list of mocked PersonVO value objects with default values.
     * 
     * @return the list of mocked PersonVO value objects.
     */
    public List<PersonVO> mockVOList() 
    {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) 
        {
            persons.add(mockVO(i));
        }
        return persons;
    }
    /*
     * Returns a mocked Person entity with custom values based on the given number.
     * 
     * @param number the number used to set the custom values.
     * @return the mocked Person entity with custom values
     */
    public Person mockEntity(Integer number) 
    {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    /*
     * Returns a mocked PersonVO value object with custom values based on the given number.
     * 
     * @param number The custom number to be used in the mocked PersonVO value object
     * @return The mocked PersonVO value object with custom values.
     */
    public PersonVO mockVO(Integer number) 
    {
        PersonVO person = new PersonVO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }
}