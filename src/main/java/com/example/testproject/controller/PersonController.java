package com.example.testproject.controller;

import com.example.testproject.entity.Person;
import com.example.testproject.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
    public class PersonController {
        private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/users/save")
        public void personSave(@RequestBody Person person) {
            personRepository.save(person);

        }
}
