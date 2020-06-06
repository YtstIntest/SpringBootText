package com.example.asd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @RequestMapping(value = "/index/add", method = RequestMethod.POST)
    public String hello(){
        return "user撒打算打算打算";
    }

}