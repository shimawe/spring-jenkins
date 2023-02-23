package com.jenkins.deployment.example.crud_1.controller;

import com.jenkins.deployment.example.crud_1.model.Person;
import com.jenkins.deployment.example.crud_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<Person> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Person person) {
        userService.save(person);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }
}
