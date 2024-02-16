package com.app.docker.docker.service;

import com.app.docker.docker.entity.Person;
import com.app.docker.docker.repository.PersonRepository;

import java.util.List;

public interface PersonService {

     List<Person> findAll();

     Person getOnePersonById(int personId);

     Person save(Person thePerson);

     void deletePersonById(int personId);
}
