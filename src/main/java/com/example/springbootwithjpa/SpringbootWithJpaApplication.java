package com.example.springbootwithjpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootwithjpa.dao.PersonJpaRepository;
import com.example.springbootwithjpa.entity.Person;

@SpringBootApplication
public class SpringbootWithJpaApplication implements CommandLineRunner{
	
	@Autowired
	private PersonJpaRepository personJpaRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personJpaRepository.findById(10001));
		System.out.println(personJpaRepository.findAll());
		personJpaRepository.deleteById(10002);
		System.out.println("inserting" +personJpaRepository.insert(new Person("mno", "abc", new Date())));
		System.out.println("updating" + personJpaRepository.update(new Person("mnop", "abc", new Date())));
		
	}


}
