package com.example.asd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonMapper personMapper;


    @Override
    public boolean addPerson(Person person) {

        return personMapper.insert(person);
    }

    @Override
    public int updatePerson(Person person) {
        // TODO Auto-generated method stub
        return personMapper.updateByPrimaryKey(person);
    }


    @Override
    public Person getPersonByname(String name) {

        return null;
    }

    @Override
    public boolean deletePerson(String name) {
        boolean state = personMapper.deleteByName(name);
        return state;
    }

}
