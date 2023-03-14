package com.phcodegyan.H2DatabseSetup.repositories;

import com.phcodegyan.H2DatabseSetup.db.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRep extends CrudRepository<Person, Long> {
    List<Person> findAllById(Long id);

    List<Person> findAll();
}
