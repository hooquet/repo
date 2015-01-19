package com.prototype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.dao.PersonDao;
import com.prototype.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public Person save(Person person) {
		return dao.save(person);
	}

	public Person find(Long id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	public List<Person> queryPersonList() {
		// TODO Auto-generated method stub
		return dao.getPeople();
	}
}
