package com.jenkins.deployment.example.crud_1.service.impl;

import com.jenkins.deployment.example.crud_1.model.Person;
import com.jenkins.deployment.example.crud_1.repository.UserRepository;
import com.jenkins.deployment.example.crud_1.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Person> getAll() {
        log.info("Getting all users...");

        return userRepository.findAll();
    }

    @Override
    public Person getById(String id) {
        Person person = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " found!"));

        log.info("Get user by id: {}. Body: {}", id, person);
        return person;
    }

    @Override
    public void save(Person person) {
        Person newPerson = userRepository.save(person);
        log.info("Saved new user: {}", newPerson);
    }

    @Override
    public void deleteById(String id) {
        Person person = getById(id);
        userRepository.delete(person);

        log.info("User: {}, has been deleted!", person);
    }
}
