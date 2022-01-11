package com.example.springbootwithjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.springbootwithjpa.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}

}
