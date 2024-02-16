package com.app.docker.docker.repository;

import com.app.docker.docker.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    //
}
