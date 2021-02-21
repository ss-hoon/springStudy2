package com.study.project.springstudy2.repository;

import com.study.project.springstudy2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
