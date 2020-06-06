package com.example.asd.controller;

import com.example.asd.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    PersonServiceImpl personService;

    @RequestMapping(value = "/index/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Person json){
        boolean user = personService.addPerson(json);
        return user;
    }

    @RequestMapping(value = "/index/delete", method = RequestMethod.POST)
    public boolean delete(@RequestParam String name){
        boolean user = personService.deletePerson(name);
        return user;
    }
}