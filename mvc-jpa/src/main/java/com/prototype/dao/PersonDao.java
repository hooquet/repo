package com.prototype.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prototype.model.Person;

@Repository
public class PersonDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ogm-jpa-tutorial" );
	public static void main(String[] args ) {
		
		Person p = new Person();
		p.setId(123L);
		p.setFirstName("he");
		p.setLastName("");
		
		new PersonDao().save(p);
	}
	
	@PersistenceContext
	private EntityManager entityManager = emf.createEntityManager();
	
	public Person find(Long id) {
		return entityManager.find(Person.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {
		return entityManager.createQuery("select p from Person p").getResultList();
	}
	
	@Transactional
	public Person save(Person person) {
		if (person.getId() == null) {
			entityManager.persist(person);
			return person;
		} else {
			return entityManager.merge(person);
		}		
	}	
	
}
