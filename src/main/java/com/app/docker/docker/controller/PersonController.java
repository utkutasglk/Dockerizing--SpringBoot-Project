package com.app.docker.docker.controller;

import com.app.docker.docker.entity.Person;
import com.app.docker.docker.repository.PersonRepository;
import com.app.docker.docker.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;


    public PersonController (PersonService thePersonService){
        personService = thePersonService;
    }

    @GetMapping("/persons")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/persons/{personId}")
    public Person getOnePerson(@PathVariable int personId){
        return personService.getOnePersonById(personId);
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person thePerson){
        Person dbPerson = personService.save(thePerson);
        return dbPerson;
    }

    @PutMapping("/persons/{personId}")
    public Person updatePerson(@RequestBody Person thePerson){

        Person dbPerson = personService.save(thePerson);

        return dbPerson;
    }

    @DeleteMapping("persons/{personId}")
    public String deletePerson(@PathVariable int personId){
        Person tempPerson = personService.getOnePersonById(personId);

        // throw exception null
        if(tempPerson == null){
            throw new RuntimeException("Person id not found - " + personId);
        }

        personService.deletePersonById(personId);

        return "Deleted person id - " + personId;

    }


}
