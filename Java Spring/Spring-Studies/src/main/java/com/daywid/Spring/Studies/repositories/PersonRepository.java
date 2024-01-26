package com.daywid.Spring.Studies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daywid.Spring.Studies.data.vo.v1.PersonVO;
import com.daywid.Spring.Studies.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
//allows all common database operations