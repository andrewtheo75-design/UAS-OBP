package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
@Service
public class PersonService {
@Autowired
private PersonRepository personRepository;
public List<Person> getAllPerson() {
return personRepository.findAll();
}
public Person addPerson(Person obj) {
Long id = null;
obj.setId(id);
return personRepository.save(obj);
}
public Person getPersonById(long id) {
return personRepository.findById(id).orElse(null);
}
public Person updatePerson(long id, Person obj) {
obj.setId(id);
return personRepository.save(obj);
}
public void deletePerson(long id) {
personRepository.deleteById(id);
}
}