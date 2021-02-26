package com.study.project.springstudy2.repository;

import com.study.project.springstudy2.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("John");

        personRepository.save(person);

        List<Person> result = personRepository.findAll();

        assertThat(result.size()).isEqualTo(6);

        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween(){
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("benny");

        result.forEach(System.out::println);
    }
}
