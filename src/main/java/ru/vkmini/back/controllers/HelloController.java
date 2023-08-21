package ru.vkmini.back.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vkmini.back.data.dto.Person;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/")
@RequiredArgsConstructor
public class HelloController{

    @GetMapping
    @Operation(summary = "Приветствие")
    public Person getUser(){
        Person user = new Person(1, "skoma@gmail.com", "12345", "Sergei", "s-koma");
        return user;

    }
}
