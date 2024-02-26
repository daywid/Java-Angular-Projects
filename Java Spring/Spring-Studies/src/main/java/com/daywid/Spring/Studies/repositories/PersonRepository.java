package com.daywid.Spring.Studies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daywid.Spring.Studies.models.Person;

/*
 * This interface represents the PersonRepository which extends JpaRepository.
 * It's responsible for handling all database operations related to the Person entity.
 * 
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    /*
     * This method disables a person in the database.
     * 
     * @param  id the ID of the person to be disabled
     * @return the disabled person
     */
    @Modifying 
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
    void disablePerson(@Param("id") Long id);
}
//allows all common database operations