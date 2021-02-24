package com.study.project.springstudy2.repository;

import com.study.project.springstudy2.domain.Person;
import com.study.project.springstudy2.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("martin");
        person.setAge(10);

        personRepository.save(person);
        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(0).getAge()).isEqualTo(10);
    }

    @Test
    void hashCodeAndEquals(){
        Person p1 = new Person("martin", 10, "A");
        Person p2 = new Person("martin", 10, "A");

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }

    @Test
    void findByBloodType(){
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenPerson("dennis", 8, "O");
        givenPerson("sophia", 7, "AB");
        givenPerson("benny", 6, "A");

        List<Person> result = personRepository.findByBloodType("A");

        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween(){
        givenPerson("martin", 10, "A", LocalDate.of(1991,8,3));
        givenPerson("david", 9, "B", LocalDate.of(1992,5,22));
        givenPerson("dennis", 8, "O", LocalDate.of(1993,3,25));
        givenPerson("sophia", 7, "AB", LocalDate.of(1994,10,4));
        givenPerson("benny", 6, "A", LocalDate.of(1995,8,21));

        List<Person> result = personRepository.findByMonthOfBirthday(2);
        result.forEach(System.out::println);
    }

    @Test
    private void givenPerson(String name, int age, String bloodType){
        Person person = new Person(name, age, bloodType);

        personRepository.save(person);
    }

    @Test
    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));

        personRepository.save(person);
    }
}
