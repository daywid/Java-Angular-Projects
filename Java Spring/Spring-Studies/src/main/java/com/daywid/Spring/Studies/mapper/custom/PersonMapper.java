package com.daywid.Spring.Studies.mapper.custom;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.daywid.Spring.Studies.data.vo.v2.PersonVOV2;
import com.daywid.Spring.Studies.models.Person;

/*
 * Mapper for converting between Person entity and PersonVOV2 value object
 */
@Service
public class PersonMapper 
{
    /*
     * Converts a Person entity to a PersonVOV2 value object
     * 
     * @param person the Person entity to convert
     * @return the converted PersonV0V2
     */
    public PersonVOV2 convertEntityToVO(Person person)
    {
        
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthday(new Date());
        
        return vo;
    }
    /*
     * Converts a PersonVOV2 value object to a Person entity
     * 
     * @param person the PersonVOV2 value object to convert
     * @return the converted Person entity
     */
    public Person convertVoToEntity(PersonVOV2 person)
    {    
        Person entity  = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        //vo.setBirthday(new Date());
        return entity;
    }
}
