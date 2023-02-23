package com.jenkins.deployment.example.crud_1.service;

import com.jenkins.deployment.example.crud_1.model.Person;

import java.util.List;

public interface UserService {
    List<Person> getAll();
    Person getById(String id);
    void save(Person person);
    void deleteById(String id);
}
