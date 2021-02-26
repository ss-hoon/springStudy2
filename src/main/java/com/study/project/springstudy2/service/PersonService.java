package com.study.project.springstudy2.service;

import com.study.project.springstudy2.domain.Person;
import com.study.project.springstudy2.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks(){
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name){
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        Person person = personRepository.findById(id).orElse(null);

        // System.out.println는 모든 로그가 다 찍힘
        // production 코드에는 부적합
        log.info("person : {}", person);

        return person;
    }

    @Transactional
    public void put(Person person){
        personRepository.save(person);
    }
}
