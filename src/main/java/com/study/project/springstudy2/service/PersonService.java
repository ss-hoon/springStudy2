package com.study.project.springstudy2.service;

import com.study.project.springstudy2.domain.Person;
import com.study.project.springstudy2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks(){
        List<Person> people = personRepository.findAll();

        return people.stream()
                .filter(person -> person.getBlock() == null)
                .collect(Collectors.toList());
    }
}
