package com.app.docker.docker.service;

import com.app.docker.docker.entity.Person;
import com.app.docker.docker.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository thePersonRepository){
        personRepository = thePersonRepository;
    }

    public List<Person> findAll(){
       return personRepository.findAll();
    }

    @Override
    public Person getOnePersonById(int personId) {
        Optional<Person> result = personRepository.findById(personId);

        Person thePerson = null;

        if(result.isPresent()){
            thePerson = result.get();
        }
        else {
            // we didnt find person
            throw new RuntimeException("Did not find person id " + personId);
        }
        return thePerson;
    }

    @Override
    public Person save(Person thePerson) {
        return personRepository.save(thePerson);
    }

    @Override
    public void deletePersonById(int personId) {
        personRepository.deleteById(personId);
    }


}
