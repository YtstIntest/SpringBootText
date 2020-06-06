package com.example.asd.service;

public interface PersonService {
    Person getPersonByname(String name);

    boolean addPerson(Person person);

    int updatePerson(Person person);

    boolean deletePerson(String name);

}
