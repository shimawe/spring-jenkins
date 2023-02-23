package com.jenkins.deployment.example.crud_1.repository;

import com.jenkins.deployment.example.crud_1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Person, String> {
}
